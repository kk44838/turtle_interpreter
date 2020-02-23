package turtle;

import turtle.util.Pen;
import turtle.util.Rotation;

public interface Turtle {
  void penUp();

  void penDown();

  void changeBrush(char brush);

  void rotateTurtle(Rotation rotation, int numberOfRotations);

  void markPaper();

  void moveAndMark(int steps);

}
