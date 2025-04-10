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
                int red   = (pixelColor >> 16) & 0xFF;
                int green = (pixelColor >> 8)  & 0xFF;
                int blue  = pixelColor & 0xFF;
                
                int newColor = (int) (((red * r) + (green * g) + (blue * b)) / 3);
                int newPixelColor = ((alpha << 24) | (newColor << 16) | (newColor << 8) | newColor);
                
                newImage.setRGB(x, y, newPixelColor);
            }
        }

        return newImage;
    }
    
//    public static BufferedImage GaussianLowPass(BufferedImage image, int maskSize) {
//        int[] mask = {
//            {1, 2, 1},
//        };
//    }
}
