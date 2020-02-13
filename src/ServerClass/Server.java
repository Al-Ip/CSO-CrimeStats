/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClass;

/**
 *
 * @author alexi
 */
import Classes.Database;
import Classes.Userreports;
import java.io.ObjectInputStream;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

// Server class 
public class Server {

    public static void main(String[] args) throws IOException {
        // server is listening on port 5056 
        ServerSocket ss = new ServerSocket(5000);

        // running infinite loop for getting 
        // client request 
        while (true) {
            Socket s = null;

            try {
                // socket object to receive incoming client requests 
                s = ss.accept();

                System.out.println("[SERVER] - A new client is connected : " + s);

                // obtaining input and out streams 
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

                System.out.println("[SERVER] - Assigning new thread for this client");

                // create a new thread object 
                Thread t = new ClientHandler(s, in, out);

                // Invoking the start() method 
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}

// ClientHandler class 
class ClientHandler extends Thread {

    final ObjectInputStream in;
    final ObjectOutputStream out;
    final Socket s;

    // Constructor 
    public ClientHandler(Socket s, ObjectInputStream in, ObjectOutputStream out) {
        this.s = s;
        this.in = in;
        this.out = out;
    }

    @Override
    // This is where the client tells to the server what function to run based off a switch statement and a string
   // that is sent from the client. Each function runs on a different thread.
    public void run() {
        Database db = new Database();
        boolean loop = true;
        String rec;
        while (loop) {
            try {
                rec = this.in.readUTF();
                switch (rec) {

                    case "Insert":
                        try {
                            insertToDatabase();
                            break;
                        } catch (EOFException e) {
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    case "Refresh":
                        try {
                            retrieveFromDatabase();
                            break;
                        } catch (EOFException e) {
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    case "Delete":
                        try {
                            removeFromDatabase();
                            break;
                        } catch (EOFException e) {
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    case "BeforeUpdate":
                        try {
                            beforeUpdateFromDatabase();
                            break;
                        } catch (EOFException e) {
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    case "Update":
                        try {
                            UpdateFromDatabase();
                            break;
                        } catch (EOFException e) {
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    case "Chart":
                        try {
                            ChartData();
                            break;
                        } catch (EOFException e) {
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    default:
                        out.writeUTF("Invalid input");
                        break;
                }
            } catch (EOFException e) {
                break;
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // This is to stop the loop once a function has been completed
                loop = false;
            }
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Insert into database function
    //
    // Here I used a prepared statement that will insert the data received from the client and outputs back a success message 
    // containing the new id 
    public void insertToDatabase() throws SQLException, IOException {
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        ResultSet rs = null;

        try {
            // get connection to database
            conn = getcon();
            while (true) {
                try {
                    Userreports received = (Userreports) this.in.readObject();
                    String query1 = "INSERT INTO userreports (Region, GardaDivision, OffenceCode, Offence, TypeOfOffence, Date, numOfOffences)"
                            + " values (?, ?, ?, ?, ?, ?, ?)";
                        //NOTE since the table id are auto generated i used RETURN_GENERATED_KEYS in the insert statement
                    //this allows me to retrieve the key easily
                    preparedStmt = conn.prepareStatement(query1,
                            Statement.RETURN_GENERATED_KEYS);
                    preparedStmt.setString(1, received.getRegion());
                    preparedStmt.setString(2, received.getGardaDivision());
                    preparedStmt.setInt(3, received.getOffenceCode());
                    preparedStmt.setString(4, received.getOffence());
                    preparedStmt.setString(5, received.getTypeOfOffence());
                    preparedStmt.setString(6, received.getDate());
                    preparedStmt.setInt(7, received.getNumOfOffences());
                    // execute the preparedstatement
                    preparedStmt.execute();
                    // get the generated key and set it
                    try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            received.setId(generatedKeys.getInt(1));
                        }
                    }
                    // write back to client sending the newly created id
                    String text = "User Inserted a crime into the database, ID: " + received.getId();
                    this.out.writeUTF(text);
                    this.out.flush();
                    break;
                } catch (EOFException e) {
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
        } //Close Connections
        finally {
            if (this.out != null)
                this.out.close();
            if (this.in != null) 
                this.in.close();
            if (preparedStmt != null) 
                preparedStmt.close();
            if (rs != null) 
                rs.close();
            if (conn != null) 
                conn.close();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Remove from database function
    //
    // The client sends the selected row id to here where a simple prepared statement with a where clause will find the record
    // in the database and remove it accordingly. Also the removed id is sent back to the client as confirmation.
    public void removeFromDatabase() throws SQLException, IOException {
        // Initialize variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement preparedStmt = null;
        int clientID = 0;

        try {
            // get connection to database
            conn = getcon();
            while (true) {
                try {
                    String query1 = "DELETE FROM userreports WHERE id=?";

                    // reading in the selected id from the client and converted into int for the statement
                    clientID = Integer.parseInt(in.readUTF());
                    // prepared statement
                    preparedStmt = conn.prepareStatement(query1);
                    preparedStmt.setInt(1, clientID);

                    // execute prepared statement
                    preparedStmt.executeUpdate();
                    // write back to client the deleted id as confirmation that the specified id was indeed deleted
                    this.out.writeInt(clientID);
                    this.out.flush();
                    break;
                } catch (EOFException e) {
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //Close Connections
        finally {
            if (this.out != null) 
                this.out.close();
            if (this.in != null) 
                this.in.close();
            if (stmt != null)
                stmt.close();
            if (rs != null) 
                rs.close();
            if (conn != null) 
                conn.close();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Retreive from database function
    //
    // The server runs the statement selecting all records from the table, the result set allows us to retreive the data which is 
    // then sent back to the client and placed inside a table model which creates a new object (making a new row) after every rs.next()
    public void retrieveFromDatabase() throws SQLException, IOException {
        // Initialize variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // get connection to database
            conn = getcon();
            while (true) {
                try {
                    String query1 = "SELECT * FROM userreports";

                    // create statement
                    stmt = conn.createStatement();
                    // execute statement 
                    rs = stmt.executeQuery(query1);

                    while (rs.next()) {
                        String one = rs.getString("id");
                        String two = rs.getString("Region");
                        String three = rs.getString("GardaDivision");
                        int four = rs.getInt("OffenceCode");
                        String five = rs.getString("Offence");
                        String six = rs.getString("TypeOfOffence");
                        String seven = rs.getString("Date");
                        int eight = rs.getInt("numOfOffences");

                        this.out.writeUTF(one);
                        this.out.writeUTF(two);
                        this.out.writeUTF(three);
                        this.out.writeInt(four);
                        this.out.writeUTF(five);
                        this.out.writeUTF(six);
                        this.out.writeUTF(seven);
                        this.out.writeInt(eight);
                            // NOTE should i flush after every write or just once at the end here?
                        // this.out.flush();
                    }
                    break;
                } catch (EOFException e) {
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //Close Connections
        finally {
            if (this.out != null)
                this.out.close();
            if (this.in != null) 
                this.in.close();
            if (stmt != null)
                stmt.close();
            if (rs != null)
                rs.close();
            if (conn != null) 
                conn.close();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  Before Update from database function
    //
    //  The Client sends the selected id from the update table here where it will set a userreports object and send back to
    //  the client where it will set the update form textfields with the correct data
    public void beforeUpdateFromDatabase() throws SQLException, IOException {
        // Initialize variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement preparedStmt = null;
        int clientID = 0;

        try {
            // get connection to database
            conn = getcon();
            while (true) {
                try {
                    String query = "SELECT * FROM userreports WHERE id=?";

                    clientID = Integer.parseInt(in.readUTF());
                    // prepared statement
                    preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setInt(1, clientID);

                    rs = preparedStmt.executeQuery();

                    while (rs.next()) {
                        String two = rs.getString("Region");
                        String three = rs.getString("GardaDivision");
                        int four = rs.getInt("OffenceCode");
                        String five = rs.getString("Offence");
                        String six = rs.getString("TypeOfOffence");
                        String seven = rs.getString("Date");
                        int eight = rs.getInt("numOfOffences");

                        // place all the selected data into a Userreport object so that the client receives the specific 
                        // data relating to the id queried 
                        out.writeObject(new Userreports(two, three, four, five, six, seven, eight));
                        out.flush();
                    }
                    break;
                } catch (EOFException e) {
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //Close Connections
        finally {
            if (this.out != null)
                this.out.close();
            if (this.in != null) 
                this.in.close();
            if (stmt != null) 
                stmt.close();
            if (rs != null) 
                rs.close();
            if (conn != null) 
                conn.close();
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  Update from database function
    //
    //  The client sends the newly inputed textfields from the update form here where each field 
    // will be executed as a prepared statement and a confirmation message will be sent back to the client containing the newly
    // updated ID
    public void UpdateFromDatabase() throws SQLException, IOException {
        // Initialize variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement preparedStmt = null;
        int clientID = 0;

        try {
            // get connection to database
            conn = getcon();
            while (true) {
                try {
                    String query = "UPDATE  userreports SET Region=?, GardaDivision=?, OffenceCode=?, Offence=?, TypeOfOffence=?, Date=?, numOfOffences=? "
                            + "WHERE id=?";

                    Userreports received = (Userreports) this.in.readObject(); //Read in object from the client
                    clientID = Integer.parseInt(in.readUTF());  // read in the selected column id 
                    // prepared statement
                    preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, received.getRegion());
                    preparedStmt.setString(2, received.getGardaDivision());
                    preparedStmt.setInt(3, received.getOffenceCode());
                    preparedStmt.setString(4, received.getOffence());
                    preparedStmt.setString(5, received.getTypeOfOffence());
                    preparedStmt.setString(6, received.getDate());
                    preparedStmt.setInt(7, received.getNumOfOffences());
                    preparedStmt.setInt(8, clientID);
                    
                    preparedStmt.executeUpdate();
                    
                    // Write back to clinet the id 
                    this.out.writeInt(clientID);
                    this.out.flush();
                    break;       
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //Close Connections
        finally {
            if (this.out != null) 
                this.out.close();
            if (this.in != null) 
                this.in.close();
            if (stmt != null) 
                stmt.close();
            if (rs != null) 
                rs.close();
            if (conn != null) 
                conn.close();
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  Populate the various Charts with data from database function
    //
    // Here some fields from the database are retrieved in order to populate the chart with data (This can further be expanded
    // into more functions allowing for different types of data to be displayed for different types of charts)
    public void ChartData() throws SQLException, IOException {
        // Initialize variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement preparedStmt = null;

        try {
            // get connection to database
            conn = getcon();
            while (true) {
                try {
                    String query = "SELECT Offence, numOfOffences, Date FROM userreports";

                    preparedStmt = conn.prepareStatement(query);
                    rs = preparedStmt.executeQuery();
                    while (rs.next()) {
                        String type = rs.getString("Offence");
                        int numOffences = rs.getInt("numOfOffences");
                        String date = rs.getString("Date");
                        
                        out.writeUTF(type);
                        out.writeInt(numOffences);
                        out.writeUTF(date);
                        out.flush();
                    }
                    this.out.flush();
                    break;       
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //Close Connections
        finally {
            if (this.out != null)
                this.out.close();
            if (this.in != null) 
                this.in.close();
            if (stmt != null) 
                stmt.close();
            if (rs != null)
                rs.close();
            if (conn != null) 
                conn.close();
        }
    }

    //To fix Connection closed Error
    public Connection getcon() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/irish_crime", "root", "");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("[SERVER] - couldn't connect!");
            throw new RuntimeException(ex);
        }
    }

    
}
