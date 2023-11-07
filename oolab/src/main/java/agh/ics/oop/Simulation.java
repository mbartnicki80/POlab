package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> moves;
    private final WorldMap worldMap;

    List<Animal> getAnimalsList() {
        return Collections.unmodifiableList(animals);
    }

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap worldMap) {
        this.moves = moves;
        this.worldMap = worldMap;
        animals = new ArrayList<>();
        for (Vector2d position : positions) {
            Animal newAnimal = new Animal(position);
            if (worldMap.place(newAnimal))
                animals.add(newAnimal);
        }

    }

    public void run() {
        int animalsSize = animals.size();

        for (int i=0; i<moves.size(); i++) {
            Animal animal = animals.get(i % animalsSize);
            worldMap.move(animal, moves.get(i));
            System.out.println(worldMap);
        }
    }
}
