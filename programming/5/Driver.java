import java.io.*;
import java.util.*;


/**
 * Time class by Team LucidThinkeren
 * First Last
 * collaborators: First Last, First Last
 */

/**
   INSTRUCTIONS:
   This file contains the Driver starter code for our Time class.
   
   Add code in main to test all your methods
   
   Place this file in a folder named programming/5/Driver.java
*/


public class Driver {

    public static void main(String[] args) {

    	//declare a var of appropriate type to assign an instance of Time to
    	Time t,t2;
    
    	//assign var the address of a newly-apportioned Time object
    	t = new Time(2,15,30);
      t2 = new Time(2,15,30);

      // Testing the toString method
      System.out.println(t.toString());
      System.out.println(t2.toString());
      System.out.println(t.equals(t2));

      // t.set(3,20,40);
      // System.out.println(t.toString());

      // t.add(t2);
      // System.out.println(t.toString());      
      
    }//end main()

}//end class