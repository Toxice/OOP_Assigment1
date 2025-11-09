package GUI.Lines;

import Basics.Line;
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

    public static ArrayList<Line> getLines() {
        ArrayList<Line> lines = new ArrayList<>(10);
        for (int i = 0; i < 10; ++i) {
            lines.add(createLine(random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1,
                    random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1));
        }
        return lines;
    }
    /**
     * Main Function
     */
    static void main() {
        ArrayList<Line> lines = getLines();
        GUI gui = new GUI(Title, width, height);
        DrawSurface drawSurface = gui.getDrawSurface();
        for (int i = 0; i < 10; ++i) {
            // Lines Drawing Loop
            drawLine(lines.get(i), drawSurface);
            drawMiddlePoint(lines.get(i), drawSurface);
        }
        // Intersection Points Loop
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (i == j) continue;
                if (lines.get(i).intersectionWith(lines.get(j)) != null) {
                    drawSurface.setColor(Color.RED);
                    drawSurface.fillCircle((int) lines.get(i).intersectionWith(lines.get(j))
                            .getX(),(int) lines.get(i).intersectionWith(lines.get(j))
                            .getY(), 4);
                    System.out.println(lines.get(i).intersectionWith(lines.get(j)));
                }
            }
        }
        gui.show(drawSurface);
        }

    /**
     * Creates a Line from x,y coordinates
     * @param x1: coordinate
     * @param y1: coordinate
     * @param x2: coordinate
     * @param y2: coordinate
     * @return a new Line
     */
    public static Line createLine(int x1, int y1, int x2, int y2) {
        return new Line(x1, y1, x2, y2);
    }

    /**
     * Returns the X coordinate of the Middle Point of a Line
     * @param line: a Line
     * @return the X coordinate of the middle Point
     */
    public double returnMiddleX(Line line) {
        return line.middle().getX();
    }

    /**
     * Returns the Y coordinate of the Middle Point of a Line
     * @param line: a Line
     * @return the Y coordinate of the middle Point
     */
    public double returnMiddleY(Line line) {
        return line.middle().getY();
    }

    public static void drawLine(Line line, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLACK);
        drawSurface.drawLine((int) line.getStart().getX(), (int) line.getStart().getY(),
                (int) line.getEnd().getX(), (int) line.getEnd().getY());
    }

    public static void drawMiddlePoint(Line line, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLUE);
        drawSurface.fillCircle((int) line.middle().getX(), (int) line.middle().getY(), 3);
    }
}


