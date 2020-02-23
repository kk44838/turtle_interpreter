package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public abstract class AbstractTurtle implements Turtle {
  protected int x;
  protected int y;
  protected Direction direction;
  protected Pen penState;
  protected char brush;
  protected Paper paper;


  public AbstractTurtle(int x, int y, Direction direction, Pen penState, char brush,
                      Paper paper) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.penState = penState;
    this.brush = brush;
    this.paper = paper;
  }


  public void penUp() {
    penState = Pen.UP;
  }

  public void penDown() {
    penState = Pen.DOWN;
  }

  public void changeBrush(char brush) {
    this.brush = brush;
  }

  public void rotateTurtle(Rotation rotation, int numberOfRotations) {
    for (int i = 0; i < numberOfRotations; i++) {
      this.direction = direction.rotation(rotation);
    }
  }

  public void markPaper() {
    if(penState == Pen.DOWN) {
      paper.markPaper(x, y, brush);
    }
  }

  public abstract void moveAndMark(int steps);

}
