package ru.vsu.cs.models;

import java.awt.*;

public class Ant implements Drawable {
    private int weight;
    private int height;
    private int x;
    private int y;
    private Color color;

    public Ant(int weight, int height, int x, int y, Color color) {
        this.weight = weight;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        int w = weight / 3;
        int h = height / 3;
        graphics.fillOval(x, y + h, 2 * w, 2 * h);
        graphics.fillOval(x + w, y, 2 * w, 2 * h);
        graphics.drawLine(x + w, y + height - h, x + w, y + height + h / 2);
        graphics.drawLine(x + w, y + height - h, x + 2 * w, y + height + h / 2);
        graphics.drawLine(x + w, y + height - h, x, y + height + h / 2);
    }
}
