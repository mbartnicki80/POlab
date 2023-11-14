package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, WorldElement> animals = new HashMap<>();
    MapVisualizer mapVisualizer = new MapVisualizer(this);

    public void move(Animal animal, MoveDirection direction) {
        if (isOccupied(animal.getPosition())) {
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);
        }
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
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

    String toString(Vector2d lowerLeft, Vector2d upperRight) {
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
