/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import utilities.BufferedImageUtils;

/**
 *
 * @author Rafael
 */
public class Transform {
     public static BufferedImage translate(BufferedImage image, int[] startPosition, int[] desiredPosition) {
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
}
