package org.code.marsrover.infrastructure;

import org.code.marsrover.application.Command;
import org.code.marsrover.application.NasaCommand;

public class NasaController<T> {
    private Command<T> command;

    public NasaController(Command<T> command) {
        this.command = command;
    }

    public T execute() {
        return command.execute();
    }
}
