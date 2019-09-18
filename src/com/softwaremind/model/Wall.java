package com.softwaremind.model;

public class Wall implements Prototype {
    @Override
    public Wall clone() {
        return new Wall();
    }
}
