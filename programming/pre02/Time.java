import java.io.*;
import java.util.*;

public class Time {
  public static void main(String[] args){
    int hour, minute, second;
    int sec_from_mid, sec_left;
    double timePassedPer;

    hour = 15;
    minute = 12;
    second = 55;

    sec_from_mid = 60 * (60 * hour + minute) + 55;
    sec_left = 24*60*60 - sec_from_mid;

    System.out.println("Seconds since midnight:");
    System.out.println(sec_from_mid);

    System.out.println("Seconds remaining in the day:");
    System.out.println(sec_left);  

    timePassedPer = (sec_from_mid*100)/(24*60*60);

    System.out.println("Percentage of day passed:");
    System.out.println(timePassedPer);      

    // Temporary variables to store previous time
    int h, m, s;

    h = hour;
    m = minute;
    s = second;

    hour = 15;
    minute = 22;
    second = 22;

    System.out.println("Seconds spent on exercise:");
    System.out.println(60*(60*(hour-h)+(minute-m))+(second-s));     
  }
}