package com.ngergis;

import com.ngergis.service.ColoringService;

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

    private int x = 3;
    private int y = 4;
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
        for (char[] row : image) {
            printRaw(row);
        }
        System.out.println();
        System.out.println();
    }

    private void printRaw(char[] raw) {
        for (char point : raw) {
            System.out.print(point + " ");
        }
        System.out.println();
    }

    private void coloringImage(char[][] image) {
        image = coloringService.coloring(image, x, y, newColor);
    }
}