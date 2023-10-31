package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    private static final Vector2d UPPER_RIGHT = new Vector2d(4, 4);
    private static final Vector2d LOWER_LEFT = new Vector2d(0, 0);
    @Test
    public void shouldSimulationWorkCorrect() {
        List<Vector2d> positions = List.of(
                new Vector2d(3, 4),
                new Vector2d(0, 0),
                new Vector2d(2, 2)
        );
        String [] moves = {"f", "b", "f", "k", "l", "l", "a", "R", "r", "f", "f"};
        List<MoveDirection> expectedMoves = List.of(
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD
        );
        List<MoveDirection> convertedMoves = OptionsParser.convertStringToMoveDirection(moves);
        assertIterableEquals(expectedMoves, convertedMoves);

        Simulation simulation = new Simulation(positions, convertedMoves);
        simulation.run();
        List<Animal> animalsList = simulation.getAnimalsList();
        List<MapDirection> expectedOrientations = List.of(MapDirection.WEST,MapDirection.WEST,MapDirection.EAST);
        List<Vector2d> expectedPositions = List.of(new Vector2d(2, 4), new Vector2d(0, 0), new Vector2d(2, 3));

        for(int i=0; i<expectedOrientations.size(); i++) {
            assertEquals(expectedOrientations.get(i), animalsList.get(i).getOrientation());
            assertTrue(animalsList.get(i).isAt(expectedPositions.get(i)));
            assertTrue(animalsList.get(i).getPosition().precedes(UPPER_RIGHT));
            assertTrue(animalsList.get(i).getPosition().follows(LOWER_LEFT));
        }
    }
}
