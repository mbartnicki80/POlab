package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grass = new HashMap<>();
    private Vector2d upperRight;
    private Vector2d lowerLeft; //wymyslic obliczanie rogow
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
        return isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        super.move(animal, direction);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || grass.containsKey(position));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return super.objectAt(position);
    }

    @Override
    public String toString() {
        return super.toString(lowerLeft, upperRight);
    }
}
