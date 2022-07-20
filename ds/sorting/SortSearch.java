import java.io.*;
import java.util.*;

/*
Sort Project:
Part 1:  (BASIC)
  1. Analyze the two constructors - try to figure out how they work. DONE
  2. Compile and run the program (SortProjectDriver.java and SortProject.java) and confirm DONE
  the behavior of the constructors.
  Part 2: (BASIC)
  1. Read the description of findSmallestIndex and complete the method. DONE
  2. Uncomment the lines in SortProjectDriver to test. DONE
  Part 3: (INTERMEDIATE)
  1. Complete the sort method - read comments for description DONE
  2. Uncomment the lines in sortProjectDriver to test. DONE
Search Project:
  1. Complete the linear search (BASIC) DONE
  2. Complete the binary search (Intermediate) DONE
  3. Complete the recursive version of binary search (Advanced)
*/

public class SortSearch{

    /* Sort project starts here */
    
    /* Instance Variables */
    private ArrayList<Integer> data;  // to store the data
    
    private Random r; 

    
    public SortSearch(){
      data = new ArrayList<Integer>();
      r = new Random();
      for (int i=0;i<15;i++){
          data.add(r.nextInt(20));
      }
	
    }
    
    public SortSearch(int size){
    	data = new ArrayList<Integer>();
    	r = new Random();
    	for (int i=0;i<size;i++){
    	    data.add(r.nextInt(20));
    	}
	
    }

    /* Convenience function to get data out of the ArrayList from the driver */
    public int get(int index){
    	return this.data.get(index);
    }
    


    /*
      return the index of the smallest data idem from index start to the end
      of the ArrayList. If there are multiple of the smallest value,
      return any of them.
      
      Example, if the arraylist has:
      5,3,10,6,8
      if start was 2 (start at index 2, value 10) then it would return 3
      which is the index of the value 6 which is the index with the
      smallest value from start to end
      On the otherh and, if start was 0, then the method would
      return 1 since the value 3 is in index 1 and that is the smallest.
      
    */
    public int findSmallestIndex(int start){
    	int smallIndex = start;

      for (int i = start; i < data.size(); i++){
        if (data.get(smallIndex) > data.get(i)){
          smallIndex = i;
        }
      }
      
    	return smallIndex;
    }


    /**
       Implement the selection sort algorithm by sorting the ArrayList
       data in place.
       Algorithm:
       Loop a variable that represents the ArrayList index from
       0 to the end of the ArrayList.
         For each index, find the smallest from that Location
	 to the end of the array and swap it with that index.
	 
       
    */
    public void sort(){
      // One loop through:
      // Find smallest index
      // Swap to position i (starts at 0)
      for (int i = 0; i < data.size(); i++){
        int smallIndex = findSmallestIndex(i);
        int temp;
        
        temp = data.get(i);
        data.set(i,data.get(smallIndex));
        data.set(smallIndex,temp);
      }

    }



    /* Search project starts here */
    
    /**
       performs a linear search. Returns the index of the first occurence of
       value in the ArrayList data or -1 if not found.
       This works by starting at the first element and searching one element at a time 
       until either the element is found or you've looked at all the elements.
       This algorithm works on any ArrayList.
    */
    public int linearSearch(int value){
	    // Begin at -1 for the not found case
      int target = -1;

      for (int i = 0; i < data.size(); i++){
        if (data.get(i) == value){
          target = i;
        }
      }
	
    	return target; // replace this return
    }
    
    /**
       Implement a binary search as specified by the comments
       
       This algorithm only works on sorted ArrayLists.
    */
    public int binarySearch(int value){
	// create assign variables  representing the high, low and middle indices 
      int lowIndex = 0;
      int highIndex = data.size()-1;
      int midIndex = data.size()/2;
      
	// while we're not done:
	//   if the item is at data.get(middle), return middle
	//   otherwise, update high, low, and middle

      while ((lowIndex <= midIndex) && (midIndex <= highIndex)) {
        int midValue = data.get(midIndex);
        // Middle case
        if (midValue == value){
          return midIndex;
        // Upper case
        } else if (midValue < value){
          lowIndex = midIndex + 1;
          midIndex = (lowIndex + highIndex)/2;
        // Lower case
        } else {
          highIndex = midIndex - 1;
          midIndex = (highIndex + midIndex)/2;
        }
      }

      // Only gets here if value not found
    	return -1;
	    
    }
    
    /**
       Implement a RECURSIVE binary search as specified by the comments
       
       This algorithm only works on sorted ArrayLists.
    */

    public int binarySearchRecursive(int value, int lowIndex, int highIndex){
      // Assume precon sorted, could continuously sort but that is a waste.
      int midIndex = (highIndex + lowIndex)/2;

      // Base case 1: midIndex < lowIndex || highIndex > midIndex
      if (midIndex < lowIndex || highIndex < midIndex){
        return -1;
      // Base case 2: midValue == value -> return midIndex
      } if (data.get(midIndex) == value){
        return midIndex;
      // Recursive case 1: value in upper bucket
      } else if (data.get(midIndex) < value){
        return binarySearchRecursive(value, midIndex + 1, highIndex);
      // Recursive case 2: value in lower bucket
      } else {
        return binarySearchRecursive(value, lowIndex, midIndex - 1);
      }

    }
    
	
    public String toString(){
    	return ""+data;
    };


    public void builtinSort(){
    	Collections.sort(data);
	
    }
    

    // NEW testing method
    // Return the size of data
    public int getSize(){
      return data.size();
    }
}