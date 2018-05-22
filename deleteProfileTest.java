package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

class deleteProfileTest {

    @start
    void onStart(Stage stage) {
        Button delete= new Button("Delete a Profile");
        delete.setOnAction(actionEvent -> delete.setText("Delete a profile"));
        stage.setScene(new Scene(new StackPane(delete), 100, 100));
        stage.show();
    }

    @Test
    void should_contain_button() {
        // expect:
        assertEquals(".button","click me!");
    }

    
}