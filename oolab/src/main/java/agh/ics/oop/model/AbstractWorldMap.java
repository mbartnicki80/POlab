package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    MapVisualizer mapVisualizer = new MapVisualizer(this);

    protected AbstractWorldMap() {
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return isOccupied(position);
    }
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (isOccupied(animal.getPosition())) {
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        //WorldElement worldElement = animals.getOrDefault(position, null);
        return animals.getOrDefault(position, null);
    } ///??? wykorzystac isAt

    public String toString(Vector2d lowerLeft, Vector2d upperRight) {
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
