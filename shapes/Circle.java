package shapes;

import java.util.Random;
import main.Displayable;
import java.awt.Color;

public class Circle {
    Point center;
    int radius;


    public static Circle random(int width, int height) {
        Random random = new Random();

        Circle c = new Circle();
        c.center = new Point(random.nextInt(width), random.nextInt(height));
        c.radius = random.nextInt(141) + 60; 

        return c;
    }

    public void draw(Displayable displayable) {
        int centerX = center.x;
        int centerY = center.y;
        Color circleColor = this.getColor();

        int x = 0;
        int y = radius;
        int decisionParam = 3 - (radius << 1);

        if (radius == 0) {
            displayable.display(centerX, centerY, circleColor);
            return;
        }

        while (y >= x) {
            int[][] points = {
                {centerX + x, centerY + y},
                {centerX - x, centerY + y},
                {centerX + x, centerY - y},
                {centerX - x, centerY - y},
                {centerX + y, centerY + x},
                {centerX - y, centerY + x},
                {centerX + y, centerY - x},
                {centerX - y, centerY - x}
            };

            for (int[] p : points) {
                displayable.display(p[0], p[1], circleColor);
            }

            x++;
            if (decisionParam > 0) {
                y--;
                decisionParam += ((x - y) << 2) + 10;
            } else {
                decisionParam += (x << 2) + 6;
            }
        }
    }


    public Color getColor() {
        Random random = new Random();
        int r = random.nextInt(256); // 0–255
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}
