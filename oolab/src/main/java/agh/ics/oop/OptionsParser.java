package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] convertStringToMoveDirection(String[] args) {
        int tabLength = 0;
        for (String arg : args)
            if (arg.equals("f") || arg.equals("b") || arg.equals("r") || arg.equals("l"))
                tabLength++;
        MoveDirection[] direction = new MoveDirection[tabLength];

        int j = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> direction[j++] = MoveDirection.FORWARD;
                case "b" -> direction[j++] = MoveDirection.BACKWARD;
                case "r" -> direction[j++] = MoveDirection.RIGHT;
                case "l" -> direction[j++] = MoveDirection.LEFT;
            }
        }
        return direction;
    }
}
