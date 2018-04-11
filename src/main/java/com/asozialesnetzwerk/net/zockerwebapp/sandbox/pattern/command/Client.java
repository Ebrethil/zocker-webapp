package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.command;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private PersonSingleton person = PersonSingleton.getInstance();
    private List<MoveCommand> moveCommands = new ArrayList<>();
    private int commandIndex = 0;

    public void addMoveCommand(MoveCommand moveCommand) {
        moveCommands.add(moveCommand);
    }

    public void deleteMoveCommand(MoveCommand moveCommand) {
        moveCommands.remove(moveCommand);
    }

    public void move() {
        for (MoveCommand moveCommand : moveCommands) {
            moveCommand.move(person);
            commandIndex ++;
        }
    }

    public void undoMove() {
        moveCommands.get(commandIndex).undo(person);
        commandIndex --;
    }
}

