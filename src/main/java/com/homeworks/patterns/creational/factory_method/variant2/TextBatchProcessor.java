package com.homeworks.patterns.creational.factory_method.variant2;

import java.io.File;

public class TextBatchProcessor extends BatchProcessor {
    @Override
    Parser createParser(File file) {
        return new TextParser(file);
    }
}
