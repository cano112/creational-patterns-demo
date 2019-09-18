package com.softwaremind.model;

public class Roof implements Prototype {

    @Override
    public Roof clone() {
        return new Roof();
    }
}
