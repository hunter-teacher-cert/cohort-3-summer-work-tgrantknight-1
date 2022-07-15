import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[] args) {
    Node n1 = new Node("5");
    Node n3 = new Node("25");

    System.out.println("n1 data: " + n1.getData());
    System.out.println("n3 data: " + n3.getData());

    n1 = n3;
    n3.setData("17");
    System.out.println("n1 data: " + n1.getData());
    System.out.println("n3 data: " + n3.getData());
    n1.setData("30");
    System.out.println("n1 data: " + n1.getData());
    System.out.println("n3 data: " + n3.getData());    
    
  }
}