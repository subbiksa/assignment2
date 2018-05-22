package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

class ExitAppTest {

    @start
    void onStart(Stage stage) {
        Button exit = new Button("exit");
        exit.setOnAction(actionEvent -> exit.setText("Exit the App"));
        stage.setScene(new Scene(new StackPane(exit), 100, 100));
        stage.show();
    }

    @Test
    void should_contain_button() {
        // expect:
        assertEquals(".button","click me!");
    }

    
}