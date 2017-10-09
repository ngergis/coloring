package com.ngergis;

import com.ngergis.service.ColoringService;

import static com.ngergis.Colors.ANSI_BLUE_BACKGROUND;
import static com.ngergis.Colors.ANSI_GREEN_BACKGROUND;
import static com.ngergis.Colors.ANSI_RED_BACKGROUND;
import static com.ngergis.Colors.ANSI_RESET;
import static com.ngergis.Colors.ANSI_YELLOW_BACKGROUND;
import static com.ngergis.Colors.B;
import static com.ngergis.Colors.G;
import static com.ngergis.Colors.R;
import static com.ngergis.Colors.Y;

/**
 * Created by Nabil Gergis on 08/10/17.
 */
public class Coloring {
    private ColoringService coloringService = new ColoringService();
    private char[][] image = new char[][]
            {
                    {R, G, G, G, G, G, G, R, R},
                    {R, R, G, G, R, R, R, R, R},
                    {R, R, R, G, G, G, R, R, R},
                    {R, R, R, G, G, G, R, R, R},
                    {R, R, G, G, G, G, R, R, R},
                    {R, R, G, G, G, G, G, R, R},
                    {R, R, R, G, G, G, Y, Y, Y},
                    {R, R, R, G, G, G, Y, Y, Y},
                    {R, Y, Y, Y, G, Y, Y, Y, Y},
                    {Y, Y, Y, Y, Y, Y, Y, Y, Y},

            };

    private int selectedX = 3;
    private int selectedY = 1;
    private char newColor = B;

    public static void main(String[] arg) {
        new Coloring().start();
    }

    public void start() {
        printImage(image);
        coloringImage(image);
        printImage(image);
    }

    private void printImage(char[][] image) {
        for (int i = 0; i < image.length; i++) {
            printRaw(image[i], i);
        }
        System.out.println();
        System.out.println();
    }

    private void printRaw(char[] raw, int x) {
        for (int j = 0; j < raw.length; j++) {
            printPoint(raw[j], x, j);
        }
        System.out.println();
    }

    private void printPoint(char pointColor, int x, int y) {
        if (B == pointColor) printBlue(x, y);
        else if (G == pointColor) printGreen(x, y);
        else if (R == pointColor) printRed(x, y);
        else if (Y == pointColor) printYellow(x, y);
    }

    private String getPrefix(int x, int y) {
        if (x == selectedX && y == selectedY) {
            return "[";
        }
        return " ";
    }

    private String getSuffix(int x, int y) {
        if (x == selectedX && y == selectedY) {
            return "]";
        }
        return " ";
    }


    private void printBlue(int x, int y) {
        System.out.print(ANSI_BLUE_BACKGROUND + getPrefix(x, y) + B + getSuffix(x, y) + ANSI_RESET);
    }

    private void printGreen(int x, int y) {
        System.out.print(ANSI_GREEN_BACKGROUND + getPrefix(x, y) + G + getSuffix(x, y) + ANSI_RESET);
    }

    private void printRed(int x, int y) {
        System.out.print(ANSI_RED_BACKGROUND + getPrefix(x, y) + R + getSuffix(x, y) + ANSI_RESET);
    }

    private void printYellow(int x, int y) {
        System.out.print(ANSI_YELLOW_BACKGROUND + getPrefix(x, y) + Y + getSuffix(x, y) + ANSI_RESET);
    }

    private void coloringImage(char[][] image) {
        image = coloringService.coloring(image, selectedX, selectedY, newColor);
    }
}
