package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

class displayProfileTest {

    @start
    void onStart(Stage stage) {
        Button display = new Button("Display a Profile");
        display.setOnAction(actionEvent -> display.setText("display a profile"));
        stage.setScene(new Scene(new StackPane(display), 100, 100));
        stage.show();
    }

    @Test
    void should_contain_button() {
        // expect:
        assertEquals(".button","click me!");
    }

    
}