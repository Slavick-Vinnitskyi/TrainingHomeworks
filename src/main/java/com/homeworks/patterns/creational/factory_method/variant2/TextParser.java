package com.homeworks.patterns.creational.factory_method.variant2;

import java.io.File;
import java.util.List;

public class TextParser implements Parser {

    public TextParser(File file) {
        System.out.println("Creating TXT parser");
    }

    public TextParser() {
    }

    public List<Records> parse() {
        System.out.println("Parsing TEXT and creating record list");
        return null;
    }
}
