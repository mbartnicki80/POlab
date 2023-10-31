package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
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
        /*
        Komentarz do zadania 7
        Lepiej wykorzystać ArrayList, gdyż najczęściej korzystałem z metody .get(), która służy do pozyskania elementu z danego indeksu.
        Najszybciej wykonuje się to na ArrayList, gdyż jego implementacja oparta jest o tablicę. Oprócz tego, ArrayList jest po prostu szybszy
        od LinkedList.
         */
        start();
        List<MoveDirection> directions;
        directions = OptionsParser.convertStringToMoveDirection(args);
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
        stop();
    }
}
