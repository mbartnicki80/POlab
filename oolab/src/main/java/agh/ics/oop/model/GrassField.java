package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, WorldElement> grass = new HashMap<>();
    private Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public GrassField(int grassQuantity) {
        generateGrass(grassQuantity);
    }

    public void generateGrass(int grassQuantity) {
        int n = (int) (Math.sqrt(grassQuantity*10)+1);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(n, n, grassQuantity);
        for(Vector2d grassPosition : randomPositionGenerator)
            grass.put(grassPosition, new Grass(grassPosition));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()))
            return super.place(animal);
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (!isOccupiedByGrass(animal.getPosition()))
            super.move(animal, direction);
    }

    private boolean isOccupiedByGrass(Vector2d position) {
        return grass.containsKey(position);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || isOccupiedByGrass(position));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement worldElement = super.objectAt(position);
        if (worldElement != null)
            return worldElement;
        return grass.getOrDefault(position, null);
    }

    private void calculateCorners(Set<Vector2d> positions) {
        for (Vector2d position : positions) {
            lowerLeft = lowerLeft.lowerLeft(position);
            upperRight = upperRight.upperRight(position);
        }
    }

    @Override
    public ArrayList<WorldElement> getElements() {
        ArrayList<WorldElement> elements = super.getElements();
        elements.addAll(grass.values());
        return elements;
    }

    @Override
    public String toString() {
        Set<Vector2d> grassPositions = grass.keySet();
        Set<Vector2d> animalsPositions = super.animals.keySet();
        calculateCorners(grassPositions);
        calculateCorners(animalsPositions);
        System.out.println(lowerLeft);
        return super.toString(lowerLeft, upperRight);
    }
}
