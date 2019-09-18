package com.softwaremind.model;

import java.util.Set;

public class Garage {

    private final Set<Wall> walls;

    private final Roof roof;

    private final Gate gate;


    private Garage(Set<Wall> walls, Roof roof, Gate gate) {
        this.walls = walls;
        this.roof = roof;
        this.gate = gate;
    }

    static NeedWalls builder(House.Builder houseBuilder) {
        return new Builder(houseBuilder);
    }

    public static class Builder implements NeedWalls, NeedRoof, CanBuild {

        private Set<Wall> walls;

        private Roof roof;

        private Gate gate;

        private House.Builder houseBuilder;

        private Builder(House.Builder houseBuilder) {
            this.houseBuilder = houseBuilder;
        }

        @Override
        public NeedRoof withWalls(Set<Wall> walls) {
            this.walls = walls;
            return this;
        }

        @Override
        public CanBuild withRoof(Roof roof) {
            this.roof = roof;
            return this;
        }

        @Override
        public CanBuild withGate(Gate gate) {
            this.gate = gate;
            return this;
        }

        @Override
        public House.CanBuild build() {
            return houseBuilder
                    .withGarage(new Garage(walls, roof, gate));
        }
    }

    public interface NeedWalls {
        NeedRoof withWalls(Set<Wall> walls);
    }

    public interface NeedRoof {
        CanBuild withRoof(Roof roof);
    }

    public interface CanBuild {
        CanBuild withGate(Gate gate);
        House.CanBuild build();
    }
}
