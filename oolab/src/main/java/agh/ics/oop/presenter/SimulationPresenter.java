package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationPresenter {
    @FXML
    private TextField movementsListTextField;
    private final ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();

    public void onSimulationStartClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation_view.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationViewPresenter presenter = loader.getController();
        Stage stage = new Stage();
        configureStage(stage, viewRoot);

<<<<<<< HEAD
=======
    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    private void drawHeaders() {
        Boundary bounds = worldMap.getCurrentBounds();
        int lowerLeftX = bounds.lowerLeft().getXValue();
        int lowerLeftY = bounds.lowerLeft().getYValue();
        int upperRightX = bounds.upperRight().getXValue();
        int upperRightY = bounds.upperRight().getYValue();

        for(int row=lowerLeftY; row<=upperRightY; row++){
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_SIZE));
            Label label = new Label();
            label.setText(String.valueOf(row));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label, 0, upperRightY-row+1);
        }

        for(int column=lowerLeftX ; column<=upperRightX; column++){
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_SIZE));
            Label label = new Label();
            label.setText(String.valueOf(column));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.add(label, column+1-lowerLeftX, 0);
        }

        mapGrid.getRowConstraints().add(new RowConstraints(CELL_SIZE));
        mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_SIZE));
        Label label = new Label();
        label.setText(" y\\x ");
        GridPane.setHalignment(label, HPos.CENTER);
        mapGrid.add(label, 0, 0);
    }

    private void drawMap() {
        infoLabel.setText("");
        clearGrid();
        Boundary bounds = worldMap.getCurrentBounds();
        int lowerLeftX = bounds.lowerLeft().getXValue();
        int lowerLeftY = bounds.lowerLeft().getYValue();
        int upperRightX = bounds.upperRight().getXValue();
        int upperRightY = bounds.upperRight().getYValue();
        drawHeaders();

        for (int i=lowerLeftX; i<=upperRightX; i++) {
            for (int j=lowerLeftY; j<=upperRightY; j++) {
                WorldElement worldElement = worldMap.objectAt(new Vector2d(i, j));
                if (worldElement!=null) {
                    Label elemLabel = new Label(worldElement.toString());
                    mapGrid.add(elemLabel, i-lowerLeftX+1, upperRightY-j+1);
                    GridPane.setHalignment(elemLabel, HPos.CENTER);
                }
            }
        }
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(()-> {
            drawMap();
            movementsDescriptionLabel.setText(message);
        });
    }

    public void onSimulationStartClicked() {
>>>>>>> 3742db90577bb2ef4e38370bf98617d1879bd0f7
        String moveList = movementsListTextField.getText();
        String[] moves = moveList.split("");
        List<MoveDirection> directions;
        directions = OptionsParser.convertStringToMoveDirection(moves);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        GrassField worldMap = new GrassField(10);
        worldMap.addObserver(presenter);
        worldMap.addObserver(consoleMapDisplay);
        presenter.setWorldMap(worldMap);
        Simulation simulation = new Simulation(positions, directions, worldMap);
        ArrayList<Simulation> simulations = new ArrayList<>(List.of(simulation));
        SimulationEngine multipleSimulations = new SimulationEngine(simulations);
        multipleSimulations.runAsync();

        stage.show();
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
