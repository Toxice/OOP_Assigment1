package Basics;

/**
 * Line Object, made of two Point Objects
 * start - start Point
 * end - end Point
 * slope - the slope of the line
 * intercept - the b point of the line (y = mx + b)
 */
public class Line {
    Point start;
    Point end;
    private final double slope;
    private final double intercept;

    /**
     * Take two Point Objects and create a Line from them
     * @param start: Point
     * @param end: Point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        this.intercept = calIntercept();
    }

    /**
     * Take Four Coordinates and make two Points and Make a Line from them
     * @param x1: coordinate
     * @param y1: coordinate
     * @param x2: coordinate
     * @param y2: coordinate
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.slope = ((y2 - y1) / (x2 - x1));
        this.intercept = calIntercept();
    }

    /**
     * Calculate the Length of the Line
     * @return the length of the line, made of the distance between two Points
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Find The Middle Point of the Line
     * @return the middle Point, takes the average of two Points
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }

    /**
     * Check if This Line intersects with any other lines
     * @param other: Line Object
     * @return true iff This intersects with other Line, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (this.getSlope() == other.getSlope()) {
            return false;
        } else {
            return intersectionWith(other) != null;
        }
    }

    /**
     * Calculate the Intersection Point between the two Lines
     * Calculate the Point, and Check if it's the parameter of the two lines
     * return if the point if so, return null otherwise
     * @return Point Object, may be null
     */
    public Point intersectionWith(Line other) {
        if (this.getSlope() != other.getSlope()) {
            double _x = ((other.getIntercept() - this.getIntercept()) / (this.getSlope() - other.getSlope())); // get X Value
            double _y = this.getSlope() * _x + this.getIntercept(); // get Y Value
            Point intersectionPoint = new Point(_x, _y); // get Full Point

            if (this.contains(intersectionPoint) && other.contains(intersectionPoint)) {
                return intersectionPoint;
            }
        } return null;
    }

    public double getSlope() {
        return slope;
    }

    public double getIntercept() {
        return this.intercept;
    }

    private double calIntercept() {
        return this.getEnd().getY() - getSlope() * this.getEnd().getX();
    }

    /**
     * Check's if a Point is contained in this Line
     * @param point: Point object
     * @return true iff the Point lies between the Line Perimeter and Matches the Line Equation
     */
    public boolean contains(Point point) {
        if (point.getY() == this.getSlope() * point.getX() + this.getIntercept()) {
            boolean X_Min = point.getX() >= Math.min(this.getStart().getX(), this.getEnd().getX());
            boolean X_Max = point.getX() <= Math.max(this.getStart().getX(), this.getEnd().getX());
            boolean Y_Min = point.getY() >= Math.min(this.getStart().getY(), this.getEnd().getY());
            boolean Y_Max = point.getY() <= Math.max(this.getStart().getY(), this.getEnd().getY());

            return X_Min && X_Max && Y_Min && Y_Max;
        } return false;
    }

    @Override
    public String toString() {
        return "(" +  this.getStart().toString() + "," + this.getEnd().toString() + ")";
    }
}
