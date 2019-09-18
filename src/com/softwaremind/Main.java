package com.softwaremind;

import com.softwaremind.model.*;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // TODO: builder v.3

        var garage = new Garage(
                Set.of(new Wall(), new Wall(), new Wall(), new Wall()),
                new Roof(),
                new Gate());

    }

}
