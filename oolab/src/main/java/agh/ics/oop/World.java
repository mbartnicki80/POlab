package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class World {
    static void start() {
        System.out.println("System wystartowal");
    }
    static void stop() {
        System.out.println("System zakonczyl dzialanie");
    }

    /*static void run(String[] args) {
        System.out.println("Zwierzak idzie do przodu");
        for (int i=0; i<args.length; i++) {
            System.out.print(args[i]);
            if (i != args.length-1)
                System.out.print(", ");
        }
        System.out.print("\n");
        for (int i=0; i<args.length; i++) {
            switch (args[i]) {
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "b"  -> System.out.println("Zwierzak idzie do tylu");
                case "r"  -> System.out.println("Zwierzak skreca w prawo");
                case "l"  -> System.out.println("Zwierzak skreca w lewo");
            }
        }
    }*/
    static void run(MoveDirection[] directions) {
        for (int i=0; i<directions.length; i++) {
            switch (directions[i]) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD  -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT  -> System.out.println("Zwierzak skreca w prawo");
                case LEFT  -> System.out.println("Zwierzak skreca w lewo");
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
