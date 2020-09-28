package ru.vsu.cs.models;

import java.awt.*;

public class Sun implements Drawable {
    private int x;
    private int y;
    private int r1;
    private int r2;
    private int n;
    private Color color;

    public Sun(int x, int y, int r1, int r2, int n, Color color) {
        this.x = x;
        this.y = y;
        this.r1 = r1;
        this.r2 = r2;
        this.n = n;
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(x - r1, y - r1, 2 * r1, 2 * r1);
        double an = 2 * Math.PI / n;
        double dx1;
        double dy1;
        double dx2;
        double dy2;

        for (int i = 0; i < n; i++) {
            dx1 = r1 * Math.cos(an * i);
            dy1 = r1 * Math.sin(an * i);
            dx2 = r2 * Math.cos(an * i);
            dy2 = r2 * Math.sin(an * i);
            graphics.drawLine((int) dx1 + x, (int) dy1 + y, (int) dx2 + x, (int) dy2 + y);
        }
    }
}
