package turtle;

import turtle.implementations.ClusterTurtle;

public class Cluster {
  private final String clusterName;
  private final int initialSize;
  private int sizeRemaining;
  private Turtle[] turtles;

  public Cluster(String clusterName, int initialSize) {
    this.clusterName = clusterName;
    this.initialSize = initialSize;
    this.sizeRemaining = initialSize;
    turtles = new Turtle[initialSize];
  }

  public void decrementSizeRemaining() {
    sizeRemaining--;
  }

  public int getSizeRemaining() {
    return sizeRemaining;
  }


  public void addTurtle(Turtle newTurtle) {
    turtles[initialSize - sizeRemaining] = newTurtle;
  }

  public Turtle[] getTurtles() {
    return turtles;
  }

  public String getClusterName() {
    return clusterName;
  }
}
