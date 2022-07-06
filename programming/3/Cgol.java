import java.io.*;
import java.util.*;

/**
 * Conway's Game of Life by Team AreWeSentientYet?
 * First Last
 * collaborators: First Last, First Last
 */

/**
   The Rules of Life:
   Survivals:
   * A living cell with 2 or 3 living neighbours will survive for the next generation.
   Deaths:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Births:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation.
*/

public class Cgol
{

  //create, initialize, and return  empty board (all cells dead)
  public static char[][] createNewBoard( int rows, int cols )
  {
    // Assume dead cells are " "
    // Taken directly from Array2DPractice.java 
    char[][] board = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j]='-';
      }
    }
    return board;
  }


  //print the board to the terminal
  public static void printBoard( char[][] board )
  {
    // Directly from Array2DPractice.java
    
    // Need to colect the value for rows and cols
    int rows = board.length;
    int cols = board[0].length;

    // Should use the double traversal from buildBoard
    // Start with a loop through the columns, meaning cap at rows
    for (int i = 0; i < rows; i++){
      // Then loop through each row for the given column
      for (int j = 0; j < cols; j++){
        // Now print each value with a space after
        System.out.print(board[i][j] + " ");
      }
      // Add a new line after each row.
      System.out.println("");    
    }
  }


  //set cell (r,c) to val
  public static void setCell( char[][] board, int r, int c, char val )
  {
    board[r][c] = val;
  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours( char[][] board, int r, int c )
  {
    // Copied directly from Array2DPractice.java, with modifications
    
    // Start by getting the rows and cols ints
    int rows = board.length;
    int cols = board[0].length;

    // Need a variable to count neighbors
    int neighborCount = 0;

    // To avoid errors, we want to use if statements
    // with ranges instead of checking for r-1, etc.

    // Standard loop through each element:
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        // Using ifs, check if the cell is in the area
        // and not the square itself
        if ((r-1 <= i && i <= r+1) &&
            (c-1 <= j && j <= c+1) &&
            (!(i == r && j == c)))
        {
          // Change from 2DArrayPractice: Instead of setting to X, count Xs
          if(board[i][j] == 'X'){
            neighborCount++;
          }
        }
      }
    }
    
    return neighborCount;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead '-') <-- Changed to '-'
  */
  public static char getNextGenCell( char[][] board,int r, int c )
  {
    // '-' for dead cell makes this more readible

    // Going light on comments here because replit just refreshed w/o saving
    char cell = board[r][c];
    int neighbours = countNeighbours(board,r,c);
    // Set default for newCell as a space to error check
    char newCell = ' ';

    // starts alive
    if (cell == 'X'){
      if (neighbours == 2 || neighbours == 3){
        newCell = 'X';
      } else {
        newCell = '-';
      }

    // otherwise starts dead
    } else {
      if (neighbours == 3) {
        newCell = 'X';
      } else {
        newCell = '-';
      }
    }

    return newCell;
  }


  //generate and return a new board representing next generation
  public static char[][] generateNextBoard( char[][] board )
  {
    return board;
  }


  public static void main( String[] args )
  {
    
    char[][] board;
    board = createNewBoard(25,25);
    printBoard(board);
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');
    System.out.println("");
    printBoard(board);
    System.out.println(countNeighbours(board,0,0));
    System.out.println(getNextGenCell(board,0,0));
    System.out.println(getNextGenCell(board,0,2));
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class