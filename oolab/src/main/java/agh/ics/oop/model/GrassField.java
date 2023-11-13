package agh.ics.oop.model;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, WorldElement> grass = new HashMap<>();
    private final int[] corners = {0, 0, 0, 0};
    Random rn = new Random();

    public GrassField(int grassQuantity) {
        generateGrass(grassQuantity);
    }

    public void generateGrass(int grassQuantity) {
        int n = (int) (Math.sqrt(grassQuantity*10)+1);
        for (int i=0; i<grassQuantity; i++) {
            Vector2d newPosition = new Vector2d(rn.nextInt(n), rn.nextInt(n));
            if (!isOccupied(newPosition))
                grass.put(newPosition, new Grass(newPosition));
            else
                i--;
        }
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
            corners[0] = Math.min(corners[0], position.getXValue());
            corners[1] = Math.min(corners[1], position.getYValue());
            corners[2] = Math.max(corners[2], position.getXValue());
            corners[3] = Math.max(corners[3], position.getYValue());
        }
    }

    @Override
    public String toString() {
        Set<Vector2d> grassPositions = grass.keySet();
        Set<Vector2d> animalsPositions = super.animals.keySet();
        calculateCorners(grassPositions);
        calculateCorners(animalsPositions);
        Vector2d lowerLeft = new Vector2d(corners[0], corners[1]);
        Vector2d upperRight = new Vector2d(corners[2], corners[3]);
        return super.toString(lowerLeft, upperRight);  //to optimize
    }
}
