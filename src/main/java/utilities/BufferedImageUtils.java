package utilities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class BufferedImageUtils {
    public static BufferedImage defaultImage() {
        try (InputStream is = BufferedImageUtils.class.getResourceAsStream("/Comprimidos_1.png")) {
            if (is == null) {
                System.out.println("Failed to load default image");
                return null;
            }
            BufferedImage image = ImageIO.read(is);
            System.out.println("Image loaded successfully!");
            return image;
        } catch (IOException e) {
            System.out.printf("Failed to load default image with error: %s\n", e.getMessage());
        }
        return null;
    }
    
    public static BufferedImage createBlankImage(int width, int height) {
        BufferedImage blankImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g = blankImage.createGraphics();
        g.fillRect(0, 0, width, height);
        g.dispose();
        
        return blankImage;
    }
    
    public static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    
    public static BufferedImage setSize(BufferedImage bi, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(bi, 0, 0, null);
        g.dispose();
        
        return resizedImage;
    }
}