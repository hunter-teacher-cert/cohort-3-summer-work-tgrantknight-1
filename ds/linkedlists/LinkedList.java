import java.io.*;
import java.util.*;

/**
For all attempted methods, make sensible decisions for error and
edge cases (such as indexing out of bounds).
Basic
-----
add(string value) DONE
get(int index); DONE
toString() DONE
Intermediate (at least add, size + one of the other two)
------------
size() DONE
add(int index,String value) DONE
indexOf(String value); DONE
toArray() DONE
Challenge
--------
remove(int index); DONE
*/

public class LinkedList{

  private Node head;

  public LinkedList(){
    head = null;
  }

  /**
  Parameters:
  value - the new string to add to the list
  Adds a new node containing value to the front of the list.
  */
  public void add(String value){
    head = new Node(value, head);
  }

  /**
  Returns the String in the node at location index.
  */
  public String get(int index){
    Node walker = head;
    // Loop shifts over if not yet at the index
    for (int i = 0; i < index; i++){
      if (walker == null){
        return "";
      }
      walker = walker.getNext();
    }
    return walker.getData();
  }

  /**
  Return a string representation of the list
  */
  public String toString(){
    String output = "";
    Node walker = head;
    while (walker != null){
      output += walker;
      walker = walker.getNext();
    }
    return output;
  }

  /**
  returns the number of elements in the list
  */
  public int size(){
    int count = 0;
    Node walker = head;
    while (walker != null){
      count++;
      walker = walker.getNext();
    }
    return count;
  }



  /**
  Parameters:
  index - an int with the location to add
  value - the new value
  Adds a new node with the String value to the list.
  The new node should be added at the location specified by the index.
  For example, given the list:
  "a" -> "b" -> "c" -> "d"
  add(1,"z") results in:
  "a"-> "z" -> "b" -> "c" -> "d"
  */
  public void add(int index, String value){
    // If in position 0, just call the other add method
    if (index == 0){
      add(value);
    } else {
      Node walker = head;
      // We need to start at the index right before we insert
      for (int i = 0; i < index-1; i++){
        walker = walker.getNext();
      }
  
      Node insertedNode = new Node(value);
      insertedNode.setNext(walker.getNext());
      walker.setNext(insertedNode);      
    }
  }


  /**
  Returns the index (location) of the first node in the list
  that contains value.
  Example:
  Given the list:
  "a"->"b"->"c"->"d"->"e"
  indexOf("d") would return 3 since "d" is at location 3.
  */
  public int indexOf(String value){
    Node walker = head;
    int index = 0;
    while (walker != null){
      if (walker.getData() == value){
        return index;
      }
      walker = walker.getNext();
      index++;
    }    
    return -1;
  }


  /**
  This routine should create a new array that is the same
  size as the number of Nodes in the list.
  It should then copy all of the values to the array and return
  the array.
  */
  public String[] toArray(){
    String[] arrayForm = new String[size()];
    Node walker = head;
    int index = 0;
    while (walker != null){
      arrayForm[index] = walker.getData();
      walker = walker.getNext();
      index++;
    }       
    return arrayForm;
  }



  /**
  Remove the Node at location index from the list.
  Ex:
  
  Given the list:
  "a"->"b"->"c"->"d"->"e"
  remove(2) results in:
  "a"->"b"->"d"->"e"
  */
  public void remove(int index){
    // Should just need to point b to d
    Node walker = head;
    // Assume index < size. 
    // You can add a big IF using size method
    // Move to ONE BEFORE the index to remove
    for (int i = 0; i < index-1; i++){
      walker = walker.getNext();
    }
    walker.setNext(walker.getNext().getNext());
      
  }
}