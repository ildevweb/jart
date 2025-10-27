package shapes;

import main.Displayable;
import java.awt.Color;

public class Line {
    Point pointA;
    Point pointB;

    public Line(Point a, Point b) {
        this.pointA = a;
        this.pointB = b;
    }

    
    public void draw(Displayable image, Color color) {
        int dx = pointB.x - pointA.x;
        int dy = pointB.y - pointA.y;

        int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);

        double xInc = (double) dx / (double) steps;
        double yInc = (double) dy / (double) steps;

        double x = pointA.x;
        double y = pointA.y;

        for (int i = 0; i <= steps; i++) {
            image.display((int) Math.round(x), (int) Math.round(y), color);
            x += xInc;
            y += yInc;
        }
    }
}
