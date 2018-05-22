package application;
/**
* 
*  
* @author  Richa Rawat
* @version 2.0
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class Parent_Children {
       public static void relation(String title, String msg) {
    	   Stage frame= new Stage();
           frame.initModality(Modality.APPLICATION_MODAL);
           frame.setTitle(title);
           frame.setWidth(300);
           Label l1= new Label(title);
           l1.setText(msg);
           Button viewParents = new Button("View Parents");//to display parents of a child input by the user
   		   Button viewChildren = new Button("View Children");//to display children of a couple input by the user
   		   viewParents.setOnAction(e -> {
   			  Scanner sc= new Scanner(System.in);
				 System.out.println("Enter name of child");
				 String child= sc.nextLine();
				
				try {
			    	// 1.connection  to database
			    	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
			    	// 2.creation of stats
			    	  Statement myst = mycon.createStatement(); 
			    	// 3. execution of sql 
			    	  
			    	  ResultSet myres = myst.executeQuery("select * from Parent where childname='"+ child +"'");
			    	// 4. Process the resultset  
			          while(myres.next()) {
			        	  System.out.println(myres.getString("mothername"));
			        	  System.out.println(myres.getString("fathername"));
				}}
			   catch(Exception e1) {
			    	  System.out.println("Parents of the child");
			    	  //e.printStackTrace();
			}
			
		});
   		viewChildren.setOnAction(e-> {
				Scanner sc= new Scanner(System.in);
				 System.out.println("Enter name of father");
				 String father= sc.nextLine();
				 System.out.println("Enter name of mother");
				 String mother= sc.nextLine();
				
				try {
			    	// 1.connection  to database
			    	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
			    	// 2.creation of stats
			    	  Statement myst = mycon.createStatement(); 
			    	// 3. execution of sql 
			    	  ResultSet myres = myst.executeQuery("select childname from Parent where fathername= '"+ father +"'" + "and mothername = '" +mother+ "'");
			    	// 4. Process the resultset  
			          while(myres.next()) {
			        	  System.out.println(myres.getString("childname"));
}
				}
				catch(Exception e2) {
			    	  System.out.println(e2);
			    	  //e.printStackTrace();	
	                  }
   		});
           VBox layout= new VBox(30);
           layout.getChildren().addAll(l1,viewParents,viewChildren);
           layout.setAlignment(Pos.CENTER);
           Scene scene= new Scene(layout);
           frame.setScene(scene);
           frame.showAndWait();
   		}
       }