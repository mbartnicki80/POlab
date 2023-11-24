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

    static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
        }
    }

    public static void main(String[] args) {
        try {
            start();
            List<MoveDirection> directions;
            directions = OptionsParser.convertStringToMoveDirection(args);
            ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
            RectangularMap worldMap1 = new RectangularMap(5, 5);
            GrassField worldMap2 = new GrassField(10);
            ConsoleMapDisplay consoleMapDisplay1 = new ConsoleMapDisplay();
            ConsoleMapDisplay consoleMapDisplay2 = new ConsoleMapDisplay();
            worldMap1.addObserver(consoleMapDisplay1);
            worldMap2.addObserver(consoleMapDisplay2);
            Simulation simulation1 = new Simulation(positions, directions, worldMap1);
            Simulation simulation2 = new Simulation(positions, directions, worldMap2);
            //simulation.run();
            ArrayList<Simulation> simulations = new ArrayList<>(Arrays.asList(simulation1, simulation2));
            SimulationEngine multipleSimulations = new SimulationEngine(simulations);
            //multipleSimulations.runSync();
            multipleSimulations.runAsync();
            stop();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            stop();
        }
    }
}
