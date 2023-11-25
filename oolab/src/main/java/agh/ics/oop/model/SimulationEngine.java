package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.List;

public class SimulationEngine implements Runnable {
    private final List<Simulation> simulations;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public synchronized void runAsync() {
        /*for (Simulation simulation : simulations) {
            thread.start();
        }*/
    }

    @Override
    public void run() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    /*private record RunnableSimulation(Simulation simulation) implements Runnable {
        @Override
            public synchronized void run() {
                simulation.run();
            }
        }*/

}
