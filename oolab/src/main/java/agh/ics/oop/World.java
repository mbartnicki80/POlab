package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class World {
    static void start() {
        System.out.println("System wystartował");
    }
    static void stop() {
        System.out.println("System zakończył działanie");
    }
    static void run(MoveDirection[] directions) {
        for (int i=0; i<directions.length; i++) {
            switch (directions[i]) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD  -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT  -> System.out.println("Zwierzak skręca w prawo");
                case LEFT  -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }

    public static void main(String[] args) {
        start();
        MoveDirection[] directions;
        directions = OptionsParser.convertStringToMoveDirection(args);
        run(directions);
        stop();
    }
}
