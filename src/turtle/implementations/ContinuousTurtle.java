package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;

public class ContinuousTurtle extends AbstractTurtle  {

  public ContinuousTurtle(int x, int y, Direction direction, Pen penState, char brush, Paper paper) {
    super(x, y, direction, penState, brush, paper);
  }

  @Override
  public void moveAndMark(int steps) {
    for (int i = 0; i < steps; i++) {
      int nextX = x + direction.getNextX();
      int nextY = y + direction.getNextY();

      if(paper.inBounds(nextX, nextY)){
        this.x = nextX;
        this.y = nextY;
        markPaper();
      } else {
        this.x = nextX;
        this.y = nextY;
      }

    }
  }


}