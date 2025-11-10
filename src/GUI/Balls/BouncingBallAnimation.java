package GUI.Balls;

import Basics.Balls.Ball;
import Basics.LinesAndPoints.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import biuoop.*;

import java.util.Scanner;

public class BouncingBallAnimation {
    final static String Title = "Part 2 - Bouncing Balls";
    final static int Width = 200;
    final static int Height = 200;
    static void main() {
        System.out.println("Enter 4 Integers");
        Scanner in = new Scanner(System.in);
        int xPoint = in.nextInt();
        int yPoint = in.nextInt();
        int dx = in.nextInt();
        int dy = in.nextInt();
        drawAnimation(new Point(xPoint,yPoint), dx, dy);
    }

    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI(Title, Width, Height);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep();
            System.out.println("Velocity: " +  ball.getVelocity());
            System.out.println("Location: " + ball);
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
