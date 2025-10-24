package shapes;

import main.Image;
import java.awt.Color;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Image image) {
        Color color = Color.WHITE;

        image.display(this.x, this.y, color);
    }
}
