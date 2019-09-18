package com.softwaremind.model;

import java.util.Set;

public class Garage {

    private final Set<Wall> walls;

    private final Roof roof;

    private final Gate gate;


    public Garage(Set<Wall> walls, Roof roof, Gate gate) {
        this.walls = walls;
        this.roof = roof;
        this.gate = gate;
    }
}
