package com.softwaremind;

import com.softwaremind.model.*;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // @formatter:off


        House house = House.builder()
                .withFourWalls(Wall::new)
                .withCeiling(new Ceiling())
                .withRoof(new Roof())
                .withDoor(new Door())
                .withPathway(new Pathway())
                .withTwoWindows(Window::new)
                .withGarage()
                    .withFourWalls(Wall::new)
                    .withRoof(new Roof())
                    .withGate(new Gate())
                    .build()
                .build();


        // @formatter:on

    }

}
