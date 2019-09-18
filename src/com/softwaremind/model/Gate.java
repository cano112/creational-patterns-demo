package com.softwaremind.model;

public class Gate implements Prototype {

    @Override
    public Gate clone() {
        return new Gate();
    }
}
