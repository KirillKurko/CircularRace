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

    private static int count;
    private static String result;

    @FXML
    public void startRace() {
        count = 0;
        result = "";
        createRacers();
        firstRacer.start();
        secondRacer.start();
        thirdRacer.start();
    }

    private void createRacers() {
        firstRacer = new Racer("Red", 0.1, firstRacerModel, biggestCircle);
        secondRacer = new Racer("Blue", 0.1, secondRacerModel, middleCircle);
        thirdRacer = new Racer("Green", 0.1, thirdRacerModel, smallestCircle);
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

    public static void showResultAlert(String name) {
        ++count;
        result += count + ". " + name + "\n";
        if (count == 3) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Results");
            alert.setHeaderText(result);
            alert.show();
        }
    }
}
