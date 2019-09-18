package com.softwaremind.model;

import java.util.Set;

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

    public static Builder builder(Set<Wall> walls, Ceiling ceiling, Roof roof) {
        return new Builder(walls, ceiling, roof);
    }

    public static class Builder {

        private final Set<Wall> walls;

        private final Ceiling ceiling;

        private final Roof roof;

        private Set<Window> windows;

        private Door door;

        private Pathway pathway;

        private Garage garage;

        private Builder(Set<Wall> walls, Ceiling ceiling, Roof roof) {
            this.walls = walls;
            this.ceiling = ceiling;
            this.roof = roof;
        }

        public Builder withWindows(Set<Window> windows) {
            this.windows = windows;
            return this;
        }

        public Builder withDoor(Door door) {
            this.door = door;
            return this;
        }

        public Builder withPathway(Pathway pathway) {
            this.pathway = pathway;
            return this;
        }

        public Builder withGarage(Garage garage) {
            this.garage = garage;
            return this;
        }

        public House build() {
            return new House(walls, ceiling, roof, windows, door, pathway, garage);
        }
    }
}
