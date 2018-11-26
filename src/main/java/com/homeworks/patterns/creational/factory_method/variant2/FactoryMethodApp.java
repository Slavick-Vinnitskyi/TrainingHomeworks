package com.homeworks.patterns.creational.factory_method.variant2;

public class FactoryMethodApp {
    public static void main(String[] args) {
        BatchProcessor batchProcessor = createBatchProcessor("csv");
        batchProcessor.processBatch("f");
        System.out.println("done");
    }

    private static BatchProcessor createBatchProcessor(String format) {
        if (format.toLowerCase().equals("text")) {
            return new TextBatchProcessor();
        } else if (format.toLowerCase().equals("csv")) {
            return new CSVBatchProcessor();
        } else if (format.toLowerCase().equals("xml")) {
            return new XMLBatchProcessor();
        }
        return null;
    }
}