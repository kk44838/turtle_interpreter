package turtle;

import turtle.util.Direction;
import turtle.util.Pen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

      int length = args.length;
      TurtleInterpreter t;
      switch (length) {
        case 0:
          t = new TurtleInterpreter(new Scanner(System.in), System.out);
          break;
        case 1:
          t = new TurtleInterpreter(new Scanner(new File(args[0])), System.out);
          break;
        case 2:
          t = new TurtleInterpreter(new Scanner(new File(args[0])), new PrintStream(new File(args[1])));
          break;
        default:
          throw new IllegalArgumentException("Too many Arguments Provided.");
      }

      t.interpret();
    }
}
