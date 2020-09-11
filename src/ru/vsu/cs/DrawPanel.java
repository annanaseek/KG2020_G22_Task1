package ru.vsu.cs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        drawPicture(gr);
    }

    public void drawPicture (Graphics2D gr) {
        Random random = new Random();

        int numberOfAnts = 300;
        int horizon = 500;
        int xSun = 400;
        int ySun = 100;
        int rSun = 40;
        int rRays = 80;
        int numberOfRays = 25;
        int numberOfClouds = 5;
        int weightOfClouds = 100;
        int heightOfClouds = 60;

        drawBackground(gr, horizon);
        drawSun(gr, xSun, ySun, rSun, rRays, numberOfRays);

        for (int i = 0; i < numberOfClouds; i++) {
            drawCloud(gr,random.nextInt(getWidth() - weightOfClouds), random.nextInt(horizon - 2 * heightOfClouds), weightOfClouds, heightOfClouds);
        }
//        drawAnthill(gr);
        for (int i = 0; i < numberOfAnts; i++) {
//            drawAnt(gr);
        }
//        drawAnteaterNose(gr);
    }

    private void drawAnt (Graphics2D g, int x, int y){

    }

    private void drawAnthill (Graphics2D g, int x, int y) {


    }

    private void drawSun (Graphics2D g, int x, int y, int r1, int r2, int n) {
        g.setColor(new Color(255, 187, 00));
        g.fillOval(x - r1, y - r1, 2 * r1, 2 * r1);
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
            g.drawLine((int) dx1 + x, (int) dy1 + y, (int) dx2 + x, (int) dy2 + y);
        }

    }
    private void drawCloud (Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, w, h);
    }

    private void drawAnteaterNose (Graphics2D g, int x, int y) {

    }

    private void drawBackground (Graphics2D g, int y) {          //y-координата, где "сходятся" земля и небо
        g.setColor(new Color(204, 255, 255));
        g.fillRect(0, 0, getWidth(), y);
        g.setColor(new Color(51, 153, 33));
        g.fillRect(0, y, getWidth(), getHeight() - y + 1);
    }

}
