/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.awt.image.BufferedImage;

import utilities.BufferedImageUtils;

/**
 *
 * @author Rafael
 */
public class Filter {
    public static BufferedImage grayScale(BufferedImage image, float r, float g, float b) {
        BufferedImage newImage = BufferedImageUtils.createBlankImage(image.getWidth(), image.getHeight());

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixelColor = image.getRGB(x, y);

                int alpha = (pixelColor >> 24) & 0xFF;
                int red = (pixelColor >> 16) & 0xFF;
                int green = (pixelColor >> 8) & 0xFF;
                int blue = pixelColor & 0xFF;

                int newColor = (int) (((red * r) + (green * g) + (blue * b)) / 3);
                int newPixelColor = ((alpha << 24) | (newColor << 16) | (newColor << 8) | newColor);

                newImage.setRGB(x, y, newPixelColor);
            }
        }

        return newImage;
    }

    public static BufferedImage GaussianLowPass(BufferedImage image) {
        int[][] gaussianMask = {
                { 1, 2, 1 },
                { 2, 4, 2 },
                { 1, 2, 1 }
        };

        BufferedImage newImage = BufferedImageUtils.createBlankImage(image.getWidth(), image.getHeight());

        int maskSum = 16;

        for (int x = 1; x < image.getWidth() - 1; x++) {
            for (int y = 1; y < image.getHeight() - 1; y++) {
                int redSum = 0;
                int greenSum = 0;
                int blueSum = 0;

                for (int xx = -1; xx <= 1; xx++) {
                    for (int yy = -1; yy <= 1; yy++) {
                        int pixel = image.getRGB(x + xx, y + yy);

                        int red = (pixel >> 16) & 0xFF;
                        int green = (pixel >> 8) & 0xFF;
                        int blue = pixel & 0xFF;

                        int weight = gaussianMask[xx + 1][yy + 1];
                        redSum += red * weight;
                        greenSum += green * weight;
                        blueSum += blue * weight;
                    }
                }

                int alpha = (image.getRGB(x, y) >> 24) & 0xFF;
                
                int red = Math.min(255, redSum / maskSum);
                int green = Math.min(255, greenSum / maskSum);
                int blue = Math.min(255, blueSum / maskSum);

                int newPixelColor = (alpha << 24) | (red << 16) | (green << 8) | blue;
                newImage.setRGB(x, y, newPixelColor);
            }
        }

        return newImage;
    }
}
