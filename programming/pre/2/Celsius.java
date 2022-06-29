import java.io.*;
import java.util.*;

public class Celsius {
  public static void main(String[] args){
    double celsius, fahrenheit;
    Scanner input = new Scanner(System.in);

    System.out.println("Enter Celsius value to convert:");
    celsius = input.nextDouble();
    input.nextLine();
    
    fahrenheit = celsius * (9.0/5.0) + 32;

    System.out.printf("%.1f C = %.1f F\n", celsius, fahrenheit);
  }
}