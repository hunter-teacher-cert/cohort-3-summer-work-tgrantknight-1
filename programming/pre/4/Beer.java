import java.io.*;
import java.util.*;

public class Beer {
  public static void main(String[] args){
    nVerses(3);
  }

  public static void nVerses (int beers){
    System.out.println();
    if (beers > 0){
      System.out.printf("%d %s of beer on the wall,\n", beers, 
            (beers==1)?"bottle":"bottles");
      System.out.printf("%d %s of beer,\n", beers, 
            (beers==1)?"bottle":"bottles");
      System.out.printf("ya' take one down, ya' pass it around\n");
      System.out.printf("%d %s of beer on the wall,\n", beers - 1,     
            (beers - 1 ==1)?"bottle":"bottles");

      beers = beers - 1;
      nVerses(beers);

    } else {
      System.out.println("No bottles of beer on the wall,");
      System.out.println("no bottles of beer,");
      System.out.println("ya' can't take one down, ya' can't pass it around");
      System.out.println("'cause there are no more bottles of beer on the wall!");
    }
  }
}