package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.command;

public class PersonSingleton {

    private int position = 0;
    private static PersonSingleton instance;


    private PersonSingleton() {}


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public static PersonSingleton getInstance() {
        if (instance == null) {
            return new PersonSingleton();
        } else {
            return instance;
        }
    }
}
