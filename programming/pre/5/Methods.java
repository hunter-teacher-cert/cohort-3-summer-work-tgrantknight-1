import java.io.*;
import java.util.*;

// Exercises 2, 3, and 8 in Chapter 6 of Think Java
public class Methods {
  // Main method to test custom methods
  public static void main(String[] args){
    int x, y, z;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter value for m:");
    x = in.nextInt();
    System.out.println("Enter value for n:");
    y = in.nextInt();

    System.out.println(ack(x,y));
  }

  // Exercise 2
  public static boolean isDivisible(int n, int m){
    if ((n % m) == 0){
      return true;
    } else {
      return false;
    }
  }

  // Exercise 3
  public static boolean isTriangle(int a, int b, int c){
    if ((c > a + b) || (b > a + c) || (a > b + c)){
      return false;
    } else {
      return true;
    }
  }

  // Exercise 8
  public static int ack(int m, int n){
    if (m == 0){
      return n+1;
    } else if (m > 0 && n == 0){
      return ack(m-1,1);
    } else if (m > 0 && n > 0){
      return ack(m-1,ack(m,n-1));
    } else {
      System.out.println("Please enter two non-negative integers");
      // Not sure of a better way to catch the error at this point
      return -1;
    }
  }
}