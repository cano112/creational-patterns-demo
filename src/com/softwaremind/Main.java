package com.softwaremind;

import com.softwaremind.model.*;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

var garage = new Garage(
        Set.of(new Wall(), new Wall(), new Wall(), new Wall()),
        new Roof(),
        new Gate());

var walls = Set.of(new Wall(), new Wall(), new Wall(), new Wall());

var house = House.builder(walls, new Ceiling(), new Roof())
        .withWindows(Set.of(new Window(), new Window()))
        .withDoor(new Door())
        .withGarage(garage)
        .build();




    }
}
