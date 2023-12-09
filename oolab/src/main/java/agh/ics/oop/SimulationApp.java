package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();
        configureStage(primaryStage, viewRoot);
        //primaryStage.show();

        String[] args = getParameters().getRaw().toArray(new String[0]);
        List<MoveDirection> directions;
        directions = OptionsParser.convertStringToMoveDirection(args);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 3), new Vector2d(3, 4)));
        RectangularMap worldMap1 = new RectangularMap(5, 5, 1);
        presenter.setWorldMap(worldMap1);
        //GrassField worldMap2 = new GrassField(10, 2);
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        worldMap1.addObserver(consoleMapDisplay);
        worldMap1.addObserver(presenter);
        //worldMap2.addObserver(consoleMapDisplay);
        Simulation simulation1 = new Simulation(positions, directions, worldMap1);
        //Simulation simulation2 = new Simulation(positions, directions, worldMap2);
        ArrayList<Simulation> simulations = new ArrayList<>(List.of(simulation1));
        SimulationEngine multipleSimulations = new SimulationEngine(simulations);
        multipleSimulations.runAsyncInThreadPool();
        multipleSimulations.awaitSimulationsEnd();
        primaryStage.show();
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
