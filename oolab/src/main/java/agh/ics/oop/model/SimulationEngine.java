package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final List<Thread> simulationThreads = new ArrayList<>();

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {

        for (Simulation simulation : simulations)
            simulationThreads.add(new Thread(simulation));

        for (Thread simulationThread : simulationThreads)
            simulationThread.start();

    }

    public void awaitSimulationsEnd() {
        for (Thread simulationThread : simulationThreads)
            try {
                simulationThread.join();
            } catch (InterruptedException e) {
                System.out.println("Watek zostal przerwany");
                return;
            }
    }

    /*@Override
    public void run() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }*/
}
