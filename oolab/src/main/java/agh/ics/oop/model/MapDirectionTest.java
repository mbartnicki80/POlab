package agh.ics.oop.model;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextMethodTest() {
        assertEquals(MapDirection.valueOf("EAST"), MapDirection.NORTH.next());
        assertEquals(MapDirection.valueOf("SOUTH"), MapDirection.EAST.next());
        assertEquals(MapDirection.valueOf("WEST"), MapDirection.SOUTH.next());
        assertEquals(MapDirection.valueOf("NORTH"), MapDirection.WEST.next());
    }
    @Test
    public void previousMethodTest() {
        assertEquals(MapDirection.valueOf("EAST"), MapDirection.SOUTH.previous());
        assertEquals(MapDirection.valueOf("SOUTH"), MapDirection.WEST.previous());
        assertEquals(MapDirection.valueOf("WEST"), MapDirection.NORTH.previous());
        assertEquals(MapDirection.valueOf("NORTH"), MapDirection.EAST.previous());
    }
}
