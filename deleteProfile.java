/*
 * deleteProfile.java
*
 * Version 2.1
 *
 * Author name- Subbiksa Shanmugha Sundaram
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class deleteProfile {
		       public static void delete(String title, String msg) {
		       /*window set*/
		       Stage frame = new Stage();
	           frame.initModality(Modality.APPLICATION_MODAL);
	           frame.setTitle(title);
	           frame.setWidth(300);
	           //label set to title and msg
	           Label l1= new Label(title);
	           l1.setText(msg);
	           //Button to delete the profile
	           Button delete = new Button("Delete the Profile");
	           delete.setOnAction(e -> {
	        	   Scanner in = new Scanner(System.in);
	        	   System.out.println("Enter your profile name: ");
	        	   String name = in.nextLine();  	   
	        	   try {
				    	// 1.connection  to database
				    	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
				    	// 2.creation of stats
				    	  Statement myst = mycon.createStatement(); 
				    	// 3. execution of sql 
				    	  String sql = "delete from profile where name=?";
				    	// 4. Process the resultset  
				    	  PreparedStatement pdStmt = mycon.prepareStatement(sql);
	        	    		// set param values
				    	   pdStmt.setString (1,name);
	        	    	   pdStmt.executeUpdate();
	        	    	   pdStmt.close();
	        	    	   System.out.println("Successfully deleted from Mininet");
	     		     		System.out.println("Profile Deleted!");
	        	    	   myst.close();
	        	           mycon.close(); 
				      }
				      catch(Exception ex) {
				    	  System.out.print("Local DB: Not Found!");
				    	  ex.printStackTrace();
				      }in.close();
			
	           });
	           //VerticalBox layout for the scene
	           VBox layout = new VBox(30);
	           layout.getChildren().addAll(l1,delete);
	           layout.setAlignment(Pos.CENTER);
	           Scene scene = new Scene(layout);
	           frame.setScene(scene);
	           frame.showAndWait();
	           }
	}

