package GUI.Lines;

import Basics.LinesAndPoints.Line;
import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class Made for Plotting Lines and Points
 */
public class AbstractArtDrawing {
    static final String Title = "Assignment Part 2 - Lines and Points";
    static final int width = 800;
    static final int height = 600;

    static void main() {
        GUI gui = new GUI(Title, width, height);
        DrawSurface drawSurface = gui.getDrawSurface();
        ArrayList<Line> lines = Line.getLines();
        ArrayList<Point> MiddlePoints = Line.getMiddles(lines);
        ArrayList<Point> Intersections = Line.getIntersections(lines);
        Line.drawOn(drawSurface, lines, MiddlePoints, Intersections);
        gui.show(drawSurface);
    }
}


