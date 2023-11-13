package agh.ics.oop;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

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
        start();
        List<MoveDirection> directions;
        directions = OptionsParser.convertStringToMoveDirection(args);
        ArrayList<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        //RectangularMap worldMap = new RectangularMap(5, 5);
        GrassField worldMap = new GrassField(10);
        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();

        stop();
    }
}
