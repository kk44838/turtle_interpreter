package turtle.implementations;

import turtle.Turtle;
import turtle.util.Rotation;

public class ClusterTurtle implements Turtle {
  private Turtle[] turtles;

  public ClusterTurtle(Turtle[] turtles) {
    this.turtles = turtles;
  }

  @Override
  public void penUp() {

    for (Turtle t : turtles) {
      t.penUp();
    }
  }

  @Override
  public void penDown() {
    for (Turtle t : turtles) {
      t.penDown();
    }
  }

  @Override
  public void changeBrush(char brush) {
    for (Turtle t : turtles) {
      t.changeBrush(brush);
    }
  }

  @Override
  public void rotateTurtle(Rotation rotation, int numberOfRotations) {
    for (Turtle t : turtles) {
      t.rotateTurtle(rotation, numberOfRotations);
    }
  }

  @Override
  public void markPaper() {
    for (Turtle t : turtles) {
      t.markPaper();
    }
  }

  @Override
  public void moveAndMark(int steps) {
    for (Turtle t : turtles) {
      t.moveAndMark(steps);
    }
  }

}
