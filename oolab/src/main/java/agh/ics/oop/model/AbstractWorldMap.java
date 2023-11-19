package agh.ics.oop.model;
import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, WorldElement> animals = new HashMap<>();

    public void move(Animal animal, MoveDirection direction) {
        if (isOccupied(animal.getPosition())) {
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);
        }
    }

    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        try {
            if (canMoveTo(animal.getPosition()))
                animals.put(animal.getPosition(), animal);
            else throw new PositionAlreadyOccupiedException(animal.getPosition());
        } catch (PositionAlreadyOccupiedException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    public WorldElement objectAt(Vector2d position) {
        return animals.getOrDefault(position, null);
    }

    public ArrayList<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }
}
