package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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

        assertIterableEquals(directions1, OptionsParser.convertStringToMoveDirection(input1));
        assertIterableEquals(directions2, OptionsParser.convertStringToMoveDirection(input2));
        assertIterableEquals(directions3, OptionsParser.convertStringToMoveDirection(input3));
        assertIterableEquals(directions4, OptionsParser.convertStringToMoveDirection(input4));

    }
}
