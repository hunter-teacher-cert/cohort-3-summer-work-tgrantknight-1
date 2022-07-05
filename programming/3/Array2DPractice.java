import java.io.*;
import java.util.*;

/**
 * Array2DPractice by Team LucidThinkeren
 * Taylor Grant-Knight
 * collaborators: Alicia Wade, Jing Xie
 */

/**
   INSTRUCTIONS:
   Place this file in a folder named programming/3/.
   This file contains the following completed method. Use it as a model
   to help you with the other methods:
   - buildBoard
   This file also contains stubs (empty methods) for the following
   methods (split into 3 levels):
   Basic level (complete all):
   - printBoard * DONE
   - copyBoard * DONE
   Intermediate level (complete Basic methods plus this method):
   - explodeSquare * DONE
   Advanced level (complete Basic + Intermediate + these two methods):
   - explodeAllChar * TODO
   - downString DONE
   The routines with the * will be particularly helpful for the
   Conway's Game of Life project that you'll work on after this one.
*/


/**
   creates and returns a 2D array of size rowsxcols chars. All elements
   in the 2D array will be set to the char value.
   Ex: buildBoard(3,4,'x') will return this 2D array:
   xxxx
   xxxx
   xxxx
   Use this completed method as an example to help you with some of the
   other methods.
*/

public class Array2DPractice
{
  public static char[][] buildBoard( int rows, int cols, char value )
  {
    char[][] board = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j]=value;
      }
    }
    return board;
  }

  /**
     pretty prints a 2D array of characters
     This should print the array as a grid
  */
  public static void printBoard( char[][] board )
  {
    /* YOUR AWESOME CODE HERE */
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

  /**
     Parameters:
     board - a 2D array of char
     row - the row you want to set
     value - the value to set all the elements in row
     Returns:
     Nothing
     Change the 2D array board so that all the elements in the
     specified row are set to value.
     Ex: Given array:
     xxxx
     xxxx
     xxxx
     xxxx
     setRow(board,2,'@') will change board to
     xxxx
     xxxx
     @@@@
     xxxx
  */
  public static void setRow( char[][] board, int row, char value )
  {
    /* YOUR AWESOME CODE HERE */
    // To be extra, you can check if the row number is valid
    
    
    // Need the number of columns to loop through
    int cols = board[0].length;

    // Loop through just that specific row (using j for consistency)
    for (int j = 0; j < cols; j++){
      // Replace each element in that row with the new value
      board[row][j] = value;
    }
  }


  /**
     creates and returns a new 2D array of char the same size as
     original and copies all the elements
  */
  public static char[][] copyBoard( char[][] original )
  {
    /* YOUR AWESOME CODE HERE */
    // You will need the rows and cols of the original array
    int rows = original.length;
    int cols = original[0].length;
    
    // To copy the board, you need to first make a new board
    // of the same size.
    char[][] newBoard = new char[rows][cols];

    // Then, do a standard double for loop and assign each element
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        newBoard[i][j] = original[i][j];
      }
    }
    
    return newBoard;
  }


  /**
     Parameters:
     board - a 2D array of char
     row,col - ints specifying a location in board
     Returns:
     nothing
     A location in a 2D array can be though of as having 6
     neighbors.  In the below 2D array, the neighbors of the element
     marked Q are the numbered elements.
     oooooo
     o123oo
     o4Q5oo
     o678oo
     oooooo
     This method should change all the neighbor cells (elements) to an X
     but not change the element at row,col
     Ex:
     Given the 2D array
     QQQQQ
     QQQQQ
     QQQQQ
     QQQQQ
     explodeSquare(board,1,1) will change the array to
     XXXQQ
     XQXQQ
     XXXQQ
     QQQQQ
     Note: Make sure to correctly handle the cases when you try
     to explode an element on the edges.
  */
  public static void explodeSquare( char[][] board, int row, int col )
  {
    /* YOUR AWESOME CODE HERE */
    // Start by getting the rows and cols ints
    int rows = board.length;
    int cols = board[0].length;

    // To avoid errors, we want to use if statements
    // with ranges instead of checking for row-1, etc.

    // Standard loop through each element:
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        // Using ifs, check if the cell is in the area
        // and not the square itself
        if ((row-1 <= i && i <= row+1) &&
            (col-1 <= j && j <= col+1) &&
            (!(i == row && j == col)))
        {
            board[i][j] = 'X';
        }
      }
    }
    
  }

  /**
     This method will search through the 2D array board and it will
     explode each square that contains the char c (using the above
     definition of exploding).
     Example:

     Given the array

     qqzqq
     qqqqq
     qqqqq
     qqqqq
     qzqqq
     qqqqq
     qqqqz

     ...
     explodeAllchar(board,'z')
     will change board to

     qXzXq
     qXXXq
     qqqqq
     XXXqq
     XzXqq
     XXXXX
     qqqXz

  */
  public static void explodeAllChar(char[][] board, char c)
  {
    /* YOUR AWESOME CODE HERE */
    // To be extra, could check to make sure c is not X,
    // the explosion indicator

    // ISSUE 1: Version 1 of this method, I did not make a copy
    // An issue can occur when you explode and cover a goal character
    // To fix, you need to make a copy of your board first and use that
    char[][] boardCopy = copyBoard(board);

    // ISSUE 2: In Version 2 of this method, chars that get boomed are lost
    // I feel like the intention is to be able to see the remaining chars
    // at the end, so I will store the locations 
    int[] charXList = new int[1000];
    int[] charYList = new int[1000];
    int charCount = 0;
    
    // Set the rows and cols
    int rows = board.length;
    int cols = board[0].length;

    // Standard loop through every element:
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        // If the element is our target, make it boom.
        // Use boardCopy instead of board to make sure every char booms.
        if (boardCopy[i][j] == c){
          explodeSquare(board,i,j);

          // Store the character location to add back in at the end.
          charXList[charCount] = i;
          charYList[charCount] = j;
          charCount++;
        }
      }
    }

    // When you're done, add in all the chars that could have been boomed.
    for (int i = 0; i < charCount; i++){
      board[charXList[i]][charYList[i]] = c;
    }
    
  }


  /**
     Parameters:
     board - a 2D array of char
     row,col - ints specifying a location in board
     word - a String that you want to insert into the board.
     This will insert the parameter word into board in the downward
     direction. See examples below
     Example:
     Given this array
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     downString(board,1,1,"Hello") will change board to:
     xxxxxx
     xHxxxx
     xExxxx
     xLxxxx
     xLxxxx
     xOxxxx
     xxxxxx
     Given the above array, downString(board,4,3,"World") will
     change board to:
     xxxxxx
     xHxxxx
     xExxxx
     xLxxxx
     xLxWxx
     xOxOxx
     xxxRxx
     Note that the method has to stop at the bottom of the array.
  */
  public static void downString( char[][] board, int row, int col, String word )
  {
    /* YOUR AWESOME CODE HERE */

    // Could check to make sure the given row and col
    // are actually in the array

    // Declare an ending point, which is the min of
    // either the word length or the # of rows left
    int end = Math.min(board.length - row,word.length());
    
    // Loop through rows starting at given row and
    // using "end" as the end point
    for (int i = 0; i < end; i++){
      // Use .charAt(index) to use specific character
      board[row + i][col] = word.charAt(i);
    }
  }


  public static void main( String[] args )
  {
    char[][] b = buildBoard(5,10,'z');
    /*
      Note, you can directly set elements in the board
      using array notation like b[3][2]='z' and you
      can use array notation to also access individual
      elements
    */
    
    // printBoard(b);
    // System.out.println("");
    // printBoard(copyBoard(b));
    // System.out.println("");
    // setRow(b, 2, '@');
    // printBoard(b);
    System.out.println("");
    explodeSquare(b, 2, 1);
    printBoard(b);

    // char[][] b2 = copyBoard(b);
    //b2[1][2] = 'a';
    //b2[2][3] = 'a';
    //b2[2][2] = 'a';
    //b2[4][4] = 'a';
   // printBoard(b2);
    //System.out.println("");
    //explodeAllChar(b2,'a');
    //printBoard(b2);

    char[][] b3 = buildBoard(10,5,'z');
    // printBoard(b3);
    // System.out.println("");
    // downString(b3,7,1,"Hello");
    // printBoard(b3);
  }
}