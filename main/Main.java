package main;

import shapes.*;
import java.awt.Image;
import java.awt.Color;

interface Displayable {
    void display(int x, int y, Color color);
    void save(String string);
}

interface Drawable {
    void draw(Displayable displayable);
    Color getColor();
}

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);
        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        //rectangle.draw(image);
        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        //triangle.draw(image);

        /*for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }*/
        image.save("image.png");
    }
}


class Image implements Displayable {
    private int width;
    private int height;
    private Color[][] pixels;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = Color.WHITE;
            }
        }
    }

    public void display(int x, int y, Color color) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            pixels[x][y] = color;
        }
    }

    public void save(String filename) {
        System.out.println("Image saved as " + filename);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}