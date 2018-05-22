/*
 * Main.java
 *
 * Version 2.1
 *
 * Author name- Subbiksa Shanmugha Sundaram
 */
package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MiniNet extends Application {
	/* creation of window */
	Stage frame;
	Scene Profile,AddProfile;
	
	public void start(Stage primaryStage) {
		frame= primaryStage;
		//label1
		Label label1 = new Label("Welcome to MININET!");
		/* Add Button- handles action on add button*/
		Button addProfile = new Button("Add a new profile to Mininet!");
		addProfile.setOnAction(e -> {
			boolean answer = (boolean) AddPerson.close("Add a profile", "Are you sure to Add?");
			System.out.println(answer);
		});
		/* select Button- handles action on selectProfile button*/
		Button selectProfile = new Button("Select a profile");
		selectProfile.setOnAction(e->{
			SelectPerson.select("Make a selection of the Profile,", "Select a Person From Mininet");
		});
		/* View Button- handles action on view button*/
		Button view = new Button("Display a profile");
		view.setOnAction(e->{
			displayProfile.display("Display", "View the profiles on Mininet");
		});
		/* Delete Button- handles action on delete button*/
		Button delete = new Button("Delete a profile");
		delete.setOnAction(e->{
			 deleteProfile.delete("Delete", "Deletion of profiles on Mininet");
		});
		Button Connection = new Button("Connect a profile");
		Connection.setOnAction(e->{
			 Connect.connection("Connect", "Make new connections and check the connections on Mininet");
		});
		Button Relation = new Button("View the parents of Children");
		Relation.setOnAction(e->{
			 Parent_Children.relation("Connect", "Make new connections and check the connections on Mininet");
		});
		
		/* Add Button- handles action on add button*/
		Button exit = new Button("Close Application");
		exit.setOnAction(e -> ExitApp.close("Exit Mininet","Close and Exit Mininet"));
		// primary layout of the VerticalBox
		VBox primarylayout = new VBox(20);
		primarylayout.setAlignment(Pos.CENTER);
		primarylayout.getChildren().addAll(label1,addProfile,selectProfile,view,delete,Connection,Relation,exit);
		Profile = new Scene(primarylayout,500,500); 
		// Button
		Button view1 = new Button("Add a new Profile to Mininet");
		StackPane layout2 = new StackPane();	
		layout2.getChildren().add(view1);
		AddProfile = new Scene(layout2,600,300);
		// The layout added
		frame.setScene(Profile);
		frame.setTitle("MININET");
		frame.show();
		}
	public static void main(String[] args) {
		launch(args);//Main Method
	}
}
