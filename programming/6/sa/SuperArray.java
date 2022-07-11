/**
 * SuperArray by Team MarvelvsDC
 * First Last
 * collaborators: First Last, First Last
 */

/**
   SKELETON
   SuperArray is a wrapper class for an array.
   Provides "pass-thru" accessibility to pre-existing array capabilities:
   - get/set by index
   - get length
   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
*/

import java.io.*;
import java.util.*;

public class SuperArray
{
  /**
     SUBGOAL:
     declare instance vars
     ...and initialize?
  */


  //instance vars
  private int[] data;           // "interior"/"underlying" data container
  private int numberElements;   // number of "meaningful" elements


  // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
  //overloaded constructor -- allows specification of initial capacity
  public SuperArray( int size )
  {
    //init underlying/inner storage of specified capacity
    /* YOUR SIMPLE+SMART CODE HERE */
    data = new int[size];
    //init instance vars
    /* YOUR SIMPLE+SMART CODE HERE */
    numberElements = 0;
  }

  //default constructor -- initializes capacity to 10
  public SuperArray()
  {
    //init underlying/inner storage of capacity 10
        /* YOUR SIMPLE+SMART CODE HERE */
    data = new int[10];
    //init instance vars
        /* YOUR SIMPLE+SMART CODE HERE */
    numberElements = 0;
  }


  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  public void add( int value )
  {
    // test to see if we need to grow, then grow
    if (numberElements == data.length){
      grow();
    }
    /**
       IMPORTANT:
       This is the first code that should run in this method
       but the last code you should write.
       Implement the rest of this method first,
       then only write this section once the rest is tested and working.
    */
    /* YOUR SIMPLE+SMART CODE HERE */

    // add item
    /* YOUR SIMPLE+SMART CODE HERE */
    data[numberElements] = value;


    // increment numberElements
    /* YOUR SIMPLE+SMART CODE HERE */
    numberElements++;

  }//end add()


  public boolean isEmpty()
  {
    //return whether this SuperArray instance is empty
    /* YOUR SIMPLE+SMART CODE HERE */
    return numberElements == 0;
  }


  public int get(int index)
  {
    //return item at index
    /* YOUR SIMPLE+SMART CODE HERE */
    return data[index];
  }


  public String toString()
  {
    //return stringified version of this Object
    /* YOUR SIMPLE+SMART CODE HERE */
    String dataString = "";
    for (int i = 0; i < numberElements; i++){
      dataString = dataString + data[i] + " ";
    }
    return dataString;
  }//end toString()


  //return Stringified version of this Object,
  // with extra debugging info
  //(helper method for debugging/development phase)
  public String debug()
  {
    String s = "";
    s = "Size: " + this.data.length;
    s = s + " LastItem: " + numberElements + "  Data: ";
    for (int i = 0; i < numberElements; i++) {
      s = s + data[i] + ", ";
    }
    s = s + "\n";
    return s;
  }//end debug()


  public void remove(int index)
  {
    // shift items down to remove the item at index
    /* YOUR SIMPLE+SMART CODE HERE */

    // has to be minus 1, since the for loop uses i+1
    for (int i = index; i < numberElements-1; i++){
      data[i] = data[i+1];
    }
    // subtract fom numElements;
    /* YOUR SIMPLE+SMART CODE HERE */
    numberElements--;
  }


  public void add(int index, int value) //sa.add(5, 100);
  { //maybe somewhere here
    
    // see if there's enough room
    /* YOUR SIMPLE+SMART CODE HERE */
    if (!(numberElements < data.length)){
      grow();
    }

    // shift elements toward the end of the array
    /* YOUR SIMPLE+SMART CODE HERE */
    for (int i = data.length-1; i > index; i--){
      data[i] = data[i-1];
    }
    
    // insert new element
    /* YOUR SIMPLE+SMART CODE HERE */
    data[index] = value;

    // increment numElements
    numberElements++;
    /* YOUR SIMPLE+SMART CODE HERE */
  

  }


  private void grow()
  {
    // create a new array with extra space
    // Q: How did you decide how much to increase capacity by?
    /* YOUR SIMPLE+SMART CODE HERE */
    int[] dataNew = new int[data.length + 1];

    // copy over all the elements from the old array to the new one
    /* YOUR SIMPLE+SMART CODE HERE */
    for (int i = 0; i < data.length; i++){
      dataNew[i] = data[i];
    }

    // point data to the new array
    // Q: How does this look when illustrated using encapsulation diagram?
    /* YOUR SIMPLE+SMART CODE HERE */
    data = dataNew;
    
  }//end grow()

}//end class