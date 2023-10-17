package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] convertStringToMoveDirection(String[] args) {
        int tabLength = 0;
        for (int i=0; i<args.length; i++)
            if (args[i].equals("f") || args[i].equals("b") || args[i].equals("r") || args[i].equals("l"))
                tabLength++;
        MoveDirection[] direction = new MoveDirection[tabLength];

        int j = 0;
        for (int i=0; i<args.length; i++) {
            switch (args[i]) {
                case "f" -> direction[j++] = MoveDirection.FORWARD;
                case "b" -> direction[j++] = MoveDirection.BACKWARD;
                case "r" -> direction[j++] = MoveDirection.RIGHT;
                case "l" -> direction[j++] = MoveDirection.LEFT;
            }
        }

        return direction;
    }
    public static void main(String[] args) {
        convertStringToMoveDirection(args);
    }
}
