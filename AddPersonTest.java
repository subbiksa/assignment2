package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

class AddPersonTest {

    @start
    void onStart(Stage stage) {
        Button add = new Button("Add a Profile");
        add.setOnAction(actionEvent -> add.setText("Add a profile"));
        stage.setScene(new Scene(new StackPane(add), 100, 100));
        stage.show();
    }

    @Test
    void should_contain_button() {
        // expect:
        assertEquals(".button","click me!");
    }

    
}