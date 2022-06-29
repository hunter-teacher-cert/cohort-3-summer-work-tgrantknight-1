import java.io.*;
import java.util.*;

public class Craps {

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int numRounds;
    int winCount = 0;

    System.out.println("How many rounds of Craps do you want to play?");
    numRounds = in.nextInt();

    for (int i = 0; i < numRounds; i++) {
      boolean win = round();
        if(win){
          System.out.println("You win!\n");
          winCount++;
        } else {
          System.out.println("You lose!\n");
        }
    }

    System.out.printf("You won %d out of %d rounds!", winCount,numRounds);
    System.out.println();
  }  

  public static int roll(int diceSize){
    Random random = new Random();
    int result = random.nextInt(diceSize) + 1;
    return result;
  }

  public static int shoot(int amt, int diceSize){
    int sum = 0;
    for (int i = 0; i < amt; i++){
      sum = sum + roll(diceSize);
    }
    return sum;
  }

  public static boolean round(){ 
    int diceRoll = shoot(2,6);
    System.out.printf("The first roll of the round is %d", diceRoll);
    System.out.println();
    int point = 0;
    if (diceRoll == 2 || diceRoll == 3 || diceRoll == 12){
      return false;
    } else if (diceRoll == 7 || diceRoll == 11) {
      return true;
    } else {
      point = diceRoll;
    }
    System.out.printf("The Point is set to %d",point);
    System.out.println();

    int pointCount = 1;
    do {
      diceRoll = shoot(2,6);
      System.out.printf("Shoot for Point %d is a %d", pointCount,diceRoll);
      System.out.println();
      pointCount++;
    } while (diceRoll != 7 && diceRoll != point);

    if (diceRoll == 7){
      return false;
    } else if (diceRoll == point) {
      return true;
    } else {
      System.out.println("Uh oh... returning false but error");
      return false;
    }
  }
}