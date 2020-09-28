package ru.vsu.cs.models;

import java.awt.*;

public class Cloud implements Drawable {
    private int x;
    private int y;
    private int w;
    private int h;
    private Color color;

    public Cloud(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x, y, w, h);
    }
}
