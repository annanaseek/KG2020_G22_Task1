package ru.vsu.cs;

import ru.vsu.cs.models.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        drawPicture(g);
    }

    public void drawPicture(Graphics gr) {

        Random random = new Random();
        int horizon = getHeight() / 2 - 50;
        int xSun = 400;
        int ySun = 100;
        int rSun = 40;
        int rRays = 80;
        int numberOfRays = 25;
        int numberOfClouds = 5;
        int widthOfClouds = 100;
        int heightOfClouds = 60;
        int[] xAnthill = {getWidth() - 300, getWidth() - 450, getWidth() - 50, getWidth() - 200};
        int[] yAnthill = {horizon - 2 * heightOfClouds, horizon + 100, horizon + 100, horizon - 2 * heightOfClouds};
        int numberOfAnts = 45;
        int widthOfAnts = 30;
        int heightOfAnts = 20;
        int[] xAnteaterNose = {0, 0, 100, 110};
        int[] yAnteaterNose = {horizon - 120, horizon - 35, horizon - 10, horizon - 20};
        int weightOfTextCloud = 150;
        int heightOfTextCloud = 100;

        drawBackground(gr, horizon, new Color(204, 255, 255), new Color(51, 153, 33), getWidth(), getHeight());

        drawSun(gr, xSun, ySun, rSun, rRays, numberOfRays, new Color(255, 187, 0));

        for (int i = 0; i < numberOfClouds; i++) {
            drawCloud(gr, random.nextInt(getWidth() - widthOfClouds),
                    random.nextInt(horizon - 2 * heightOfClouds), widthOfClouds, heightOfClouds, Color.WHITE);
        }

        drawAnthill(gr, xAnthill, yAnthill, new Color(102, 0, 51));
        for (int i = 0; i < numberOfAnts; i++) {
            drawAnt(gr, random.nextInt(getWidth()),
                    horizon + random.nextInt(getHeight() - horizon - heightOfAnts), widthOfAnts,
                    heightOfAnts, new Color(51, 0, 0));
        }

        drawAnteaterNose(gr, xAnteaterNose, yAnteaterNose, new Color(153, 102, 102));

        int indexOfMax = getIndexOfMax(xAnteaterNose);
        drawTextCloud(gr, xAnteaterNose[indexOfMax] + 20, yAnteaterNose[indexOfMax] - 20, weightOfTextCloud,
                heightOfTextCloud, Color.WHITE, Color.BLACK);

    }

    private void drawBackground(Graphics gr, int horizon, Color colorOfSky, Color colorOfGround, int w, int h) {
        Background bg = new Background(horizon, colorOfSky, colorOfGround, w, h);
        bg.draw(gr);
    }

    private void drawSun(Graphics gr, int x, int y, int r1, int r2, int n, Color color) {
        Sun sun = new Sun(x, y, r1, r2, n, color);
        sun.draw(gr);
    }

    private void drawCloud(Graphics gr, int x, int y, int w, int h, Color color) {
        Cloud cloud = new Cloud(x, y, w, h, color);
        cloud.draw(gr);
    }

    private void drawAnthill(Graphics gr, int[] x, int[] y, Color color) {
        Anthill anthill = new Anthill(x, y, color);
        anthill.draw(gr);
    }

    private void drawAnt(Graphics gr, int x, int y, int w, int h, Color color) {
        Ant ant = new Ant(w, h, x, y, color);
        ant.draw(gr);
    }

    private void drawAnteaterNose(Graphics gr, int[] x, int[] y, Color color) {
        AnteaterNose anteaterNose = new AnteaterNose(x, y, color);
        anteaterNose.draw(gr);
    }

    private void drawTextCloud(Graphics gr, int x, int y, int w, int h, Color colorOfCloud, Color colorOfText) {
        TextCloud textCloud = new TextCloud(x, y, w, h, colorOfCloud, colorOfText);
        textCloud.draw(gr);
    }

    private int getIndexOfMax(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }
}
