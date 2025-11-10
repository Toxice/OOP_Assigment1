package Basics;

import biuoop.DrawSurface;

import java.awt.*;

/**
 * Ball Object, made of a Point representing its center,
 * an int representing its radius,
 * and a Color representing its Color
 */
public class Ball {
    Point Center;
    int Radius;
    Color color;

    public Ball(Point point, int r, Color color) {
        this.Center = point;
        this.Radius = r;
        this.color = color;
    }

    public Ball(double _x, double _y, int radius, Color color) {
        this(new Point(_x, _y), radius, color);
    }

    public int getX() {
        return (int)Math.round(this.Center.getX());
    }

    public int getY() {
        return (int)Math.round(this.Center.getY());
    }

    public int getSize() {
        return this.Radius;
    }

    public Color getColor() {
        return this.color;
    }

    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(this.getColor());
        drawSurface.fillCircle(this.getX(), this.getY(), this.getSize());
    }
}
