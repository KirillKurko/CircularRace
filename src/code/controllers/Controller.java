package code.controllers;

import code.logic.Racer;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private Circle biggestCircle;

    @FXML
    private Circle middleCircle;

    @FXML
    private Circle smallestCircle;

    @FXML
    private Circle firstRacerModel;

    @FXML
    private Circle secondRacerModel;

    @FXML
    private Circle thirdRacerModel;

    private Racer firstRacer;
    private Racer secondRacer;
    private Racer thirdRacer;

    public void initialize() {
        firstRacer = new Racer("first", 0.1, firstRacerModel, biggestCircle);
        secondRacer = new Racer("second", 0.1, secondRacerModel, middleCircle);
        thirdRacer = new Racer("third", 0.1, thirdRacerModel, smallestCircle);
    }

    @FXML
    private void startRace() {
        System.out.println("Race started");
        firstRacer.run();
        secondRacer.run();
        thirdRacer.run();
    }

    @FXML
    private void changeSpeed() {
        System.out.println("Speed changed");
        firstRacer.changeSpeed();
        secondRacer.changeSpeed();
        thirdRacer.changeSpeed();
    }
}
