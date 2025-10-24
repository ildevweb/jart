package main;

import java.awt.Color;

public interface Drawable {
    void draw(Displayable displayable);
    Color getColor();
}