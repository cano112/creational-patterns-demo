package com.softwaremind.model;

public class Pathway implements Prototype {
    @Override
    public Pathway clone() {
        return new Pathway();
    }
}
