package com.homeworks.patterns.creational.factory_method.variant2;

import java.io.File;
import java.util.List;

abstract class BatchProcessor {
    public final void processBatch(String filename) {
        File file = openFile(filename);
        Parser parser = createParser(file); //Factory method

        List<Records> records = parser.parse();
        processRecords(records);
        writeSummary();
        closeFile(file);
    }

    //FACTORY METHOD
    abstract Parser createParser(File file);

    private File openFile(String filename) {
        System.out.println("Opened file...");
        return null;
    }

    private void closeFile(File file) {
        System.out.println("file closed");

    }

    private void writeSummary() {
        System.out.println("File size = 0");
    }

    private void processRecords(List<Records> records) {

    }
}
