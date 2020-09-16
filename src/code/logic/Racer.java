package code.logic;

import code.controllers.Controller;
import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import java.util.Random;

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
        transition.setRate(speed);
        transition.setOnFinished(event -> {
            System.out.println(racerName + " finished!");
        });
    }

    @Override
    public void run() {
        transition.setRate(speed);
        transition.play();
    }

    public void changeSpeed() {
        Random randomGenerator = new Random();
        double rate = randomGenerator.nextDouble() / 10;
        transition.setRate(rate);
    }

    public void changeAnimationState(boolean state) {
        if (state) {
            transition.pause();
        } else {
            transition.play();
        }
    }
}
