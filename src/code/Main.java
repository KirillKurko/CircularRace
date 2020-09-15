package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent rootNode = FXMLLoader.load(getClass().getResource("/resources/fxml/layout.fxml"));
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Circular race");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



