package shapes;

import main.Image;
import java.awt.Color;

public class Line {
    Point pointA;
    Point pointB;

    public Line(Point a, Point b) {
        this.pointA = a;
        this.pointB = b;
    }

    
    public void draw(Image image, Color color) {

        image.draw_line(pointA, pointB, color);
    }
}
