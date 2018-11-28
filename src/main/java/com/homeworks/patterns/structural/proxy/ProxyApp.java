package com.homeworks.patterns.structural.proxy;

public class ProxyApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("D://img.jpg");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    String file;

    RealImage(String file) {
        this.file = file;
        load();
    }

    private void load() {
        System.out.println("loading " + file);
    }

    @Override
    public void display() {
        System.out.println("displaying " + file);
    }
}

class ProxyImage implements Image {
    private String file;
    RealImage realImage;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(file);
        }
        realImage.display();
    }
}
