/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author alexi
 */
public final class Database {
    public boolean connected;
    
    public Database() {
        this.connected = false;
        getcon();
    }
    
    //To enable the radio button in the title form
    public Connection getcon() {
        try {
            connected=true;
            return DriverManager.getConnection("jdbc:mysql://localhost/irish_crime", "root", "");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("couldn't connect!");
            throw new RuntimeException(ex);
        }
    }
    
}
