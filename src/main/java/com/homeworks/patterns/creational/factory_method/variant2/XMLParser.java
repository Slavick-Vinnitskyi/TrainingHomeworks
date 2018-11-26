package com.homeworks.patterns.creational.factory_method.variant2;

import java.io.File;
import java.util.List;

public class XMLParser implements Parser {
    public XMLParser(File file) {
        System.out.println("Creating XML Parser;");
    }

    @Override
    public List<Records> parse() {
        System.out.println("Parsing XML and creating records");
        return null;
    }
}
