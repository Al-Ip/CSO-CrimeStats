# CSO-CrimeStats-Application
Java - Client/ Server Application

NOTE!!!-------
Please run the "Server.java" class first then run "TitleForm.java" to launch the GUI

Features
  •	Client server application.
  •	Each interaction with the database is on a separate thread in the server class
  •	Most (if not all) the functions in the server class is retrieving / storing / updating data to the “userreports” table in the           database.
  •	There is a “userreports” class that works as a way to pass data from client to server (and vice versa) as objects.
  
 Client / GUI
  •	Title Screen (with a radio button checking if the connection to the database is valid, if not the application will not allow you to     enter into the home form).
  •	Home form with card layouts for the panels (this allows for seamless transitions when user clicks on a different button)
  •	The “MainForm” is the main client that communicates to the server.
  
Insert Stats
  •	The “insert stats” button will display a form that allows the user to input a new crime into the database.
  •	The user cannot hit accept on the user form until every field in the form is imputed with relevant data.
  •	If the user clicks “cancel” button all the fields will cleared of the user inputs.
  •	There is validation on the text fields / selection boxes. (A label will appear on right hand side of textfield if the user tries to     enter an invalid type of character etc. If the textfield can only take an integer the label will appear alerting them of that)
  •	Also, the user cannot enter a string character in an integer textfield as there is a key typed function in the client that listens       to the users input and if its invalid it just won’t type into the textfield and the label from above will appear alerting them. 
  •	Once the insert is successful a panel will appear alerting the user of the newly created ID.
  
Remove Stats
  •	The remove stats option will remove a field from the database.
  •	The user is asked to click refresh button as this is to populate the JTable with the data from the database.
  •	Once that is done the user can select a field and click delete button to process the deletion of that selected field.
  •	The JTable contents is not editable.
  •	The JTable can sort the values from the database by clicking on a respective column.
  •	NOTE the delete button will not be enabled until the user selects a field from the table
  •	Once the delete button is clicked a “success” label will appear above the table alerting the user of the deletion and asking them to     refresh the table once again in order to see the change.

Update  Stats
  •	The update stats works the same as the remove.
  •	The user must click refresh to populate the table before deleting.
  •	NOTE if a user clicks the refresh on the remove table (or vice versa on the update table) first, the other table will populate the       data also BUT the user will not be allowed to delete or update a field until they click the refresh again for that process they wish     to perform.
  •	The JTable can also not be edited.
  •	The JTable can also be sorted like the remove.
  •	Also, the update button will not become enabled until the user selects a field from the table.
  •	Once the user clicks on a field in the table and hits the update button the update form will appear (just like the insert form) and     populate the textfields / selection boxes with the relevant data the user wished to perform an update on.
  •	This form also has the same validation as the insert form and will not allow the user to click accept until at least one change is       made to any textfield.
  •	Once the update was successful the user is redirected back to the update table and a success message will appear (just like the         remove table success message) above the table alerting the user of which ID was updated and asked to click refresh again in order to     see the change.

View Stats
  •	NOTE I added the JFXFrame to a regular swing JFrame in order to display the graphs.
  •	The chart frames are resizable.
  •	The user has an option between Bar chart and Pie chart at the moment.
  •	The data is populated from the database table “userreports” and shown in each of the charts respectively.
  •	Pie chart that visually displays the statistics of the various crimes committed.
  •	Bar chart that visually displays the statistics of the various crimes committed.


Libraries Used
  •	mysql-connector-java-8.0.15.jar
  •	jfreechart-1.0.19\lib\jfreechart-1.0.19.jar
  •	jfreechart-1.0.19\lib\jcommon-1.0.23.jar
  •	All used libraries are located in the folder containing the project.
  •	SQL file in the folder also.
