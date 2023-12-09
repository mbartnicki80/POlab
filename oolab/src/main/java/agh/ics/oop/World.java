package agh.ics.oop;
import agh.ics.oop.model.*;
import javafx.application.Application;

import java.util.*;

public class World {

    static void start() {
        System.out.println("System wystartowal");
    }

    static void stop() {
        System.out.println("System zakonczyl dzialanie");
    }

    public static void main(String[] args) {
        try {
            start();
            Application.launch(SimulationApp.class, args);
            /*List<MoveDirection> directions;
            directions = OptionsParser.convertStringToMoveDirection(args);
            RandomSimulationGenerator generatedSimulations = new RandomSimulationGenerator(directions, 1);
            List<Simulation> simulations = new ArrayList<>();
            for (Simulation generatedSimulation : generatedSimulations)
                simulations.add(generatedSimulation);
            SimulationEngine multipleSimulations = new SimulationEngine(simulations);
            //multipleSimulations.runSync();
            //multipleSimulations.runAsync();
            multipleSimulations.runAsyncInThreadPool();
            multipleSimulations.awaitSimulationsEnd();*/
            stop();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            stop();
        }
    }
}
