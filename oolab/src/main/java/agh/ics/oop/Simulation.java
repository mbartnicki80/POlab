package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Animal> animals;
    private List<MoveDirection> moves;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves) {
        this.moves = moves;
        animals = new ArrayList<>();
        for (Vector2d position : positions)
            animals.add(new Animal(position));
    }

    public void run() {
        int modulo = animals.size();

        for (int i=0; i<moves.size(); i++) {
            Animal newAnimal = animals.get(i%modulo);
            newAnimal.move(moves.get(i));
            animals.set(i%modulo, newAnimal);
            System.out.println("Zwierzę " + i%modulo + ": " + newAnimal);
        }
    }
}
