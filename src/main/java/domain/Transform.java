/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.awt.image.BufferedImage;

import types.Orientation;
import utilities.BufferedImageUtils;

/**
 *
 * @author Rafael
 */
public class Transform {
    public static BufferedImage translate(BufferedImage image, int[] desiredPosition) {
        BufferedImage newImage = BufferedImageUtils.createBlankImage(
                image.getWidth() + desiredPosition[0],
                image.getHeight() + desiredPosition[1]);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixelColor = image.getRGB(x, y);

                int xPosition = x + desiredPosition[0];
                int yPosition = y + desiredPosition[1];
                newImage.setRGB(xPosition, yPosition, pixelColor);
            }
        }

        return newImage;
    }

    public static BufferedImage rotate(BufferedImage image, int degrees) {
        double radians = Math.toRadians(degrees);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        int width = image.getWidth();
        int height = image.getHeight();

        int newWidth = (int) Math.ceil(Math.abs(width * cos) + Math.abs(height * sin));
        int newHeight = (int) Math.ceil(Math.abs(width * sin) + Math.abs(height * cos));

        BufferedImage newImage = BufferedImageUtils.createBlankImage(newWidth, newHeight);

        int centerX = width / 2;
        int centerY = height / 2;
        int newCenterX = newWidth / 2;
        int newCenterY = newHeight / 2;

        for (int newX = 0; newX < newWidth; newX++) {
            for (int newY = 0; newY < newHeight; newY++) {
                int centeredNewX = newX - newCenterX;
                int centeredNewY = newY - newCenterY;

                int originalX = (int) Math.round(centeredNewX * cos + centeredNewY * sin) + centerX;
                int originalY = (int) Math.round(-centeredNewX * sin + centeredNewY * cos) + centerY;

                if (originalX >= 0 && originalX < width && originalY >= 0 && originalY < height) {
                    newImage.setRGB(newX, newY, image.getRGB(originalX, originalY));
                }
            }
        }

        return newImage;
    }

    public static BufferedImage mirror(BufferedImage image, Orientation orientation) {
        BufferedImage newImage = BufferedImageUtils.createBlankImage(image.getWidth(), image.getHeight());

        int imageBorderX = image.getWidth() - 1;
        int imageBorderY = image.getHeight() - 1;

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixelColor = image.getRGB(x, y);

                int xPosition = x;
                int yPosition = y;

                if (orientation == Orientation.HORIZONTAL) {
                    xPosition = imageBorderX - x;
                } else if (orientation == Orientation.VERTICAL) {
                    yPosition = imageBorderY - y;
                }

                newImage.setRGB(xPosition, yPosition, pixelColor);
            }
        }

        return newImage;
    }

    public static BufferedImage augment(BufferedImage image, int times) {
        BufferedImage newImage = BufferedImageUtils.createBlankImage(
                image.getWidth() * times,
                image.getHeight() * times);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixelColor = image.getRGB(x, y);

                for (int fillX = 0; fillX < times; fillX++) {
                    for (int fillY = 0; fillY < times; fillY++) {
                        int newX = x * times + fillX;
                        int newY = y * times + fillY;
                        newImage.setRGB(newX, newY, pixelColor);
                    }
                }
            }
        }

        return newImage;
    }

    public static BufferedImage reduce(BufferedImage image, int times) {
        int newWidth = image.getWidth() / times;
        int newHeight = image.getHeight() / times;

        BufferedImage newImage = BufferedImageUtils.createBlankImage(newWidth, newHeight);

        for (int newX = 0; newX < newWidth; newX++) {
            for (int newY = 0; newY < newHeight; newY++) {
                int redSum = 0, greenSum = 0, blueSum = 0;

                for (int blockX = 0; blockX < times; blockX++) {
                    for (int blockY = 0; blockY < times; blockY++) {
                        int x = newX * times + blockX;
                        int y = newY * times + blockY;

                        int pixel = image.getRGB(x, y);

                        redSum += (pixel >> 16) & 0xFF;
                        greenSum += (pixel >> 8) & 0xFF;
                        blueSum += pixel & 0xFF;
                    }
                }

                int pixelsInBlock = times * times;
                int red = redSum / pixelsInBlock;
                int green = greenSum / pixelsInBlock;
                int blue = blueSum / pixelsInBlock;

                int pixelColor = (0xFF << 24) | (red << 16) | (green << 8) | blue;

                newImage.setRGB(newX, newY, pixelColor);
            }
        }

        return newImage;
    }
}
