import java.io.*;
import java.util.*;

public class SortSearchDriver {
    public static void main(String[] args) {
    
    
    	// Uncomment these to test part 1
    	
    	SortSearch ss = new SortSearch(10);
    	// System.out.println(ss);
    	
    		
    	// Uncomment these to test part 2
      /*
    	int i;
    	i = ss.findSmallestIndex(0);
    	System.out.println("ss["+ i +"] = "+ss.get(i)+" : " + ss);
    
    	i = ss.findSmallestIndex(3);
    	System.out.println("ss["+ i + "] = "+ss.get(i)+" : " + ss);
    	*/
    	// Uncomment these to test part 3
    
    	ss.sort();
    	System.out.println(ss);


      // Full check if it works for every random num 0-19:
      for (int i = 0; i < 20; i++){
        System.out.println("Linear Search:");
        System.out.println(i + " is at position: " + ss.linearSearch(i));
        System.out.println("Binary Search:");
        System.out.println(i + " is at position: " + ss.binarySearch(i));  
        System.out.println("Binary Search Recursive:");
        System.out.println(i + " is at position: " + ss.binarySearchRecursive(i,0,ss.getSize()-1)); 
        System.out.println("");
      }


    
    	      
    
    }
}