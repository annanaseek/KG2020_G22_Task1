package ru.vsu.cs.models;

import ru.vsu.cs.DrawPanel;

import java.awt.*;

public class Background implements Drawable {
    private int horizon;
    private Color colorOfSky;
    private Color colorOfGround;
    private int widthOfPanel;
    private int heightOfPanel;

    public Background(int horizon, Color colorOfSky, Color colorOfGround, int widthOfPanel, int heightOfPanel) {
        this.horizon = horizon;
        this.colorOfSky = colorOfSky;
        this.colorOfGround = colorOfGround;
        this.widthOfPanel = widthOfPanel;
        this.heightOfPanel = heightOfPanel;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(colorOfSky);
        graphics.fillRect(0, 0, widthOfPanel, horizon);
        graphics.setColor(colorOfGround);
        graphics.fillRect(0, horizon, widthOfPanel, heightOfPanel - horizon + 1);
    }
}
