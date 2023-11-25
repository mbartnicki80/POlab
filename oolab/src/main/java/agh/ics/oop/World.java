package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {

    static void start() {
        System.out.println("System wystartowal");
    }

    static void stop() {
        System.out.println("System zakonczyl dzialanie");
    }

    /*private void generateSimulations(int n) {
        for (int i=0; i<n; i++) {

        }
    }*/

    public static void main(String[] args) {
        try {
            start();
            List<MoveDirection> directions;
            directions = OptionsParser.convertStringToMoveDirection(args);
            ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 3), new Vector2d(3, 4)));
            RectangularMap worldMap1 = new RectangularMap(5, 5, 1);
            GrassField worldMap2 = new GrassField(10, 2);
            ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
            worldMap1.addObserver(consoleMapDisplay);
            worldMap2.addObserver(consoleMapDisplay);
            Simulation simulation1 = new Simulation(positions, directions, worldMap1);
            Simulation simulation2 = new Simulation(positions, directions, worldMap2);
            ArrayList<Simulation> simulations = new ArrayList<>(Arrays.asList(simulation1, simulation2));
            SimulationEngine multipleSimulations = new SimulationEngine(simulations);
            //multipleSimulations.runSync();
            multipleSimulations.runAsync();
            multipleSimulations.awaitSimulationsEnd();
            stop();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            stop();
        }
    }
}
