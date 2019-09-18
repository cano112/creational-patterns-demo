package com.softwaremind.model;

public class Window implements Prototype {

    @Override
    public Window clone() {
        return new Window();
    }
}
