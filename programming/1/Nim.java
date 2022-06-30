import java.io.*;
import java.util.*;

/* 
  GOAL: Be the player to remove the last stone.
  RULES:
  - bag contains 12 stones initially
  - a move consists of removing 1-3 stones from the bag
  CODE:
  - turn starts with prompting user for num of stones to remove
  - tell user how many AI removed (random 1-3)
  - continue until there is a winner
*/

public class Nim {

  public static void main(String[] args){

    System.out.println("Welcome to the game of Nim!");
    
    // Create the starting bag size of 12 stones, and turn count tracker
    int stones = 12;
    int turn = 1;
    
    // Round begins reading # of stones in the bag
    System.out.printf("There are %d stones in the bag.\n", stones);
    System.out.println();

    while(stones > 0){
      System.out.printf("Turn %d\n", turn);
      
      // Player takes their turn first
      stones = playerTurn(stones);
      System.out.printf("There are %d stones in the bag.\n", stones);
      System.out.println();

      if (stones == 0){
        System.out.println("Player wins!");
        // Add break to end the while loop before the computer plays
        break;
      }
      
      // Computer takes their turn second
      stones = computerTurn(stones);
      System.out.printf("There are %d stones in the bag.\n", stones);
      System.out.println();

      if (stones == 0){
        System.out.println("Computer wins!");
      }

      turn++;
    }

  }
  // playerTurn: Simulates the player picking 1-3 stones from the bag
  // int stones: # of stones currently in the bag
  // return: # of stones left after player turn
  public static int playerTurn(int stones){
    // Set up a scanner for user input
    Scanner input = new Scanner(System.in);
    // Create an int to store stones, initize to 0 to trigger while loop
    int stonesTaken = 0;
    
    System.out.println("Player turn");

    // While loop is to ensure that player only picks 1-3 stones
    while (stonesTaken > 3 || stonesTaken < 1){
      // Ask for the number of stones to remove -- can only remove 1-3
      System.out.println("How many stones would you like to remove? (1-3)");
      stonesTaken = input.nextInt();
      input.nextLine();
      if (stonesTaken > 3 || stonesTaken < 1) {
        System.out.println("You can only remove 1-3 stones during your turn.");
      }
    }
    // Remove the player's stones taken from the bag and return the new bag amount
    return stones - stonesTaken;
  }


  // computerTurn: Simulates the computer picking a RANDOM 1-3 stones from the bag
  // int stones: # of stones currently in the bag
  // return: # of stones left after computer turn
  public static int computerTurn(int stones){
    System.out.println("Computer turn");
    
    // Create an int for stonesTaken and initialize to 0
    int stonesTaken = 0;

    // If there are 3 or fewer stones remaining, the computer should pick that amount
    if (stones <= 3){
      stonesTaken = stones;
    } else {
      // If not, the computer picks a random number
      stonesTaken = (int) Math.random()*2 + 1;
    }

    System.out.printf("The computer took %d stones from the bag.\n", stonesTaken);
    
    // Remove the computer's stones taken from the bag and return the new bag amount
    return stones - stonesTaken;
  }


  // TODO: Add a "plural or not" type of method

  // return (stones == 1) ? "stone" : "stones";
  
}