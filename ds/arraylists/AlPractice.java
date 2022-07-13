import java.io.*;
import java.util.*;

/** Methods to write
Basic level:
------------
public static ArrayList<Integer> buildRandomList(int size, int maxval) DONE
public static int sumOfList(ArrayList<Integer> dataList) DONE
Intermediate level:
-------------------
public static void swapElements(ArrayList<Integer> dataList, int indexA,int indexB) DONE
public static void removeValue(ArrayList<Integer> dataList, int valueToRemove) DONE
Challenge level:
-------------------
public static ArrayList<Integer> sumLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB) DONE
public static ArrayList<Integer> zipLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB)
*/


public class AlPractice{

  /**
  Parameters:
  - size - an integer representing how many items to add to the list
  - maxval - the largest value to store in the list
  Preconditions:
  - size >= 0
  - maxVal > 0
  Returns:
  - A new ArrayList of Integers with each value being a random
    number between 0 and maxval (not including maxval).
  */
  public static ArrayList<Integer> buildRandomList(int size, int maxval){
    // Need to create an Integer ArrayList
    // Need to use Math.random() * maxVal for each entry

    ArrayList<Integer> randomList = new ArrayList<Integer>(size);

    for (int i = 0; i < size; i++){
      randomList.add((int)(Math.random()*maxval));
    }
    
    return randomList;//placeholder to compile.
  }

  /**
  Parameters:
  - dataList - an ArrayList of integer values.
  Returns:
  - The sum of all of the elements of the ArrayList.
  */
  public static int sumOfList(ArrayList<Integer> dataList){
    int sum = 0;

    for (int i = 0; i < dataList.size(); i++) {
      sum += dataList.get(i);
    }
    
    return sum;//placeholder to compile.
  }

  /**
  Parameters:
  - dataList - an ArrayList of Integers
  - index1, index2 - the two locations to swap.
  Preconditions:
  - index1 and index2 are valid indecies of dataList
  Postconditions:
  - The ArrayList is modified such that
    The value that was in dataList[index1] is now in dataList[index2], and
    the value  that was in dataList[index2] is now in dataList[index1].
  - No other values should be modified.
  */
  public static void swapElements(ArrayList<Integer> dataList, int index1,int index2){
  
    int temp = dataList.get(index1);
    dataList.set(index1, dataList.get(index2));
    dataList.set(index2, temp);
    
  }

  /**
  Parameters:
  - dataList - an AraryList of Integers
  - valueToRemove - the value to remove
  Postconditions:
  - The dataList is modified such that all occurances of valueToRemove are removed.
  */
  public static void removeValue(ArrayList<Integer> dataList, int valueToRemove){

    for (int i = 0; i < dataList.size(); i++){
      if (dataList.get(i) == valueToRemove){
        dataList.remove(i);
        // Need to move i back one step to account for removing the element 
        // to check for values in a row
        i--;
      }
    }
    
  }


  /**
  Parameters:
  - ListA,ListB - ArrayLists of integer values.
  Preconditions:
  - ListA and ListB have equal lengths.
  Returns:
  - A new ArrayList that contains the sum of the corresponding indecies of the two arraylists.
    e.g. sumLists( [1,2,3], [4,0,5]) would return: [5,2,8]
  Postconditions:
  - The parameter ArrayLists should not be modified.
  */
  public static ArrayList<Integer> sumLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB){
    // Same length, just loop through
    // Use the get and add methods
    ArrayList<Integer> sumList = new ArrayList<Integer>(ListA.size());

    for (int i = 0; i < ListA.size(); i++){
      sumList.add(ListA.get(i) + ListB.get(i));
    }

    return sumList;//placeholder to compile.
  }

  /** zipLists
  Parameters:
  - ListA,ListB - ArrayLists of integer values.
  Returns:
  - A new ArrayList that contains all of the elements from both ArrayLists in alternating order starting with ListA's first element.
    When one list has no more values to add, continue adding the remaining values of the longer list.
    e.g. zipLists( [1,2,3,4], [8,9]) would return: [1,8,2,9,3,4]
  Postconditions:
  - The parameter ArrayLists should not be modified.
  */
  public static ArrayList<Integer> zipLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB){
    // Determine which list is smaller using min
    int minSize = Math.min(ListA.size(),ListB.size());
    // New combinedList has size of the sum of both lists
    ArrayList<Integer> combinedList = 
      new ArrayList<Integer>(ListA.size() + ListB.size());

    // Use alternating style, could use the evens for ListA, odds for ListB
    // Use minSize * 2 since we're alternating
    for (int i = 0; i < minSize * 2; i++){
      if (i % 2 == 0){
        combinedList.add(ListA.get(i/2)); // i/2 uses floor
      } else{
        combinedList.add(ListB.get(i/2));
      }
    }

    // Now check if either list has remaining elements:
    if (ListA.size() > minSize) {
      for (int i = minSize; i < ListA.size(); i++){
        combinedList.add(ListA.get(i));
      }
    } else {
      // Even if both are the same, this for loop would just never run
      for (int i = minSize; i < ListB.size(); i++){
        combinedList.add(ListB.get(i));
      }
    }
    
    return combinedList;//placeholder to compile.
  }




  public static void main(String[] args) {

    ArrayList<Integer> al;

    /*
    // Uncomment these to test buildRandomList
    al = buildRandomList(10,100);
    System.out.println(al);
    System.out.println(sumOfList(al));    

    // Uncomment these to test swapElements
    swapElements(al,2,6);
    System.out.println(al);

    // Uncomment these to test removeValue
    al.add(5);
    al.add(10);
    al.add(5);
    al.add(13);
    al.set(2,5);
    al.set(3,5);
    System.out.println(al);
    removeValue(al,5);
    System.out.println(al);
    */

    ArrayList<Integer> al2 = buildRandomList(5,20);
    ArrayList<Integer> al3 = buildRandomList(7,20);
    System.out.println(al2);
    System.out.println(al3);
    // System.out.println(sumLists(al2,al3));
    System.out.println(zipLists(al2,al3));

  }

}