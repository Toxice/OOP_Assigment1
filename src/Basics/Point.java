package Basics;

import java.util.Objects;
import java.util.Set;

// a point has an x and a y value, and can measure the distance to other points, and if it is equal to another point.
public class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculating the distance between the current point and some other point
     * @param other: Point Object
     * @return double: the distance between current and other
     */
    public double distance(Point other) {
        double x2 = other.x;
        double y2 = other.y;
        double determinant = ((this.x-x2)*(this.x-x2))+((this.y-y2)*(this.y-y2)); // calculating the raw distance between this and other
        return Math.sqrt(determinant);
    }

    /**
     * comparing between the current point and some other point
     * @param other: Point Object
     * @return true iff x and y values of the two points are equal
     */
    public boolean equals(Point other) {
        return (this.x == other.x) && (this.y == other.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point other)) return false;
        return Double.compare(this.x, other.x) == 0 &&
                Double.compare(this.y, other.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
