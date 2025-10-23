package shapes;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class geometrical_shapes {
    public static void main(String[] args) throws IOException {
        int width = 400, height = 300;

        // Create a BufferedImage
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get Graphics2D object for drawing
        Graphics2D g2d = image.createGraphics();

        // Fill background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Draw a red circle
        g2d.setColor(Color.RED);
        g2d.fillOval(50, 50, 200, 200);

        // Draw text
        g2d.setColor(Color.BLACK);
        g2d.drawString("Hello, Java Raster!", 100, 280);

        // Dispose graphics context
        g2d.dispose();

        // Save image to file
        ImageIO.write(image, "png", new File("output.png"));
    }
}
