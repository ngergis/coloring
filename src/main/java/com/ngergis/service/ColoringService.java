package com.ngergis.service;

/**
 * Created by Nabil Gergis on 08/10/17.
 */
public class ColoringService {

    public char[][] coloring(char[][] image, int x, int y, char newColor) {
        coloringPoint(image, image[x][y], newColor, x, y);

        return image;
    }

    private void coloringPoint(char[][] image, char oldColor, char newColor, int x, int y) {
        if (outOfBound(image, x, y)) return;
        if (image[x][y] != oldColor) return;

        image[x][y] = newColor;
        coloringPoint(image, oldColor, newColor, x - 1, y - 1);
        coloringPoint(image, oldColor, newColor, x - 1, y);
        coloringPoint(image, oldColor, newColor, x - 1, y + 1);
        coloringPoint(image, oldColor, newColor, x, y - 1);
        coloringPoint(image, oldColor, newColor, x, y + 1);
        coloringPoint(image, oldColor, newColor, x + 1, y - 1);
        coloringPoint(image, oldColor, newColor, x + 1, y);
        coloringPoint(image, oldColor, newColor, x + 1, y + 1);
    }

    private boolean outOfBound(char[][] image, int x, int y) {
        return x < 0 || x >= image.length || y < 0 || y >= image[x].length;
    }
}
