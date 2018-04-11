package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.command;

public class MoveForward implements MoveCommand {
    @Override
    public void move(PersonSingleton person) {
        person.setPosition(person.getPosition() + 1);
    }

    @Override
    public void undo(PersonSingleton person) {
        person.setPosition(person.getPosition() - 1);
    }

    @Override
    public boolean testMe() {
        PersonSingleton person = PersonSingleton.getInstance();
        person.setPosition(0);

        move(person);
        move(person);
        move(person);

        undo(person);

        return person.getPosition() == -2;
    }
}
