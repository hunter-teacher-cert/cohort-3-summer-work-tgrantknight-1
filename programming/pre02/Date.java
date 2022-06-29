import java.io.*;
import java.util.*;

public class Date {
  public static void main(String[] args){
    String day, month;
    int date, year;

    day = "Sunday";
    month = "January";
    date = 23;
    year = 2022;

    System.out.println("American Format:");
    System.out.println(day + ", " + month + " " + date + ", " + year);
    System.out.println("European Format:");
    System.out.println(day + " " + date + " " + month + " " + year);
  }
}