package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

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
        /*MoveDirection[] directions;
        directions = OptionsParser.convertStringToMoveDirection(args);
        run(directions);*/
       /*Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/
        MapDirection direction;
        direction = MapDirection.SOUTH;
        System.out.println(direction.toUnitVector());
        stop();
    }
}
