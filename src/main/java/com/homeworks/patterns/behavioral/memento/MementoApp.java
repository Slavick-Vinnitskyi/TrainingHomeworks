package com.homeworks.patterns.behavioral.memento;

public class MementoApp {
    public static void main(String[] args) {
        FileWriterCaretaker caretaker = new FileWriterCaretaker();
        FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
        fileWriter.write("First Set of Data\n");
        System.out.println(fileWriter + "\n\n");

        caretaker.save(fileWriter);
        fileWriter.write("Second Set of Data\n\n");
        System.out.println(fileWriter + "\n\n");

        caretaker.undo(fileWriter);
        System.out.println(fileWriter + "\n\n");

    }
}

class FileWriterUtil {
    private String fileName;
    private StringBuilder content;

    public FileWriterUtil(String fileName) {
        this.fileName = fileName;
        this.content = new StringBuilder();
    }

    @Override
    public String toString() {
        return this.content.toString();
    }

    void write(String string) {
        content.append(string);
    }

    public Memento save() {
        return new Memento(this.fileName, this.content);
    }

    public void undoToLastSave(Object obj) {
        Memento memento = (Memento) obj;
        this.fileName = memento.fileName;
        this.content = memento.content;
    }

    private class Memento {
        private String fileName;
        private StringBuilder content;

        Memento(String fileName, StringBuilder content) {
            this.fileName = fileName;
            this.content = new StringBuilder(content);
        }
    }
}

class FileWriterCaretaker {
    private Object obj;

    void save(FileWriterUtil fileWriter) {
        this.obj = fileWriter.save();
    }

    void undo(FileWriterUtil fileWriter) {
        fileWriter.undoToLastSave(obj);
    }
}