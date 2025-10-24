package shapes;

import java.awt.Color;
import main.Drawable;
import main.Displayable;
import java.util.Random;


public class Rectangle implements Drawable {
    Point topLeft;
    Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public void draw(Displayable displayable) {
        Color color = this.getColor();

        for (int x = topLeft.x; x <= bottomRight.x; x++) {
            displayable.display(x, topLeft.y, color);
            displayable.display(x, bottomRight.y, color);
        }

        for (int y = topLeft.y; y <= bottomRight.y; y++) {
            displayable.display(topLeft.x, y, color);
            displayable.display(bottomRight.x, y, color);
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
