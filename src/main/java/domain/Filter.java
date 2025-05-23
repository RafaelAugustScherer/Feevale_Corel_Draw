/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.awt.Color;
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
    
    public static BufferedImage RobertsHighPass(BufferedImage image, int threshold) {
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        
        BufferedImage newImage = BufferedImageUtils.createBlankImage(imageWidth, imageHeight);
        
        BufferedImage grayScaledImage = Filter.grayScale(image, 1, 1, 1);
        
        for (int x = 0; x < imageWidth; x++) {
            newImage.setRGB(x, 0, image.getRGB(x, 0));
            newImage.setRGB(x, imageHeight - 1, image.getRGB(x, imageHeight - 1));
        }
        
        for (int y = 0; y < imageHeight; y++) {
            newImage.setRGB(0, y, image.getRGB(0, y));
            newImage.setRGB(imageWidth - 1, y, image.getRGB(imageWidth - 1, y));
        }
        
        for (int x = 0; x < imageWidth - 1; x++) {
            for (int y = 0; y < imageHeight - 1; y++) {
                
                int pixelColor = (grayScaledImage.getRGB(x , y) >> 16) & 0xFF;
                int pixelRightColor = (grayScaledImage.getRGB(x+1, y) >> 16) & 0xFF;
                int pixelDownColor = (grayScaledImage.getRGB(x, y+1) >> 16) & 0xFF;
                int pixelRightDownColor = (grayScaledImage.getRGB(x+1, y+1) >> 16) & 0xFF;
                
                int xGradient = -pixelRightDownColor + pixelColor;
                int yGradient = -pixelDownColor + pixelRightColor;
                
                double compareToThreshold = Math.sqrt(Math.pow(xGradient, 2) + Math.pow(yGradient, 2));
                if ((int) compareToThreshold > threshold) {
                    newImage.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    newImage.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        return newImage;
    }
    
    public static BufferedImage KirschThreshold(BufferedImage image, int threshold) {
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        BufferedImage newImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        BufferedImage grayScaledImage = Filter.grayScale(image, 1, 1, 1);

        int[][][] kirschKernels = {
            { { 5, 5, 5 }, { -3, 0, -3 }, { -3, -3, -3 } },
            { { 5, 5, -3 }, { 5, 0, -3 }, { -3, -3, -3 } },
            { { 5, -3, -3 }, { 5, 0, -3 }, { 5, -3, -3 } },
            { { -3, -3, -3 }, { 5, 0, -3 }, { 5, 5, -3 } },
            { { -3, -3, -3 }, { -3, 0, -3 }, { 5, 5, 5 } },
            { { -3, -3, -3 }, { -3, 0, 5 }, { -3, 5, 5 } },
            { { -3, -3, 5 }, { -3, 0, 5 }, { -3, -3, 5 } },
            { { -3, 5, 5 }, { -3, 0, 5 }, { -3, -3, -3 } }
        };

        for (int x = 1; x < imageWidth - 1; x++) {
            for (int y = 1; y < imageHeight - 1; y++) {
                int maxGradient = 0;

                for (int[][] kernel: kirschKernels) {
                    int sum = 0;

                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int pixel = (grayScaledImage.getRGB(x + i, y + j) >> 16) & 0xFF;
                            sum += pixel * kernel[j + 1][i + 1];
                        }
                    }

                    if (sum > maxGradient) {
                        maxGradient = sum;
                    }
                }

                if (maxGradient > threshold) {
                    newImage.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    newImage.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        return newImage;
    }
}
