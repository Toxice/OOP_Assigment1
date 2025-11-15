🎾 Java 2D Ball & Geometry Animation

A lightweight Java animation and geometry engine that simulates balls whi bounce against surfaces, multi-frame balls environments, and geometric computations, built using pure Java (with biuoop-1.4 library for rendering).

This project demonstrates:

Real-time 2D ball physics (velocity, collision, boundaries)

Multiple animation modes

Geometric primitives & intersection detection

Multi-frame environments

Clean OOP design with reusable components

Perfect for computer graphics, OOP practice, or building visual simulations.

🧠 Core Features

✅ Physics & Animation:

Single ball bouncing with realistic boundary collision

Multiple balls moving simultaneously

Independent frame “containers” where balls interact only within assigned frames

Dynamic velocity and movement calculations

✅ Geometry Utilities:

Point, Line, Vector (Velocity)

Line intersection detection

Midpoint, length, slope, and linear equations

Geometry testing suite

✅ Art Mode 🎨:

Abstract art generation using geometric patterns

📂 Project Structure

File	Description:

Ball.java	Represents a moving ball with physics, size, color, and collision logic

Velocity.java	2D vector utility for speed & direction handling

Point.java	2D coordinate point abstraction

Line.java	Line segment math, intersection detection, slopes, equations

BouncingBallAnimation.java	Runs a single bouncing ball animation

MultipleBouncingBallsAnimation.java	Runs animation with multiple balls

MultipleFramesBouncingBallsAnimation.java	Assigns balls into visual frames (sub-windows)

AbstractArtDrawing.java	Generates artistic geometric visuals

GeometryTester.java	Debug/testing suite for geometry utilities

🚀 Running the Project

1️⃣ Compile
`javac -cp biuoop-1.4.jar *.java`

2️⃣ Run Animation Modes

Mode	Command

Single bouncing ball	`java -cp .;biuoop-1.4.jar BouncingBallAnimation`

Multiple balls	`java -cp .;biuoop-1.4.jar MultipleBouncingBallsAnimation 5 10 15`

Multi-frame balls	`java -cp .;biuoop-1.4.jar MultipleFramesBouncingBallsAnimation 5 10 15 20`

Geometry output test	java GeometryTester
Abstract art mode	java AbstractArtDrawing

⚠️ On Linux/Mac, replace ; with : in classpath.

🧮 Example Input (Multiple Balls)

`java -cp .;biuoop-1.4.jar MultipleBouncingBallsAnimation 10 20 5 15 25`


Each argument represents ball radius, and balls spawn with randomized velocity.

⚙️ Concepts Used

✔ Object Oriented Design

✔ Physics simulation basics

✔ Linear Algebra (vectors, slopes, line equations)

✔ Collision detection

✔ GUI animation loop

✔ Randomization

✔ Modular reusable architecture

🛠 Future Improvements (optional ideas)

🪄 Elastic ball-to-ball collision

🪄 Gravity simulation

🪄 GUI sliders for speed & size

🪄 Path tracing and motion history

🪄 Sound on wall collision

🪄 More art generators

💡 Author

Created as part of an Object Oriented Programming assignment – focused on clean design, maintainability, and physics-based animation.

⭐ If you like this project

Give it a star, fork it, and play with it! 🚀
Happy coding, Mor 👋
