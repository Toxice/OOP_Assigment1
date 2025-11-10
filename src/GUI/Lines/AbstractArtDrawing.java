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

    public static ArrayList<Line> getLines() {
        ArrayList<Line> lines = new ArrayList<>(10);
        for (int i = 0; i < 10; ++i) {
            lines.add(createLine(random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1,
                    random.nextInt(width / 2) + 1, random.nextInt(height / 2) + 1));
        }
        return lines;
    }

    /**
     * Creates a Line from x,y coordinates
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
     * Draws the Line to the DrawSurface
     * @param line: Line Object
     * @param drawSurface: DrawSurface Object
     */
    public static void drawLine(Line line, DrawSurface drawSurface) {
        drawSurface.drawLine((int) line.getStart().getX(), (int) line.getStart().getY(),
                (int) line.getEnd().getX(), (int) line.getEnd().getY());
    }

    /**
     * Draws the Middle Point of a Line
     * @param line: Line Object
     * @param drawSurface: DrawSurface Object
     */
    public static void drawMiddlePoint(Line line, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLUE);
        drawSurface.fillCircle((int) Math.round(line.middle().getX()), (int) Math.round(line.middle().getY()), 3);
    }

    /**
     * Draw the Lines
     * @param lines: ArrayList of Lines
     * @param drawSurface: DrawSurface Object
     */
    public static void drawLines(ArrayList<Line> lines, DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLACK);
        for (int i = 0; i < lines.size(); ++i) {
            for (int j = 0; j < lines.size(); ++j) {
                if (i == j) continue;
                drawLine(lines.get(i), drawSurface);
                drawMiddlePoint(lines.get(i), drawSurface);
            }
        }
    }
}


