package shapes;

import java.awt.Color;
import main.Drawable;
import main.Displayable;
import java.util.Random;

public class Triangle implements Drawable {
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    /*public void draw(Image image) {
        Color color = Color.BLUE;

        image.draw_line(pointA, pointB, color);
        image.draw_line(pointB, pointC, color);
        image.draw_line(pointC, pointA, color);
    }*/

    public void draw(Displayable image) {
        Color color = this.getColor();

        Line line1 = new Line(pointA, pointB);
        Line line2 = new Line(pointB, pointC);
        Line line3 = new Line(pointC, pointA);

        line1.draw(image ,color);
        line2.draw(image ,color);
        line3.draw(image ,color);
    }

    public Color getColor() {
        Random random = new Random();
        int r = random.nextInt(256); // 0–255
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}
