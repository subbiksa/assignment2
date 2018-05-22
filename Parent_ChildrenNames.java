package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
* 
*  
* @author  Richa Rawat
* @version 2.0
* @classDescription Displays the parents of a child in Mininet social network and children of a couple  
*                   extending Application class to show JavaFX functionality .
* 					 
* 
*/
public class Parent_ChildrenNames extends Application {
	public static void main(String args[]) {
        launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button viewParents = new Button("View Parents");//to display parents of a child input by the user
		Button viewChildren = new Button("View Children");//to display children of a couple input by the user
		Button closebt = new Button("View Children");//to close the button

		closebt.setOnAction(e -> System.exit(0));
		viewParents.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Scanner sc= new Scanner(System.in);
				 System.out.println("Enter name of child");
				 String child= sc.nextLine();
				
				try {
			    	// 1.connection  to database
			    	  Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mininet?autoReconnect=true&useSSL=false","root","root"); 
			    	// 2.creation of stats
			    	  Statement myst = mycon.createStatement(); 
			    	// 3. execution of sql 
			    	  ResultSet myres = myst.executeQuery("select fathername, mothername from Parent where childname = '"+ child +"'");
			    	// 4. Process the resultset  
			          while(myres.next()) {
			        	  System.out.println(myres.getString("fathername, mothername"));
}
				}
				catch(Exception e) {
			    	  System.out.println(e);
			    	  //e.printStackTrace();
			}
			}
		});
		viewChildren.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
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
			    	  ResultSet myres = myst.executeQuery("select childname from Parent where fathername = '"+ father +"'" + "and mothername = '" + mother + "'");
			    	// 4. Process the resultset  
			          while(myres.next()) {
			        	  System.out.println(myres.getString("child"));
}
				}
				catch(Exception e) {
			    	  System.out.println(e);
			    	  //e.printStackTrace();	
	}

				VBox root= new VBox();
				root.getChildren().addAll(viewParents,viewChildren,closebt);
				Scene scene = new Scene(root,500,500);
				primaryStage.setTitle("Mininet-Social Network");
				primaryStage.setScene(scene);
				primaryStage.show();
		}
		});
	}
}
