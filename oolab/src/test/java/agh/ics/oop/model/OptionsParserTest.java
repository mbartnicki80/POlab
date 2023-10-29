package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void optionsParserTest() {
        List<MoveDirection> directions1 = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT));
        String[] input1 = {"f", "b", "r", "l"};
        List<MoveDirection> directions2 = new ArrayList<>(List.of());
        String[] input2 = {"a", "c", "d", "e"};
        List<MoveDirection> directions3 = new ArrayList<>(List.of());
        String[] input3 = {};
        List<MoveDirection> directions4 = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT));
        String[] input4 = {"f", "a", "b", "c", "r"};

        assertArrayEquals(directions1.toArray(), OptionsParser.convertStringToMoveDirection(input1).toArray());
        assertArrayEquals(directions2.toArray(), OptionsParser.convertStringToMoveDirection(input2).toArray());
        assertArrayEquals(directions3.toArray(), OptionsParser.convertStringToMoveDirection(input3).toArray());
        assertArrayEquals(directions4.toArray(), OptionsParser.convertStringToMoveDirection(input4).toArray());

    }
}
