package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void optionsParserTest() {
        MoveDirection[] directions1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        String[] input1 = {"f", "b", "r", "l"};
        MoveDirection[] directions2 = {};
        String[] input2 = {"a", "c", "d", "e"};
        MoveDirection[] directions3 = {};
        String[] input3 = {};
        MoveDirection[] directions4 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        String[] input4 = {"f", "a", "b", "c", "r"};

        assertArrayEquals(directions1, OptionsParser.convertStringToMoveDirection(input1));
        assertArrayEquals(directions2, OptionsParser.convertStringToMoveDirection(input2));
        assertArrayEquals(directions3, OptionsParser.convertStringToMoveDirection(input3));
        assertArrayEquals(directions4, OptionsParser.convertStringToMoveDirection(input4));

    }
}
