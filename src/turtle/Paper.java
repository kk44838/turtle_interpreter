package turtle;

public class Paper {
  private final int width;
  private final int height;
  private final char[][] paper;

  public Paper(int width, int height) {
    this.width = width;
    this.height = height;
    paper = new char[width][height];

    for (int i = getHeight() - 1; i >= 0; i--) {
      for (int j = 0; j < getWidth(); j++) {
        paper[j][i] = ' ';
      }
    }
  }

  public void markPaper(int x, int y, char c) {
    if(inBounds(x, y)) {
      paper[x][y] = c;
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public boolean inBounds(int x, int y) {
    return x < getWidth() && x >= 0 && y < getHeight() && y >= 0;
  }

  public String toString() {
    StringBuilder output = new StringBuilder();

    for (int i = getHeight() - 1; i >= 0; i--) {
      for (int j = 0; j < getWidth(); j++) {
        output.append(paper[j][i]);
      }
      output.append("\n");
    }

    return output.toString();
  }
}
