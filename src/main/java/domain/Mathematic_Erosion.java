/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author asfen
 */
public class Mathematic_Erosion {

    public static BufferedImage erosion(BufferedImage image, int tolerance) {
        int width = image.getWidth();
        int height = image.getHeight();
        image = Filter.grayScale(image, 1, 1, 1);
        BufferedImage outputImage = new BufferedImage(width, height, image.getType());

        int kernel = 1;
        Color backgroungColor = new Color(image.getRGB(1, 1));

        //Laço sobre imagem
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                boolean erode = true;
                Color centerColor = new Color(image.getRGB(x, y));

                for (int i = -kernel; i <= kernel; i++) {
                    int[] dx = {i, 0};
                    int[] dy = {0, i};

                    for (int j = 0; j < 2; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];

                        if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                            Color neighborColor = new Color(image.getRGB(nx, ny));

                            //Verifica tolerância de cor dentro da máscara
                            if (!colorWithinTolerance(neighborColor, centerColor, tolerance)) {
                                erode = false;
                                break;
                            }
                        } else {
                            // Fora da imagem = falha na erosão
                            erode = false;
                            break;
                        }
                    }

                    if (!erode) break;
                }

                // Define pixel de saída
                if (erode) {
                    outputImage.setRGB(x, y, centerColor.getRGB());
                } else {
                    outputImage.setRGB(x, y, backgroungColor.getRGB());
                }
            }
        }
        return outputImage;
    }

    //Compara cores dentro da tolerância
    private static boolean colorWithinTolerance(Color c1, Color c2, int tolerance) {
        int dr = Math.abs(c1.getRed() - c2.getRed());
        int dg = Math.abs(c1.getGreen() - c2.getGreen());
        int db = Math.abs(c1.getBlue() - c2.getBlue());
        return dr <= tolerance && dg <= tolerance && db <= tolerance;
    }

    public static BufferedImage dilation(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        //define cor do background
        Color backgroundColor = new Color(image.getRGB(0, 0));
        int firstPixelIntensity = backgroundColor.getRed();

        boolean darkBackground = firstPixelIntensity < 128;

        image = Filter.grayScale(image, 1, 1, 1);
        BufferedImage outputImage = new BufferedImage(width, height, image.getType());

        // Percorre cada pixel da imagem
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int extremumIntensity = darkBackground ? 0 : 255;

                for (int dy = -2; dy <= 2; dy++) {
                    for (int dx = -2; dx <= 2; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;

                        if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                            Color neighborColor = new Color(image.getRGB(nx, ny));
                            int intensity = neighborColor.getRed(); // Grayscale image

                            if (darkBackground) {
                                // Dilatação em fundo escuro (max intensidade)
                                if (intensity > extremumIntensity) {
                                    extremumIntensity = intensity;
                                }
                            } else {
                                // Dilatação em fundo claro (min intensidade)
                                if (intensity < extremumIntensity) {
                                    extremumIntensity = intensity;
                                }
                            }
                        }
                    }
                }

                // Aplica a intensidade calculada (dilatação de acordo com fundo)
                Color newColor = new Color(extremumIntensity, extremumIntensity, extremumIntensity);
                outputImage.setRGB(x, y, newColor.getRGB());
            }
        }

        return outputImage;
    }
}