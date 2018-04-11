package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.command;

public interface MoveCommand {
    void move(PersonSingleton person);
    void undo(PersonSingleton person);

    boolean testMe();
}
