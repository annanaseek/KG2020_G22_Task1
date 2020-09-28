package ru.vsu.cs.models;

import java.awt.*;

public class TextCloud implements Drawable {
    private int x0;
    private int y0;
    private int w;
    private int h;
    private Color colorOfCloud;
    private Color colorOfText;

    public TextCloud(int x0, int y0, int w, int h, Color colorOfCloud, Color colorOfText) {
        this.x0 = x0;
        this.y0 = y0;
        this.w = w;
        this.h = h;
        this.colorOfCloud = colorOfCloud;
        this.colorOfText = colorOfText;
    }

    @Override
    public void draw(Graphics graphics) {
        int[] x = {x0 + w / 4, x0, x0 + w};
        int[] y = {y0 - h / 2, y0, y0 - h / 2};
        graphics.setColor(colorOfCloud);
        graphics.fillOval(x0, y0 - h, w, h);
        graphics.fillPolygon(x, y, 3);
        graphics.setColor(colorOfText);
        graphics.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
        graphics.drawString("а вот и обед", x0 + 20, y0 - h / 2);
    }
}
