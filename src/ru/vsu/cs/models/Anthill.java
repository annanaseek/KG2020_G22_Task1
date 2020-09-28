package ru.vsu.cs.models;

import java.awt.*;

public class Anthill implements Drawable {
    private int[] x;
    private int[] y;
    private Color color;

    public Anthill(int[] x, int[] y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillPolygon(x, y, 4);
    }
}
