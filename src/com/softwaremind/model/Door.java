package com.softwaremind.model;

public class Door implements Prototype {
    @Override
    public Door clone() {
        return new Door();
    }
}
