package code.logic;

import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Racer extends Thread {

    private String racerName;
    private double speed;
    private Circle model;
    private Circle path;
    private PathTransition transition;

    public Racer(String racerName, double speed, Circle model, Circle path) {
        this.racerName = racerName;
        this.speed = speed;
        this.model = model;
        this.path = path;
        initializePathTransition();
    }

    private void initializePathTransition() {
        transition = new PathTransition();
        transition.setNode(model);
        transition.setPath(path);
        transition.setDuration(Duration.seconds(speed));
    }

    public String getRacerName() {
        return racerName;
    }

    @Override
    public void run() {
        transition.play();
    }

    public void changeSpeed() {
        transition.setRate(3);
    }
}
