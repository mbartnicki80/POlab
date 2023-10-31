package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d UPPER_RIGHT = new Vector2d(width, height);
    private final Vector2d LOWER_LEFT = new Vector2d(0, 0);

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return ((position.precedes(UPPER_RIGHT)) && (position.follows(LOWER_LEFT)));
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        switch (direction) {
            case FORWARD, BACKWARD -> {
                Vector2d newPosition =
                        direction == MoveDirection.FORWARD ? animal.getPosition().add(animal.getOrientation().toUnitVector())
                        : animal.getPosition().subtract(animal.getOrientation().toUnitVector());
                if ((newPosition.precedes(UPPER_RIGHT)) && (newPosition.follows(LOWER_LEFT)))
                    animal.position = newPosition;
            }
            case RIGHT -> animal.orientation = animal.orientation.next();
            case LEFT -> animal.orientation = animal.orientation.previous();
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.getOrDefault(position, null);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
