package turtle.util;


  public enum Direction {
    NORTH(0, 1),
    NORTH_EAST(1, 1),
    EAST(1, 0),
    SOUTH_EAST(1, -1),
    SOUTH(0, -1),
    SOUTH_WEST(-1, -1),
    WEST(-1, 0),
    NORTH_WEST(-1, 1);

    private int x;
    private int y;

    Direction(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getNextX() {
      return this.x;
    }

    public int getNextY() {
      return this.y;
    }


  public Direction rotation(Rotation rotation) {
    final int length = Direction.values().length;

    switch (rotation) {
      case LEFT:
        return Direction.values()[Math.floorMod(this.ordinal() - 1, length)];
      case RIGHT:
        return Direction.values()[Math.floorMod(this.ordinal() + 1, length)];
    }

    return this;
  }

}
