import java.io.*;
import java.util.*;

public class SortSearchDriver {
    public static void main(String[] args) {
    
    	int size = 1000;
    	SortSearch ss = new SortSearch(size);
    
    	// ss.sort();
    	// System.out.println(ss);

      long start,elapsed,end;

    	start = System.currentTimeMillis();
    	ss.sort();
      System.out.println(start);
    
    	// System.out.println(ss);
      end = System.currentTimeMillis();
      System.out.println(end);
    	elapsed = end - start;
      System.out.println(elapsed);
    	System.out.println("Size: " + size + " Time: " + elapsed);
      
      // Full check if it works for every random num 0-19:
      /*
      for (int i = 0; i < 20; i++){
        System.out.println("Linear Search:");
        System.out.println(i + " is at position: " + ss.linearSearch(i));
        System.out.println("Binary Search:");
        System.out.println(i + " is at position: " + ss.binarySearch(i));  
        System.out.println("Binary Search Recursive:");
        System.out.println(i + " is at position: " + ss.binarySearchRecursive(i,0,ss.getSize()-1)); 
        System.out.println("");
}
        */
      
    }
}