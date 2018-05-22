/*
 * AddPerson.java
*
 * Version 2.1
 *
 * Author name- Subbiksa Shanmugha Sundaram
 */
package application;

import java.sql.DriverManager;
import allExceptions.*;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AddPerson {
	 static boolean response;
	 /*can accept only true and false*/
	 static java.sql.Connection mycon = null;
	 static java.sql.Statement myst = null;
	 //Connection strings-SQL
	 public static boolean close(String title, String msg) {
	       //Window Creation
		   Stage frame = new Stage();
           frame.initModality(Modality.APPLICATION_MODAL);
           frame.setTitle(title);
           frame.setWidth(300);
           //Label l1 with title
           Label l1 = new Label(title);
           l1.setText(msg);
           /*handles the Button if the choice is yes-true*/
           Button yes = new Button("Add details on the console");
           yes.setOnAction(e-> 
           {
        	   response=true;
        	   @SuppressWarnings("resource")
			   Scanner in = new Scanner(System.in);
        	   System.out.println("Enter your profile name: ");
        	   String name =in.nextLine();
        	   System.out.println("Enter your Age: ");
        	   Integer age = in.nextInt();
        	   System.out.println("Enter your status: ");
        	   String job = in.nextLine();
        	   System.out.println("Enter your state: ");
        	   String state = in.nextLine();
        	   System.out.println("Enter your image: ");
        	   String image = in.nextLine();
        	   System.out.println("Enter your phNo: ");
        	   String num = in.nextLine();
        	   try {
        	    	// 1.connection  to database
        	    	   mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
        	    	   if(mycon!=null) {
        	    		   System.out.println("Connection Success");
        	    	   }else {System.out.println("Local Database Not Found!");}
        	    	   // 2.creation of statements
        	    	   String sql = "insert into profile(id,name, age, job,state, image)" + " values (?,?,?,?,?,?)";
        	    	   PreparedStatement pdStmt = mycon.prepareStatement(sql);
        	    		// set parametrized values for preparedStatement
        	    	   pdStmt.setString(1,num);
        	    	   pdStmt.setString (2,name);
        	    	   pdStmt.setLong (3,age);
        	    	   //NoSuchAgeException implemented if the user tries to input value of age=0 or >150
        	    	   if(age<0||age>150) {
        	    		   try {
        	    			   throw new NoSuchAgeException("Age Invalid!");
        	    		   }
        	    		   catch(NoSuchAgeException exc)
        	    		   {
        	    			   System.out.println(exc);
        	    		   }
        	    		   } 
        	    	   pdStmt.setString (4,job);
        	    	   pdStmt.setString( 5,state);
        	    	   pdStmt.setString (6,image);
       				// 3. Execute SQL query
        	    		pdStmt.execute();
     		     		System.out.println("Successfully inserted");
     		     		System.out.println("New Profile Added to the Network!");
        	    	   myst.close();
        	           mycon.close();
        	        // Close DB Connection
        		}
        	      catch(Exception e1) {
        	    	   //System.out.print("Local DB: Found!"); 
        	      } 
               frame.close();
           });
           /*handles action if false*/
           Button no = new Button("Dont Add and Exit");
           no.setOnAction(e -> {
        	   response=false;
               frame.close();
        	   });
           VBox layout= new VBox(30);
           layout.getChildren().addAll(l1,yes,no);
           layout.setAlignment(Pos.CENTER);
           Scene scene= new Scene(layout);
           frame.setScene(scene);
           frame.showAndWait();
           return response;
           }
}
