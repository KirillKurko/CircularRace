package code;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Circle circle = new Circle(10);
        circle.setCenterX(300);
        circle.setCenterY(250);
        circle.setRadius(20);

        Circle path = new Circle(200);
        path.setCenterX(300);
        path.setCenterY(250);

        PathTransition transition = new PathTransition();
        transition.setNode(circle);
        transition.setDuration(Duration.seconds(5));
        transition.setPath(path);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.play();



        Group root = new Group(circle);

        Scene scene = new Scene(root, 600, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Drawing a circle");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}



