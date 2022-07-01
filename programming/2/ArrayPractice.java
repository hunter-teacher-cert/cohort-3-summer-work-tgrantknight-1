/**
 * ArrayPractice by Team BossCoders
 * First Last
 * collaborators: First Last, First Last
 */

/**
   INSTRUCTIONS:
   This file contains stubs (empty methods) for the following methods:
   1. buildIncreasingArray - DONE
   2. buildRandomArray - DONE
   3. printArray - DONE
   4. arraySum - DONE
   5. firstOccurence - DONE
   6. isSorted - DONE
   7. findMaxValue - DONE
   8. countOdds - DONE
   9. flip - DONE
   The stubs will have comments describing what they should do
   Levels:
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Basic:
   Complete these methods:
   - buildRandomArray
   - printArray
   - arraySum
   - firstOccurence
   - findMaxValue
   Intermediate:
   Complete all the methods for basic and also
   - buildIncreasingArray
   - isSorted
   - countOdds
   Advanced:
   Complete all the methods
*/

import java.util.*;
import java.io.*;

public class ArrayPractice
{

  /**
     Parameters:
     size - how large the array should be
     startValue - the value of the first element
     step - the interval to the next value
     Returns:
     a new array of integers
     Examples:
     buildIncreasingArray(5,3,2) will return an array
     with the values 3,5,7,9,11 (five values, starting with 3 with a step size of 2)
  */
  public static int[] buildIncreasingArray( int size, int startValue, int step )
  {
    int[] data = new int[size];

    // loop through each element of the array and
    for (int i = 0; i < size; i++){
      // assign the appropriate value to each one.
      data[i] = startValue;
      startValue = startValue + step;
    }

    return data;
  }


  /**
     Parameters:
     size - how many elements in the array
     maxValue - the largest possible random value to use
     Returns:
     a new array where each element is an integer between 0
     and up to but not including maxValue
  */
  public static int[] buildRandomArray( int size, int maxValue )
  {
    Random r = new Random();
    int[] data = new int[size];

    /* YOUR BRILLIANT CODE HERE */
    for (int i = 0; i < size; i++){
      data[i] = r.nextInt(maxValue);
    }
    
    return data;
  }


  /**
     Parameters:
     data - an array of ints
     Returns:
     nothing
     prints out the array
     Note: data.length stores the length of the array
  */
  public static void printArray( int[] data )
  {
    /* YOUR BRILLIANT CODE HERE */
    for (int i = 0; i < data.length; i++){
      System.out.print(data[i] + " ");
    }
    
    System.out.println();
  }



  /**
     Parameters:
     data - an array of integers
     value - the value to search for
     Returns:
     the index (location) of the first occurence of value
     Example:
     given array data, containing 1,5,2,7,5,8,5,12,19,5
     firstOccurence(data,5) would return 1
     since the first occurence of the value 5 is at a[1]
  */
  public static int firstOccurence( int[] data, int value )
  {
    
    /* YOUR BRILLIANT CODE HERE */
    for (int i = 0; i < data.length; i++){
      if (data[i] == value){
        // Not sure how to do this without returning out of the loop
        return i;
      }
    }
    // Standard notation: return the array size if not found
    return data.length; 
  }


  /**
     Parameters: data - an array of ints
     Returns: an integer that is equal to the sum of all the elements in the array
     Ex: If the input array has the values 5,2,4,10 the return
     value will be 21 (5+2+4+10)
  */
  public static int arraySum( int[] data )
  {
    /* YOUR BRILLIANT CODE HERE */
    int sum = 0;

    for (var i = 0; i < data.length; i++){
      // Trying new notation, using x += y instead of x = x + y
      sum += data[i];
    }

    return sum;
  }


  /**
     Parameters:
     data - an array of integers
     Returns:
     true if the array is sorted, false otherwise
     That is, if each element is < the element to its right
     then the array is sorted.
     An array with values 5,6,10,15 is sorted
     An array with values 5,6,10,13,15 is not
  */
  public static boolean isSorted( int[] data )
  {
    // Note: using data.length-1 to prevent checking beyond bounds
    for (int i = 0; i < data.length-1; i++){
      // if ANY pair of values are NOT in order, return false
      if (data[i] > data[i+1]){
        return false;
      }
    }

    return true;

  }

  /**
     Parameters:
     data - an array of integers
     Returns:
     value of the largest element in the array
  */
  public static int findMaxValue( int[] data ) {
    // Initialize the max with the first value
    int m = data[0];

    // Could start at i = 1 to save one comparison
    for (int i = 0; i < data.length; i++){
      if (data[i] > m){
        m = data[i];
      }
    }

    return m;
  }


  /**
     Parameters:
     data - an array of integers
     Returns:
     the number of odd elements in the array
     Ex: if data holds 5,6,7,8,9,10 then the return value
     will be 3 since three of the elements are odd.
  */
  public static int countOdds( int[] data ) {
    int count=0;

    /* YOUR BRILLIANT CODE HERE */
    for (int i = 0; i < data.length; i++){
      if (data[i] % 2 == 1){
        count++;
      }
    }
    
    // Note the % operator is the modulo (basically remainder) function
    // in java. Use to determine if an integer is odd.

    return count;
  }

  /**
     Parameters:
     data - an array of integers
     Returns:
     no return value since this is a void function -- but
     you will manipulate the values in the array parameter
     Postcondition:
     elements of the input array are in reverse order
     Example:
     If the input array contains 5,8,13,7,27,2
     After the routine, the array will contain 2,27,7,13,8,5
  */
  public static void flip( int[] data )
  {
    // Create a copy of the data array
    int[] dataCopy = new int[data.length];
    for (int i = 0; i < data.length; i++){
      dataCopy[i] = data[i];
    }

    // j will represent the ending index and will decrease each loop
    int j = data.length-1;
    // Traverse the array and use the copy as the source of values
    for (int i = 0; i < data.length; i++){
      data[i] = dataCopy[j];
      j--;
    }
    
  }


  public static void main( String[] args )
  {

    // int[] data = buildRandomArray(10, 20);
    // printArray(data);
    
    // int[] data2 = buildIncreasingArray(10,5,3);
    // printArray(data2);

    // int[] data3 = new int[]{1,5,2,7,5,8,5,12,19,5};
    // System.out.println(firstOccurence(data3, 5));

    // int[] data4 = new int[]{1,5,2};
    // System.out.println(arraySum(data4));

    // int[] data5 = new int[]{1,5,2,4,5};
    // int[] data6 = new int[]{1,5,6,9,10};
    // System.out.println("Should be false: " + isSorted(data5));
    // System.out.println("Should be true: " + isSorted(data6));

    // int[] data7 = new int[]{1,5,10,4,5};
    // System.out.println(findMaxValue(data7));

    // int[] data8 = new int[]{1,5,4,7,6};
    // System.out.println(countOdds(data8));

    int[] data9 = new int[]{1,2,3,4,5};
    flip(data9);
    printArray(data9);
    
  }
}