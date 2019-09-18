package com.softwaremind.model;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Garage extends Building {

    private final Gate gate;

    private Garage(Set<Wall> walls, Roof roof, Gate gate) {
        super(walls, roof);
        this.gate = gate;
    }

    private Garage(Garage garage) {
        super(garage);
        this.gate = garage.gate.clone();
    }

    static NeedWalls builder(House.Builder houseBuilder) {
        return new Builder(houseBuilder);
    }

    @Override
    public Garage clone() {
        return new Garage(this);
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
        public NeedRoof withFourWalls(Supplier<Wall> wallSupplier) {
            this.walls = IntStream.range(0, 4)
                    .mapToObj(index -> wallSupplier.get())
                    .collect(Collectors.toSet());
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
        NeedRoof withFourWalls(Supplier<Wall> wallSupplier);
    }

    public interface NeedRoof {
        CanBuild withRoof(Roof roof);
    }

    public interface CanBuild {
        CanBuild withGate(Gate gate);
        House.CanBuild build();
    }
}
