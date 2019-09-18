package com.softwaremind;

import com.softwaremind.model.*;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // @formatter:off
        House house = House.builder()
                .withWalls(Set.of(new Wall(), new Wall(), new Wall(), new Wall()))
                .withCeiling(new Ceiling())
                .withRoof(new Roof())
                .withDoor(new Door())
                .withPathway(new Pathway())
                .withWindows(Set.of(new Window(), new Window()))
                .withGarage()
                    .withWalls(Set.of(new Wall(), new Wall(), new Wall(), new Wall()))
                    .withRoof(new Roof())
                    .withGate(new Gate())
                    .build()
                .build();
        // @formatter:on

    }

}
