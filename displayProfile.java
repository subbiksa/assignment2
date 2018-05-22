/*
 * displayProfile.java
*
 * Version 2.1
 *
 * Author name- Subbiksa Shanmugha Sundaram
 */
package application;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import com.mysql.jdbc.Statement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class displayProfile {
	  
	 static java.sql.Connection mycon = null;
	 static Statement myst = null;
	 /*SQL - usage initialisation*/
     public static void display(String title, String msg) {
		// display method to display the Profile selected
		Stage frame = new Stage();
        frame.initModality(Modality.APPLICATION_MODAL);
        frame.setTitle(title);
        frame.setWidth(300);
        //label set with title value from main
        Label l1 = new Label(title);
        ComboBox<String> choice = new ComboBox<>();
        choice.getItems().addAll(
				   "Profile1-Chandler Bing",
				   "Profile2-Joey Bing",
				   "Profile3-Phoebe Bing",
				   "Profile4-Rachel Geller",
				   "Profile5-Ross Geller",
				   "Profile6-Monica Geller",
				   "Profile7-Richa Rawat",
				   "Profile8-Subbiksa Sundaram"
				    );
		   choice.setPromptText("Choose a profile!");//Prompt an input
		   choice.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
		          System.out.println("User Selected : "+newValue) ;
           });
		   //select and display-profile chosen
		   Button select=new Button("Display the selected Profile details!");
		   select.setOnAction(e ->{
			   Scanner in = new Scanner(System.in);
        	   System.out.println("Enter the profile name: ");
        	   String name = in.nextLine();
        	   String name1 = "Chandler Bing";
        	   String name2 = "Joey Bing";
        	   String name3 = "Phoebe Bing";
        	   String name4 = "Rachel Geller";
        	   String name5 = "Ross Geller";
        	   String name6 = "Monica Geller";
        	   String name7 = "Richa Rawat";
        	   String name8 = "Subbiksa Sundaram";
        	   /*handles the if condition to check for two strings*/
        	   if(name.equals(name1)) {
        	   try {
			    	// 1.connection  to database
			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
			    	// 2.creation of stats
			    	  java.sql.Statement myst = mycon.createStatement(); 
			    	// 3. execution of sql 
			    	  ResultSet myres = myst.executeQuery("select * from profile where id = 1");
			    	// 4. Process the resultset  
			          while(myres.next()) {
			        	  System.out.println(myres.getString("name"));
			        	  System.out.println(myres.getString("age"));
			        	  System.out.println(myres.getString("job"));
			        	  System.out.println(myres.getString("state"));
			         	  System.out.println(myres.getString("image"));    
			          }
			      }
			      catch(Exception e1) {
			    	  e1.printStackTrace();
			      }
        	   frame.close();
        	   //close the window
        	   in.close();
        	   //close the scanner
        	   }
        	   if(name.equals(name2)) {
            	   try {
    			    	// 1.connection  to database
    			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
    			    	// 2.creation of stats
    			    	  java.sql.Statement myst = mycon.createStatement(); 
    			    	// 3. execution of sql 
    			    	  ResultSet myres = myst.executeQuery("select * from profile where id = 2");
    			    	// 4. Process the resultset  
    			          while(myres.next()) {
    			        	  System.out.println(myres.getString("name"));
    			        	  System.out.println(myres.getString("age"));
    			        	  System.out.println(myres.getString("job"));
    			        	  System.out.println(myres.getString("state"));
    			        	  System.out.println(myres.getString("image"));    
    			          }
    			      }
    			      catch(Exception e1) {
    			    	  e1.printStackTrace();
    			      }
            	   frame.close();
            	   in.close();
            	   }
        	   if(name.equals(name3)) {
            	   try {
    			    	// 1.connection  to database
    			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
    			    	// 2.creation of stats
    			    	  java.sql.Statement myst = mycon.createStatement(); 
    			    	// 3. execution of sql 
    			    	  ResultSet myres = myst.executeQuery("select * from profile where id =3");
    			    	// 4. Process the resultset  
    			          while(myres.next()) {
    			        	  System.out.println(myres.getString("name"));
    			        	  System.out.println(myres.getString("age"));
    			        	  System.out.println(myres.getString("job"));
    			        	  System.out.println(myres.getString("state"));
    				          System.out.println(myres.getString("image"));    
    			          }
    			      }
    			      catch(Exception e1) {
    			    	  e1.printStackTrace();
    			      }
            	   frame.close();
            	   in.close();
            	   }
        	   if(name.equals(name4)) {
            	   try {
    			    	// 1.connection  to database
    			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
    			    	// 2.creation of stats
    			    	  java.sql.Statement myst = mycon.createStatement(); 
    			    	// 3. execution of sql 
    			    	  ResultSet myres = myst.executeQuery("select * from profile where id = 4");
    			    	// 4. Process the resultset  
    			          while(myres.next()) {
    			        	  System.out.println(myres.getString("name"));
    			        	  System.out.println(myres.getString("age"));
    			        	  System.out.println(myres.getString("job"));  
    			        	  System.out.println(myres.getString("state"));
    				          System.out.println(myres.getString("image"));    
    			          }
    			      }
    			      catch(Exception e1) {
    			    	  e1.printStackTrace();
    			      }
            	   frame.close();
            	   in.close();
            	   }
        	   if(name.equals(name5)) {
            	   try {
    			    	// 1.connection  to database
    			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
    			    	// 2.creation of stats
    			    	  java.sql.Statement myst = mycon.createStatement(); 
    			    	// 3. execution of sql 
    			    	  ResultSet myres = myst.executeQuery("select * from profile where id = 5");
    			    	// 4. Process the resultset  
    			          while(myres.next()) {
    			        	  System.out.println(myres.getString("name"));
    			        	  System.out.println(myres.getString("age"));
    			        	  System.out.println(myres.getString("job"));
    			        	  System.out.println(myres.getString("state"));
    			        	  System.out.println(myres.getString("image"));    
    			          }
    			      }
    			      catch(Exception e1) {
    			    	  e1.printStackTrace();
    			      }
            	   frame.close();
            	   in.close();
            	   }
        	   if(name.equals(name6)) {
            	   try {
    			    	// 1.connection  to database
    			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
    			    	// 2.creation of stats
    			    	  java.sql.Statement myst = mycon.createStatement(); 
    			    	// 3. execution of sql 
    			    	  ResultSet myres = myst.executeQuery("select * from profile where id = 6");
    			    	// 4. Process the resultset  
    			          while(myres.next()) {
    			        	  System.out.println(myres.getString("name"));
    			        	  System.out.println(myres.getString("age"));
    			        	  System.out.println(myres.getString("job")); 
    			        	  System.out.println(myres.getString("state"));	
    			        	  System.out.println(myres.getString("image"));    
    			          }
    			      }
    			      catch(Exception e1) {
    			    	  e1.printStackTrace();
    			      }
            	   frame.close();
            	   in.close();
            	   }
        	   if(name.equals(name7)) {
            	   try {
    			    	// 1.connection  to database
    			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
    			    	// 2.creation of stats
    			    	  java.sql.Statement myst = mycon.createStatement(); 
    			    	// 3. execution of sql 
    			    	  ResultSet myres = myst.executeQuery("select * from profile where id = 7");
    			    	// 4. Process the resultset  
    			          while(myres.next()) {
    			        	  System.out.println(myres.getString("name"));
    			        	  System.out.println(myres.getString("age"));
    			        	  System.out.println(myres.getString("job"));
    			        	  System.out.println(myres.getString("state"));
       			        	  System.out.println(myres.getString("image"));    
    			          }
    			      }
    			      catch(Exception e1) {
    			    	  System.out.print("Local DB: Not Found!");
    			    	  e1.printStackTrace();
    			      }
            	   frame.close();
            	   in.close();
        	   }	
        	   if(name.equals(name8)) {
            	   try {
    			    	// 1.connection  to database
    			    	  java.sql.Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
    			    	// 2.creation of stats
    			    	  java.sql.Statement myst = mycon.createStatement(); 
    			    	// 3. execution of sql 
    			    	  ResultSet myres = myst.executeQuery("select * from profile where id = 6");
    			    	// 4. Process the resultset  
    			          while(myres.next()) {
    			        	  System.out.println(myres.getString("name"));
    			        	  System.out.println(myres.getString("age"));
    			        	  System.out.println(myres.getString("job"));
    			        	  System.out.println(myres.getString("state"));
    				          System.out.println(myres.getString("image"));    
    			          }
    			      }
    			      catch(Exception e1) {
    			    	  e1.printStackTrace();
    			      }
            	   frame.close();
            	   in.close();
            	   }
        	  
		   });   
	   /*vertical Box layout*/
	   VBox layout = new VBox(30);
       layout.getChildren().addAll(l1,choice,select);
       layout.setPadding(new Insets(30,30,30,30));
       layout.setAlignment(Pos.CENTER);
       Scene scene = new Scene(layout);
       frame.setScene(scene);
       frame.showAndWait();
      
       }
}