package code.controllers;

import code.core.Racer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    @FXML
    private Button startButton;

    private Racer firstRacer;
    private Racer secondRacer;
    private Racer thirdRacer;

    private static int position;

    @FXML
    public void startRace() {
        position = 0;
        createRacers();
        firstRacer.start();
        secondRacer.start();
        thirdRacer.start();
    }

    private void createRacers() {
        firstRacer = new Racer("first", 0.1, firstRacerModel, biggestCircle);
        secondRacer = new Racer("second", 0.1, secondRacerModel, middleCircle);
        thirdRacer = new Racer("third", 0.1, thirdRacerModel, smallestCircle);
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
        setChangeAnimationStateButtonText(state);
        changeRacersAnimationState(state);
    }

    private void setChangeAnimationStateButtonText(boolean state) {
        if (state) {
            changeAnimationStateButton.setText("Play");
        }
        else {
            changeAnimationStateButton.setText("Pause");
        }
    }

    private void changeRacersAnimationState(boolean state) {
        firstRacer.changeAnimationState(state);
        secondRacer.changeAnimationState(state);
        thirdRacer.changeAnimationState(state);
    }

    public static void showAlert(String name) {
        ++position;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Results");
        alert.setHeaderText(name + " finished!\nPosition: " + position);
        alert.show();
    }
}
