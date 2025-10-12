package shapes;

import main.Image;
import java.awt.Color;

public class Rectangle {
    Point topLeft;
    Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public void draw(Image displayable) {
        Color color = Color.BLUE;

        for (int x = topLeft.x; x <= bottomRight.x; x++) {
            displayable.display(x, topLeft.y, color);
            displayable.display(x, bottomRight.y, color);
        }

        for (int y = topLeft.y; y <= bottomRight.y; y++) {
            displayable.display(topLeft.x, y, color);
            displayable.display(bottomRight.x, y, color);
        }
    }
}
