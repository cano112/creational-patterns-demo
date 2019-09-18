package com.softwaremind;

import com.softwaremind.model.*;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

var garage = new Garage(
        Set.of(new Wall(), new Wall(), new Wall(), new Wall()),
        new Roof(),
        new Gate());

var house = House.builder()
        .withWalls(Set.of(new Wall(), new Wall(), new Wall(), new Wall()))
        .withCeiling(new Ceiling())
        .withRoof(new Roof())
        .withWindows(Set.of(new Window(), new Window()))
        .withDoor(new Door())
        .withPathway(new Pathway())
        .withGarage(garage)
        .build();

    }
}
