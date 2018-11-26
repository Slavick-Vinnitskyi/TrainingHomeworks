package com.homeworks.patterns.creational.factory_method.variant2;

import java.io.File;
import java.util.List;

public class CSVParser implements Parser {
    public CSVParser(File file) {

        System.out.println("Creating CSV Parser");
    }

    @Override
    public List<Records> parse() {
        System.out.println("Parsing CSV values and creating record list");
        return null;
    }
}
