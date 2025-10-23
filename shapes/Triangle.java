package shapes;

import main.Image;
import java.awt.Color;

public class Triangle {
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

    public void draw(Image image) {
        Color color = Color.BLUE;
        Line line1 = new Line(pointA, pointB);
        Line line2 = new Line(pointB, pointC);
        Line line3 = new Line(pointC, pointA);

        line1.draw(image ,color);
        line2.draw(image ,color);
        line3.draw(image ,color);
    }
}
