package com.homeworks.patterns.behavioral.command.variant1;

/**
 * класс client
 */
public class Main {
    /**
     * Создаём компьютер(Receiver)
     * Создаём пользователя, задаём ему возможные комманды
     * Пользователь укравляет компьютером
     *
     * @param args compile params
     */
    public static void main(String[] args) {

        Computer computer = new Computer();

        StartCommand startCommand = new StartCommand(computer);
        StopCommand stopCommand = new StopCommand(computer);
        ResetCommand resetCommand = new ResetCommand(computer);

        User user = new User(startCommand, stopCommand, resetCommand);

        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}

/**
 * Интерфейс комманды
 */
interface Command {
    void execute();

}

/**
 * Класс receiver
 */
class Computer {
    void start() {
        System.out.println("Start");
    }

    void stop() {
        System.out.println("Stop");
    }

    void reset() {
        System.out.println("Reset");
    }
}

/**
 * класс concreteCommand
 */
class StartCommand implements Command {
    private Computer computer;

    StartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

/**
 * класс concreteCommand
 */
class StopCommand implements Command {
    private Computer computer;

    StopCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

/**
 * класс concreteCommand
 */
class ResetCommand implements Command {
    private Computer computer;

    ResetCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

/**
 * класс invoker
 * не знает ничего о реализации компьютера(она инкаплулирована)
 */
class User {
    private Command start;
    private Command stop;
    private Command reset;

    User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void resetComputer() {
        reset.execute();
    }
}