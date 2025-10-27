package main;

import shapes.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;




class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);
        Rectangle rectangle = new Rectangle(new Point(50, 60), new Point(150, 300));
        rectangle.draw(image);
        Triangle triangle = new Triangle(new Point(500, 500), new Point(250, 700), new Point(700, 800));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }
        image.save("image.png");
    }
}



public class Image implements Displayable {
    private final BufferedImage bufferedImage;
    private final int width;
    private final int height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                bufferedImage.setRGB(x, y, new Color(0, 0, 0, 255).getRGB());
            }
        }
    }

    public void display(int x, int y, Color color) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }

    public void save(String filename) {
        try {
            File file = new File(filename);
            ImageIO.write(bufferedImage, "png", file);
            System.out.println("Image saved as: " + filename);
        } catch (IOException e) {
            System.err.println("Failed to save image: " + e.getMessage());
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}