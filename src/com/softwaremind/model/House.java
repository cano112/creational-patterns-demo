package com.softwaremind.model;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class House {

    private final Set<Wall> walls;

    private final Ceiling ceiling;

    private final Roof roof;

    private final Set<Window> windows;

    private final Door door;

    private final Pathway pathway;

    private final Garage garage;

    private House(Set<Wall> walls, Ceiling ceiling, Roof roof, Set<Window> windows, Door door, Pathway pathway,
                  Garage garage) {
        this.walls = walls;
        this.ceiling = ceiling;
        this.roof = roof;
        this.windows = windows;
        this.door = door;
        this.pathway = pathway;
        this.garage = garage;
    }

    public static NeedWalls builder() {
        return new Builder();
    }

    public static class Builder implements NeedWalls, NeedRoof, NeedCeiling, CanBuild {

        private Set<Wall> walls;

        private Ceiling ceiling;

        private Roof roof;

        private Set<Window> windows;

        private Door door;

        private Pathway pathway;

        private Garage garage;

        private Builder() { }

        @Override
        public NeedCeiling withWalls(Set<Wall> walls) {
            this.walls = walls;
            return this;
        }

        @Override
        public NeedCeiling withFourWalls(Supplier<Wall> wallSupplier) {
            this.walls = IntStream.range(0, 4)
                    .mapToObj(index -> wallSupplier.get())
                    .collect(Collectors.toSet());
            return this;
        }

        @Override
        public NeedRoof withCeiling(Ceiling ceiling) {
            this.ceiling = ceiling;
            return this;
        }

        @Override
        public CanBuild withRoof(Roof roof) {
            this.roof = roof;
            return this;
        }

        @Override
        public CanBuild withWindows(Set<Window> windows) {
            this.windows = windows;
            return this;
        }

        @Override
        public CanBuild withTwoWindows(Supplier<Window> windowSupplier) {
            this.windows = IntStream.range(0, 2)
                    .mapToObj(index -> windowSupplier.get())
                    .collect(Collectors.toSet());
            return this;
        }

        @Override
        public CanBuild withDoor(Door door) {
            this.door = door;
            return this;
        }

        @Override
        public CanBuild withPathway(Pathway pathway) {
            this.pathway = pathway;
            return this;
        }

        @Override
        public Garage.NeedWalls withGarage() {
            return Garage.builder(this);
        }

        @Override
        public CanBuild withGarage(Garage garage) {
            this.garage = garage;
            return this;
        }

        @Override
        public House build() {
            return new House(walls, ceiling, roof, windows, door, pathway, garage);
        }
    }

    public interface NeedWalls {
        NeedCeiling withWalls(Set<Wall> walls);
        NeedCeiling withFourWalls(Supplier<Wall> wallSupplier);
    }

    public interface NeedCeiling {
        NeedRoof withCeiling(Ceiling ceiling);
    }

    public interface NeedRoof {
        CanBuild withRoof(Roof roof);
    }

    public interface CanBuild {

        CanBuild withWindows(Set<Window> windows);

        CanBuild withTwoWindows(Supplier<Window> windowSupplier);

        CanBuild withDoor(Door door);

        CanBuild withPathway(Pathway pathway);

        Garage.NeedWalls withGarage();

        CanBuild withGarage(Garage garage);

        House build();
    }
}
