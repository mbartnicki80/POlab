package agh.ics.oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class SimulationApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
<<<<<<< HEAD
        BorderPane viewRoot = loader.load();
        configureStage(primaryStage, viewRoot);
=======
        BorderPane viewRoot = loader.load(); //s
        SimulationPresenter presenter = loader.getController();
        configureStage(primaryStage, viewRoot);
        GrassField worldMap = new GrassField(10);
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        worldMap.addObserver(consoleMapDisplay);
        worldMap.addObserver(presenter);
        presenter.setWorldMap(worldMap);
>>>>>>> 3742db90577bb2ef4e38370bf98617d1879bd0f7
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
