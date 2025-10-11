package main;

import shapes.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


interface Displayable {
    void display(int x, int y, Color color);
    void save(String string);
}

interface Drawable {
    void draw(Displayable displayable);
    Color getColor();
}


class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);
        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        rectangle.draw(image);
        /*Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }*/
        image.save("image.png");
    }
}


public class Image implements Displayable {
    private int width;
    private int height;
    private Color[][] pixels;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = Color.BLACK;
            }
        }
    }

    public void display(int x, int y, Color color) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            pixels[x][y] = color;
        }
    }


    public void save(String filename) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x >= 0 && x < width && y >= 0 && y < height) {
                    Color color = pixels[x][y];
                    if (color == null) color = Color.WHITE;
                    image.setRGB(x, y, color.getRGB());
                }
            }
        }

        try {
            File outputFile = new File(filename);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Image saved as " + filename);
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