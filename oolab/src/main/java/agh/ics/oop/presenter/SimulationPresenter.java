package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    @FXML
    private Label infoLabel;
    @FXML
    private TextField movementsListTextField;
    @FXML
    private Label movementsDescriptionLabel;
    private WorldMap worldMap;

    public void setWorldMap(WorldMap map) {
        this.worldMap = map;
    }

    private void drawMap(WorldMap worldMap) {
        if (worldMap!=null)
            infoLabel.setText(worldMap.toString());
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(()-> {
            drawMap(worldMap);
            movementsDescriptionLabel.setText(message);
        });
    }

    public void onSimulationStartClicked() {
        String moveList = movementsListTextField.getText();
        String[] moves = moveList.split("");
        List<MoveDirection> directions;
        directions = OptionsParser.convertStringToMoveDirection(moves);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        RectangularMap worldMap = new RectangularMap(5, 5, 1);
        //setWorldMap(worldMap);
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        worldMap.addObserver(this);
        worldMap.addObserver(consoleMapDisplay);
        Simulation simulation = new Simulation(positions, directions, worldMap);
        ArrayList<Simulation> simulations = new ArrayList<>(List.of(simulation));
        SimulationEngine multipleSimulations = new SimulationEngine(simulations);
        multipleSimulations.runAsyncInThreadPool();
    }
}
