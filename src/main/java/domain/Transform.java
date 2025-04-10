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
                image.getHeight() + desiredPosition[1]
        );

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
}
