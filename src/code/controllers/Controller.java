package code.controllers;

import code.logic.Racer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
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

    @FXML
    private ToggleButton changeAnimationStateButton;

    @FXML
    private Button changeSpeedButton;

    private Racer firstRacer;
    private Racer secondRacer;
    private Racer thirdRacer;

    public static String result;

    @FXML
    public void startRace() throws InterruptedException {
        result = "";
        createRacers();
        firstRacer.start();
        secondRacer.start();
        thirdRacer.start();
    }

    @FXML
    public void changeSpeed() {
        firstRacer.changeSpeed();
        secondRacer.changeSpeed();
        thirdRacer.changeSpeed();
    }

    @FXML
    public void changeAnimationState() {
        boolean state = changeAnimationStateButton.isSelected();
        changeSpeedButton.setDisable(state);
        if (state) {
            changeAnimationStateButton.setText("Play");
        }
        else {
            changeAnimationStateButton.setText("Pause");
        }
        firstRacer.changeAnimationState(state);
        secondRacer.changeAnimationState(state);
        thirdRacer.changeAnimationState(state);
    }

    private void createRacers() {
        firstRacer = new Racer("first", 0.1, firstRacerModel, biggestCircle);
        secondRacer = new Racer("second", 0.1, secondRacerModel, middleCircle);
        thirdRacer = new Racer("third", 0.1, thirdRacerModel, smallestCircle);
    }



    public synchronized static void finish(Racer racer) {
        result += racer.getRacerName() + " ";
    }
}
