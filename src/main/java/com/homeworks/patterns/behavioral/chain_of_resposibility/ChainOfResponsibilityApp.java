package com.homeworks.patterns.behavioral.chain_of_resposibility;

public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        SMSLogger logger = new SMSLogger(Level.ERROR);
        FileLogger logger1 = new FileLogger(Level.DEBUG);
        EmailLogger logger2 = new EmailLogger(Level.INFO);
        logger.setNext(logger1);
        logger1.setNext(logger2);
        logger.writeMessage("All good", Level.INFO);
        logger.writeMessage("Debug mode", Level.DEBUG);
        logger.writeMessage("System cracked", Level.ERROR);
    }
}

class Level {
    static final int ERROR = 1;
    static final int DEBUG = 2;
    static final int INFO = 3;
}

abstract class Logger {
    private int priority;
    private Logger next;

    Logger(int priority) {
        this.priority = priority;
    }

    void setNext(Logger next) {
        this.next = next;
    }

    void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    abstract void write(String message);
}

class SMSLogger extends Logger {

    SMSLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("SMS : " + message);
    }
}

class FileLogger extends Logger {
    FileLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("File : " + message);
    }
}

class EmailLogger extends Logger {
    EmailLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("Email : " + message);
    }
}