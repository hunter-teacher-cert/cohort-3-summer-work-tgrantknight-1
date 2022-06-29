import java.io.*;
import java.util.*;

public class Guess {
  public static void main(String[] args){
    int guess, actual, offBy;
    
    Scanner in = new Scanner(System.in);
    Random random = new Random();

    actual = random.nextInt(100) + 1;

    System.out.println("I'm thinking of a number between 1 and 100");
    System.out.println("(including both). Can you guess what it is?");

    System.out.print("Type a guess: ");
    guess = in.nextInt();
    offBy = guess - actual;

    System.out.println("Your guess is: " + guess);
    System.out.println("The number I was thinking of is: " + actual);
    System.out.println("You were off by: " + offBy);
  }
}