package application;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class ExitApp {
       public static void close(String title, String msg) {
    	   Stage frame= new Stage();
           frame.initModality(Modality.APPLICATION_MODAL);
           frame.setTitle(title);
           frame.setWidth(300);
           Label l1= new Label(title);
           l1.setText(msg);
           Button exit=new Button("Exit the Mininet");
           exit.setOnAction(e -> System.exit(0));
           VBox layout= new VBox(30);
           layout.getChildren().addAll(l1,exit);
           layout.setAlignment(Pos.CENTER);
           Scene scene= new Scene(layout);
           frame.setScene(scene);
           frame.showAndWait();
           }
}
