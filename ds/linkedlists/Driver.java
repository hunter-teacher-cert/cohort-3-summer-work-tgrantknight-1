import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[] args) {
    LinkedList l = new LinkedList();
    l.add("One");
    l.add("Two");
    l.add("Three");
    /*
    System.out.println(l);
    System.out.println("Index 1: " + l.get(1));
    System.out.println("Size: " + l.size());
    */
    l.add(1, "Four");
    /*
    System.out.println(l);
    System.out.println("Size: " + l.size());
    */
    l.add(0, "Five");
    /*
    System.out.println(l);
    System.out.println("Size: " + l.size());
    System.out.println("Four is at index: " + l.indexOf("Four"));
    */
    /*
    String[] arrayForm = l.toArray();
    for (int i = 0; i < arrayForm.length; i++){
      System.out.println(i + ": " + arrayForm[i]);
    }
    */
    System.out.println(l);
    l.remove(2);
    System.out.println(l);
    System.out.println("Size: " + l.size());

  }
}