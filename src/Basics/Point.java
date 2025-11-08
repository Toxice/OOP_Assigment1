package Basics;

// a point has an x and a y value, and can measure the distance to other points, and if it is equal to another point.
public class Point {
    Double x, y;

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

    /**
     * Checks if the point is smaller than this Point
     * @param point: Point Object
     * @return true if the x and y values of the point is smaller of this point
     */
    public boolean smallerThan(Point point) {
        return point.getX() <= this.getX() && point.getY() <= this.getY();
    }

    /**
     * Checks if the point is bigger than this Point
     * @param point: Point Object
     * @return true if the x and y values of the point is bigger of this point
     */
    public boolean biggerThan(Point point) {
        return point.getX() >= this.getX() && point.getY() >= this.getY();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }


}
