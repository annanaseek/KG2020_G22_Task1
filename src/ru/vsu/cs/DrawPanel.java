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

    public void drawPicture(Graphics2D gr) {
        Random random = new Random();

        int horizon = getHeight() / 2 - 50;
        int xSun = 400;
        int ySun = 100;
        int rSun = 40;
        int rRays = 80;
        int numberOfRays = 25;
        int numberOfClouds = 5;
        int weightOfClouds = 100;
        int heightOfClouds = 60;
        int[] xAnthill = {getWidth() - 300, getWidth() - 450, getWidth() - 50, getWidth() - 200};
        int[] yAnthill = {horizon - 2 * heightOfClouds, horizon + 100, horizon + 100, horizon - 2 * heightOfClouds};
        int numberOfAnts = 45;
        int weightOfAnts = 30;
        int heightOfAnts = 25;
        int[] xAnteaterNose = {0, 0, 100, 110};
        int[] yAnteaterNose = {horizon - 120, horizon - 35, horizon - 10, horizon - 20};
        int weightOfTextCloud = 150;
        int heightOfTextCloud = 100;

        drawBackground(gr, horizon);

        drawSun(gr, xSun, ySun, rSun, rRays, numberOfRays);

        for (int i = 0; i < numberOfClouds; i++) {
            drawCloud(gr, random.nextInt(getWidth() - weightOfClouds),
                    random.nextInt(horizon - 2 * heightOfClouds), weightOfClouds, heightOfClouds);
        }

        drawAnthill(gr, xAnthill, yAnthill);

        for (int i = 0; i < numberOfAnts; i++) {
            drawAnt(gr, random.nextInt(getWidth()),
                    horizon + random.nextInt(getHeight() - horizon - heightOfAnts), weightOfAnts, heightOfAnts);
        }

        drawAnteaterNose(gr, xAnteaterNose, yAnteaterNose);

        int indexOfMax = findIndexOfMax(xAnteaterNose);
        drawTextCloud(gr, xAnteaterNose[indexOfMax] + 20, yAnteaterNose[indexOfMax] - 20, weightOfTextCloud, heightOfTextCloud);
    }

    private void drawBackground(Graphics2D g, int y) {          //y-координата, где "сходятся" земля и небо
        g.setColor(new Color(204, 255, 255));
        g.fillRect(0, 0, getWidth(), y);
        g.setColor(new Color(51, 153, 33));
        g.fillRect(0, y, getWidth(), getHeight() - y + 1);
    }

    private void drawSun(Graphics2D g, int x, int y, int r1, int r2, int n) {
        g.setColor(new Color(255, 187, 0));
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

    private void drawCloud(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, w, h);
    }

    private void drawAnthill(Graphics2D g, int[] x, int[] y) {
        g.setColor(new Color(102, 0, 51));
        g.fillPolygon(x, y, 4);
    }

    private void drawAnt(Graphics2D g, int x, int y, int weight, int height) {
        g.setColor(new Color(51, 0, 0));
        int w = weight / 3;
        int h = height / 3;
        g.fillOval(x, y + h, 2 * w, 2 * h);
        g.fillOval(x + w, y, 2 * w, 2 * h);
        g.drawLine(x + w, y + height - h, x + w, y + height + h / 2);
        g.drawLine(x + w, y + height - h, x + 2 * w, y + height + h / 2);
        g.drawLine(x + w, y + height - h, x, y + height + h / 2);
    }

    private void drawAnteaterNose(Graphics2D g, int[] x, int[] y) {
        g.setColor(new Color(153, 102, 102));
        g.fillPolygon(x, y, 4);
    }

    private void drawTextCloud(Graphics2D g, int x0, int y0, int w, int h) {
        int[] x = {x0 + w / 4, x0, x0 + w};
        int[] y = {y0 - h / 2, y0, y0 - h / 2};
        g.setColor(Color.white);
        g.fillOval(x0, y0 - h, w, h);
        g.fillPolygon(x, y, 3);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
        g.drawString("а вот и обед", x0 + 20, y0 - h / 2);
    }

    private int findIndexOfMax(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }


}
