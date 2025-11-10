package Basics;

/**
 * Point Object, made of two doubles: x value and a y value
 */
public class Point {
    double x,y;

    private static final double EPS = 1e-9;

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

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return Math.abs(this.getX() - other.getX()) < EPS
                && Math.abs(this.getY() - other.getY()) < EPS;
    }

    @Override
    public int hashCode() {
        // Use rounded values so hashCode aligns with EPS-tolerant equals
        long xBits = Double.doubleToLongBits(Math.round(this.getX() / EPS) * EPS);
        long yBits = Double.doubleToLongBits(Math.round(this.getY() / EPS) * EPS);
        int result = (int)(xBits ^ (xBits >>> 32));
        result = 31 * result + (int)(yBits ^ (yBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }
}
