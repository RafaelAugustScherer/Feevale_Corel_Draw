/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.awt.Color;
import java.awt.image.BufferedImage;
import types.ChallengeResult;
import utilities.BufferedImageUtils;

/**
 *
 * @author Rafael
 */
public class Challenge {
    public static ChallengeResult execute(BufferedImage image) {
        BufferedImage newImage = BufferedImageUtils.deepCopy(image);
        
        ChallengeResult result = new ChallengeResult(newImage, 0, 0, 0, 0);
        
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixelColor = newImage.getRGB(x, y);
                
                if (isPillPixel(pixelColor)) {
                    int pillPixels = fillPill(newImage, x, y);
                    
                    
                    if (!isValidPill(pillPixels)) {
                        continue;
                    }
                    
                    result.totalPills += 1;
                                        
                    if (isRoundPill(pillPixels)) {
                        result.totalRoundPills += 1;
                    } else if (isCapsulePill(pillPixels)) {
                        result.totalCapsulePills += 1;
                    } else if (isBrokenPill(pillPixels)) {
                        result.brokenPills += 1;
                    }
                }
            }
        }
        
        return result;
    }
    
    private static int fillPill(BufferedImage image, int startX, int startY) {
        int pillQuantityOfPixels = 1;
        
        int currentX = startX;
        int currentY = startY;
 
        // 1: Preenche coluna inicial e define o ponto da metade da forma
        while(isPillPixel(image.getRGB(currentX, currentY + 1))) {
                image.setRGB(currentX, currentY, Color.BLACK.getRGB());
                currentY += 1;
            }
        
        int startMiddleY = startY + ((currentY - startY) / 2);
        int middleY = startY + ((currentY - startY) / 2);
        
        // 2: Preenche todas as colunas à direita
        while(isPillPixel(image.getRGB(currentX + 1, middleY))) {
            int minY;
            int maxY;
            
            currentX += 1;
            currentY = middleY;
            
            while(isPillPixel(image.getRGB(currentX, currentY + 1))) {
                image.setRGB(currentX, currentY, Color.BLACK.getRGB());
                currentY += 1;
                pillQuantityOfPixels += 1;
            }
            image.setRGB(currentX, currentY + 1, Color.BLACK.getRGB());
            maxY = currentY;
            
            currentY = middleY;
            while(isPillPixel(image.getRGB(currentX, currentY - 1))) {
                image.setRGB(currentX, currentY, Color.BLACK.getRGB());
                currentY -= 1;
                pillQuantityOfPixels += 1;
            }
            image.setRGB(currentX, currentY - 1, Color.BLACK.getRGB());
            minY = currentY;
            
            middleY = minY + ((maxY - minY) / 2); 
        }
        
        // 3: Preenche todas as colunas à esquerda
        currentX = startX;
        middleY = startMiddleY;
        while(isPillPixel(image.getRGB(currentX - 1, middleY))) {
            int minY;
            int maxY;
            
            currentX -= 1;
            currentY = middleY;
            
            while(isPillPixel(image.getRGB(currentX, currentY + 1))) {
                image.setRGB(currentX, currentY, Color.BLACK.getRGB());
                currentY += 1;
                pillQuantityOfPixels += 1;
            }
            maxY = currentY;
            
            currentY = middleY;
            while(isPillPixel(image.getRGB(currentX, currentY - 1))) {
                image.setRGB(currentX, currentY, Color.BLACK.getRGB());
                currentY -= 1;
                pillQuantityOfPixels += 1;
            }
            minY = currentY;
            
            middleY = minY + ((maxY - minY) / 2); 
        }
        return pillQuantityOfPixels;
    }
    
    private static boolean isPillPixel(int pixelColor) {
        int red = (pixelColor >> 16) & 0xFF;
        int green = (pixelColor >> 8) & 0xFF;
        int blue = pixelColor & 0xFF;
        
        int avg = (red + green + blue) / 3;
        return avg > 36;
    }
    
    private static boolean isValidPill(int quantityOfPixels) {
        return quantityOfPixels >= 500;
    }
    
    private static boolean isRoundPill(int quantityOfPixels) {
        return quantityOfPixels >= 9500 && quantityOfPixels < 12000;
    }
    
    private static boolean isCapsulePill(int quantityOfPixels) {
        return quantityOfPixels >= 12000 && quantityOfPixels < 15000;
    }
    
    private static boolean isBrokenPill(int quantityOfPixels) {
        return quantityOfPixels >= 500 && quantityOfPixels < 9500;
    }
}
