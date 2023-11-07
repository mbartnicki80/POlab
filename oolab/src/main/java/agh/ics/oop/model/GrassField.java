package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField implements WorldMap {
    private final int grassQuantity;
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int grassQuantity) {
        this.grassQuantity = grassQuantity;
        Random rn = new Random();
        int n = (int) (Math.sqrt(grassQuantity*10)+1);
        for (int i=0; i<grassQuantity; i++) {
            int x = rn.nextInt(n);
            int y = rn.nextInt(n);
            if (!isOccupied(new Vector2d(x, y)))

        }


    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return null;
    }
}
