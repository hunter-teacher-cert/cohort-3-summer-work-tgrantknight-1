import java.io.*;
import java.util.*;

// Exercises 2, 3, and 4 in Chapter 7 of Think Java
public class Loops {
  // Main method to test custom methods
  public static void main(String[] args){
    int n, result;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter an integer:");
    n = in.nextInt();
    result = factorial(n);

    System.out.printf("%d factorial is %d",n,result);
    System.out.println("");
  }

  // Exercise 2
  public static double squareRoot(double a){
    double x0, x1;
      x0 = a/2.0;
      x1 = (x0 + (a/x0))/2.0;     

    while (Math.abs(x0-x1) > 0.0001) {
      x0 = x1;
      x1 = (x0 + (a/x0))/2.0;      
    }
    return x1;
  }

  // Exercise 3
  public static double power(double x, int n){
    double result = 1.0;

    for (int i = 0; i < n; i++) {
      result = result * x;
    }

    return result;
  }

    // Exercise 4
    public static int factorial(int n){
      int result = 1;

      while (n > 0) {
        result = result * n;
        n = n - 1;
      }

      return result;
    }
}