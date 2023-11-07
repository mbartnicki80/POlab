package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends RectangularMap {
    private final int grassQuantity;
    private final Map<Vector2d, Animal> animals = new HashMap<>(); //dziedziczenie
    private final Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int grassQuantity) { //todo
        this.grassQuantity = grassQuantity;
        generateGrass();
    }

    public void generateGrass() {
        Random rn = new Random();
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
    public boolean isOccupied(Vector2d position) {
        return (animals.containsKey(position) || grass.containsKey(position));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return null;
    } //todo
}
