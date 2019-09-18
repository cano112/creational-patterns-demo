package com.softwaremind.model;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class Building {

    private final Set<Wall> walls;

    private final Roof roof;

    protected Building(Set<Wall> walls, Roof roof) {
        this.walls = walls;
        this.roof = roof;
    }

    protected Building(Building building) {
        this.roof = building.roof.clone();
        this.walls = building.walls
                .stream()
                .map(Wall::clone)
                .collect(Collectors.toSet());

    }
}
