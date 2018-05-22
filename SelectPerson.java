/*
 * SelectPerson.java
*
 * Version 2.1
 *
 * Author name- Subbiksa Shanmugha Sundaram
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SelectPerson {
		public static void select(String title, String msg) {
		   Stage frame = new Stage();
		   //The window waits for the response of the user
    	   frame.initModality(Modality.APPLICATION_MODAL);
           frame.setTitle(title);
           frame.setWidth(300);
           //window's metrics set
           Label l1 = new Label(title);
           l1.setText(msg);
           //creation of comboBox
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
   		   choice.setPromptText("Choose a profile!");
   		   /*default text-combobox*/
   		choice.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
       	 System.out.println("User Selected : "+newValue) ;//retrieve values
        });
   		   //Select Button to select that profile
   		   Button select = new Button("Select the Profile");
   		   select.setOnAction(e -> selection(choice));
           VBox layout = new VBox(30);
           layout.getChildren().addAll(l1,choice,select);
           layout.setPadding(new Insets(30,30,30,30));
           layout.setAlignment(Pos.CENTER);
           Scene scene = new Scene(layout);
           frame.setScene(scene);
           //window waits for the user response-alertbox
           frame.showAndWait();
           }
		
	private static void selection(ComboBox<String> choice) {
		// retrieve value input by the user
		choice.setOnAction(e->{
			System.out.println("User Selected"+choice.getValue());
				
		});
				
	}
        
}