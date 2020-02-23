package turtle;

import turtle.implementations.*;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TurtleInterpreter {
  private Scanner input;
  private PrintStream output;
  private final Map<String, Turtle> turtles = new HashMap();

  private Paper paper = new Paper(10, 10);

  // Pre: input is correctly typed
  public TurtleInterpreter(Scanner input, PrintStream output) {
    this.input = input;
    this.output = output;
  }

  public void interpret() {
    while (input.hasNext()) {
      switch (input.next()) {
        case "paper":
          this.paper = new Paper(input.nextInt(), input.nextInt());
          break;
        case "new":
          String type = input.next();
          makeTurtle(type);
          break;
        case "pen":
          penInput();
          break;
        case "move":
          moveInput();
          break;
        case "right":
          rightInput();
          break;
        case "left":
          leftInput();
          break;
        case "show":
          assert paper != null;
          output.println(paper.toString());
          break;
      }
    }
  }

  private void penInput() {
    Turtle turtlePen = getTurtle();
    String state = input.next();

    if (state.equals("up")) {
      turtlePen.penUp();
    } else if (state.equals("down")) {
      turtlePen.penDown();
    } else {
      turtlePen.changeBrush(state.charAt(0));
    }
  }

  private void moveInput() {
    getTurtle().moveAndMark(input.nextInt());
  }

  private void rightInput() {
    getTurtle().rotateTurtle(Rotation.RIGHT, input.nextInt() / 45);
  }

  private void leftInput() {
    getTurtle().rotateTurtle(Rotation.LEFT, input.nextInt() / 45);
  }

  private Turtle getTurtle() {
    String turtleName = input.next();
    int containsDot = turtleName.indexOf('.');

    do {
      turtleName = turtleName.substring(containsDot + 1);
      containsDot = turtleName.indexOf('.');
    } while (containsDot >= 0);

    return turtles.get(turtleName);
  }

  private Turtle makeTurtle(String type) {
    String name = input.next();
    int arg1 = input.nextInt();
    int y;

    switch (type) {
      case "normal":
        y = input.nextInt();
        NormalTurtle normalTurtle = new NormalTurtle(arg1, y, Direction.NORTH, Pen.UP, '*', paper);
        turtles.put(name, normalTurtle);
        return normalTurtle;

      case "bouncy":
        y = input.nextInt();
        BouncyTurtle bouncyTurtle = new BouncyTurtle(arg1, y, Direction.NORTH, Pen.UP, '*', paper);
        turtles.put(name, bouncyTurtle);
        return bouncyTurtle;

      case "continuous":
        y = input.nextInt();
        ContinuousTurtle continuousTurtle =
            new ContinuousTurtle(arg1, y, Direction.NORTH, Pen.UP, '*', paper);
        turtles.put(name, continuousTurtle);
        return continuousTurtle;

      case "reflecting":
        y = input.nextInt();
        ReflectingTurtle reflectingTurtle =
            new ReflectingTurtle(arg1, y, Direction.NORTH, Pen.UP, '*', paper);
        turtles.put(name, reflectingTurtle);
        return reflectingTurtle;

      case "wrapping":
        y = input.nextInt();
        WrappingTurtle wrappingTurtle =
            new WrappingTurtle(arg1, y, Direction.NORTH, Pen.UP, '*', paper);
        turtles.put(name, wrappingTurtle);
        return wrappingTurtle;

      case "cluster":
        Turtle[] cluster = new Turtle[arg1];

        for (int i = 0; i < arg1; i++) {
          input.next();
          cluster[i] = makeTurtle(input.next());
        }

        ClusterTurtle clusterTurtle = new ClusterTurtle(cluster);
        turtles.put(name, clusterTurtle);
        return clusterTurtle;
    }

    return null;
  }
}
