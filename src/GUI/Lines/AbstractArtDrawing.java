package GUI.Lines;

import Basics.LinesAndPoints.Line;
import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Made for Plotting Lines and Points
 */
public class AbstractArtDrawing {
    static Random random = new Random();
    static final String Title = "Assignment Part 2 - Lines and Points";
    static final int width = 800;
    static final int height = 600;

    /**
     * Main Function
     */
    static void main() {
        ArrayList<Line> lines = setLines();
        ArrayList<Point> MiddlePoints = getMiddlePoints(lines);
        ArrayList<Point> IntersectionPoints = getIntersectionPoints(lines);
        GUI gui = new GUI(Title, width, height);
        DrawSurface drawSurface = gui.getDrawSurface();
        drawLines(lines, drawSurface);
        drawMiddlePoints(MiddlePoints, drawSurface);
        drawIntersectionPoints(IntersectionPoints, drawSurface);

        gui.show(drawSurface);
    }

    /**
     * Creates a Line from x,y coordinates
     *
     * @param x1: coordinate
     * @param y1: coordinate
     * @param x2: coordinate
     * @param y2: coordinate
     * @return a new Line
     */
    public static Line createLine(double x1, double y1, double x2, double y2) {
        return new Line(x1, y1, x2, y2);
    }

    /**
     * Draws Lines to the DrawSurface
     * @param lines: Line ArrayList
     * @param drawSurface: DrawSurface Object
     */
    public static void drawLines(ArrayList<Line> lines, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLACK);
        for (Line line : lines) {
            System.out.println();
            drawSurface.drawLine((int)Math.round(line.getStart().getX()), (int)Math.round(line.getStart().getY()), (int)Math.round(line.getEnd().getX())
                    ,(int)Math.round(line.getEnd().getY()));
        }
    }

    /**
     * Draws the Intersection Point of two Lines
     * @param intersectionPoints: Point ArrayList
     * @param drawSurface: DrawSurface Object
     */
    public static void drawIntersectionPoints(ArrayList<Point> intersectionPoints, DrawSurface drawSurface) {
        drawSurface.setColor(Color.RED);
        for (Point intersectionPoint : intersectionPoints) {
            drawSurface.fillCircle((int)Math.round(intersectionPoint.getX()), (int)Math.round(intersectionPoint.getY()), 3);
        }
    }

    /**
     * Draws the Middle Points of all Lines
     * @param middlePoints: Point ArrayList
     * @param drawSurface: DrawSurface Object
     */
    public static void drawMiddlePoints(ArrayList<Point> middlePoints, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLUE);
        for (Point middle : middlePoints) {
            drawSurface.fillCircle((int)Math.round(middle.getX()), (int)Math.round(middle.getY()), 3);
        }
    }

    /**
     * Set an ArrayList of Line Objects
     * @return ArrayList of Lines
     */
    public static ArrayList<Line> setLines() {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
                lines.add(createLine(random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1,
                        random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1));
        }
        return lines;
    }

    /**
     * Sets the MiddlePoint ArrayList
     * @param lines: Line Objects ArrayList
     * @return ArrayList of Points
     */
    public static ArrayList<Point> getMiddlePoints(ArrayList<Line> lines) {
        ArrayList<Point> middlePoints = new ArrayList<>(lines.size());
        for (Line line : lines) {
            middlePoints.add(line.middle());
        }
        return middlePoints;
    }

    /**
     * Check's if two lines intersects
     * @param line: Line
     * @param other: Line
     * @return true if the two lines intersects, false otherwise
     */
    public static boolean isIntersects(Line line, Line other) {
        return line.isIntersecting(other) && (line.intersectionWith(other) != null);
    }

    /**
     * Returns the intersection Point between two Line Objects
     * @param line: Line Object
     * @param other: Line Object
     * @return Point that exist both in line and other
     */
    public static Point getIntersectionPoint(Line line, Line other) {
        return line.intersectionWith(other);
    }

    /**
     * Sets the Intersection Points ArrayList
     * @param lines: Line Objects ArrayList
     * @return ArrayList of Intersection Points
     */
    public static ArrayList<Point> getIntersectionPoints(ArrayList<Line> lines) {
        ArrayList<Point> intersectionPoints = new ArrayList<>();
        for (int i = 0; i < lines.size(); ++i) {
            for (int j = i + 1; j < lines.size(); ++j) {
               Line lineI = lines.get(i);
               Line lineJ = lines.get(j);
               if (isIntersects(lineI, lineJ)) {
                   Point intersectionPoint = getIntersectionPoint(lineI, lineJ);
                   if (intersectionPoint != null) {
                       intersectionPoints.add(intersectionPoint);
                   }
                }
            }
        }
        return intersectionPoints;
    }
}


