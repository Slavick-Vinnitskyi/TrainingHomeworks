package com.homeworks.patterns.structural.adapter;

/**
 * -Через наследование
 * -Через инкапсуляцию(композицию)
 */
public class AdapterApp {
    public static void main(String[] args) {

        VectorGraphicInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        VectorGraphicInterface g2 = new VectorAdapterFromRaster2(new RasterGrephics());
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicInterface {
    void drawLine();

    void drawSquare();
}

class RasterGrephics {
    void drawRasterLine() {
        System.out.println("Raster Line");
    }

    void drawRasterSquare() {
        System.out.println("Raster Square");
    }
}

/**
 * Наследуемся от существующей реализации
 */
class VectorAdapterFromRaster extends RasterGrephics implements VectorGraphicInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicInterface {
    private RasterGrephics rasterGrephics;

    VectorAdapterFromRaster2(RasterGrephics rasterGrephics) {
        this.rasterGrephics = rasterGrephics;
    }

    @Override
    public void drawLine() {

        rasterGrephics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGrephics.drawRasterSquare();
    }
}