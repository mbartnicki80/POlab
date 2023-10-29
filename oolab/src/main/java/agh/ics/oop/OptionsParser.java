package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> convertStringToMoveDirection(String[] args) {
        List<MoveDirection> direction = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> direction.add(MoveDirection.FORWARD);
                case "b" -> direction.add(MoveDirection.BACKWARD);
                case "r" -> direction.add(MoveDirection.RIGHT);
                case "l" -> direction.add(MoveDirection.LEFT);
            }
        }
        return direction;
    }
}
