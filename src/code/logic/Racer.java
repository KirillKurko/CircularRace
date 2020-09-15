package code.logic;

import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Racer extends Thread {

    private String racerName;
    private double speed;
    private Circle model;
    private Circle path;

    public Racer(String racerName, double speed, Circle model, Circle path) {
        this.racerName = racerName;
        this.speed = speed;
        this.model = model;
        this.path = path;
    }

    public String getRacerName() {
        return racerName;
    }

    public double getSpeed() {
        return speed;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPath(Circle path) {
        this.path = path;
    }

    @Override
    public void run() {
        PathTransition transition = new PathTransition();
        transition.setNode(model);
        transition.setDuration(Duration.seconds(speed));
        transition.setPath(path);
        transition.play();
    }
}
