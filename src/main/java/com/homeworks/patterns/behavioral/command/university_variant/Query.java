package com.homeworks.patterns.behavioral.command.university_variant;

public interface Query {

    Object execute(String query);

    void unExecute(String query);
}
