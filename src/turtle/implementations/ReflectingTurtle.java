package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

public class ReflectingTurtle extends AbstractTurtle {

  public ReflectingTurtle(int x, int y, Direction direction, Pen penState, char brush, Paper paper) {
    super(x, y, direction, penState, brush, paper);
  }

  @Override
  public void moveAndMark(int steps) {
    for (int i = 0; i < steps; i++) {
      int nextX = x + direction.getNextX();
      int nextY = y + direction.getNextY();

      if (paper.inBounds(nextX, nextY)) {
        this.x = nextX;
        this.y = nextY;
      } else {
        if (shouldRotate180()) {
          this.rotateTurtle(Rotation.RIGHT, 4);
        } else if ((direction == Direction.NORTH_EAST
                    && y == paper.getHeight() - 1)
                || (direction == Direction.SOUTH_WEST
                    && y == 0)) {

          this.x = nextX;
          this.rotateTurtle(Rotation.RIGHT, 2);

        } else if ((direction == Direction.SOUTH_EAST
                    && x == paper.getWidth() - 1)
                || (direction == Direction.NORTH_WEST
                    && x == 0)) {

          this.y = nextY;
          this.rotateTurtle(Rotation.RIGHT, 2);

        } else {

          if (direction == Direction.NORTH_EAST
                  || direction == Direction.SOUTH_WEST) {
            this.y = nextY;
          } else {
            this.x = nextX;
          }

          this.rotateTurtle(Rotation.LEFT, 2);
        }

      }

      markPaper();
    }
  }

  private boolean shouldRotate180() {
    boolean atNorthEast = direction == Direction.NORTH_EAST
            && y == paper.getHeight() - 1
            && x == paper.getWidth() - 1;
    boolean atSouthEast = direction == Direction.SOUTH_EAST
            && x == paper.getWidth() - 1
            && y == 0;
    boolean atSouthWest = direction == Direction.SOUTH_WEST
            && y == 0 && x == 0;
    boolean atNorthWest = direction == Direction.NORTH_WEST
            && x == 0
            && y == paper.getHeight() - 1;
    boolean notDiagonal = direction == Direction.NORTH
            || direction == Direction.EAST
            || direction == Direction.SOUTH
            || direction == Direction.WEST;

    return atNorthEast || atSouthEast || atSouthWest || atNorthWest
            || notDiagonal;
  }

}