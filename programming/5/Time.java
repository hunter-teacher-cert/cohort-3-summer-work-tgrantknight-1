import java.io.*;
import java.util.*;


/**
 * Time class by Team LucidThinkeren
 * First Last
 * collaborators: First Last, First Last
 */

/**
   INSTRUCTIONS:
   This file contains the starter code for our Time class.
   The class here uses ints for hours, minutes, and seconds but you
   could decide to change the internal representation to just store
   an int representing a number of seconds.
   Place this file in a folder named programming/5/Time.java
   Basic level (complete all):
   - public Time(int hrs, int mins, int secs) - constructor DONE
   - public void toString() DONE
   - public void set(int hrs, int mins, int secs) DONE
   Intermediate level (complete Basic methods plus this method):
   - public void add(Time other) DONE
   - public boolean isEquals(Time other)
   
   Advanced level (complete Basic + Intermediate + these two methods):
   - public int compareTo(Time other)
   
*/



public class Time {
    // Instance Variable(s)
    // You can change this if you want to use the alternate
    // implementation of just storing the overall seconds.
    
    int hours;
    int minutes;
    int seconds;

    // Constructors
    public Time(){
    	this.hours = 0;
    	this.minutes = 0;
    	this.seconds = 0;
	
    }

    /**
       Parameters:
       - hrs, mins, secs - the time you want to create the class as
       Initialize this instance to represent hrs:mins:secs as the time.
       
     */
    public Time(int hrs, int mins, int secs){

	// your code here
	    hours = hrs;
      minutes = mins;
      seconds = secs;
    }
    
    
    // Methods

    /**
       returns a string representation of the time
    */
    public String toString(){
      // I'm using hh:mm:ss
	    return(hours+":"+minutes+":"+seconds);
    }


    

    /**
       Parameters:
       - hrs,mins,secs - ints representing a time
       modifies this instance to represent the time hrs:mins:secs
    */
    public void set(int hrs, int mins, int secs){
	// add the code to add the time represented by other
	// to this instance.
      hours = hrs;
      minutes = mins;
      seconds = secs;
    }

    

    /**
       Parameters:
       - other - a variable of type Time
       modifies this instance to represent the result of adding it and
       the time other.
    */
  // Assume 24 hour clock
    public void add(Time other){
	// add the code to add the time represented by other
	// to this instance.

      // first, add each set of values together to make the new hours, etc.
      hours = hours + other.hours;
      minutes = minutes + other.minutes;
      seconds = seconds + other.seconds;

      // then, we need to check seconds overflow to add to min
      int newMinutes = seconds/60; // integer division will get whole number
      seconds = seconds % 60; // mod 60 will get left over seconds
      minutes = minutes + newMinutes;
      
      // once seconds are done, repeat for minutes (order matters)
      int newHours = minutes/60;
      minutes = minutes % 60;
      hours = hours + newHours;

      // finally, check to make sure you haven't reached a new day yet
      // We don't actually care to track that 1 extra day passed
      hours = hours % 24;
      
    }


    /**
       Parameters:
       other - a variable of type Time
       Returns:
       True if this instance and other represents the same time
       false otherwise.
    */
    public boolean equals(Time other){
      // Assume both times are 24 hours and that they are written correctly
      // i.e., seconds, minutes are 0 to 59, hours are 0 to 23

      if (
        hours == other.hours &&
        minutes == other.minutes &&
        seconds == other.seconds
      ) {
        return true;
      } else {
        return false;
      }

    }

    /**
       Parameters:
       other - a variable of type Time
       Returns:
       A positive number if this instance represents a time greater
       than the time of other (this > other)
       A negative number if this instance represents a time less
       than the time of other (this < other)
       0 if the two instances represent the same time.
    */
    public int compareTo(Time other){
      // Assume proper 24 hour notation in proper form for both times

      // Check hours first, then minutes, then seconds
      if (hours > other.hours){
        return 1; // this is greater than other, so return positive int
      } 
      

	    return 0; // change this
    }
    

    
}//end class