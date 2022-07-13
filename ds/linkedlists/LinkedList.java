import java.io.*;
import java.util.*;

/**
   For all attempted methods, make sensible decisions for error and
   edge cases (such as indexing out of bounds).
   
   Basic
   -----
   add(string value) DONE
   get(int index); DONE
   indexOf(String value);
   
   
   Intermediate (at least add, size + one of the other two)
   ------------
   add(int index,String value)
   size()
   toString()
   toArray()
   
   Challenge
   --------
   remove(int index);
   
*/

// Personal check-in:
// Nodes are simple objects, they have (1) String data and (2) Node next
// For linked lists, you start with a head Node


public class LinkedList{

  // So linked lists start with a head attribute to define them
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
    // There's no next Node, so we use the single String param constructor
    Node nextVal = new Node(value);
  }

  /**
  returns the number of elements in the lsit
  */
  public int size(){
    return 0;
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
  }

  /**
  Returns the String in the node at location index.
  */
  public String get(int index){
    // Replace currentNode as we go through the list
    Node currentNode = head;
    String currentData = currentNode.getData();
    // we'll be using .next(), which produces the String at i+1
    // So i < index should actually work
    for (int i = 0; i < index; i++){
      currentNode = currentNode.getNext();
      currentData = currentNode.getData();
    }

    return currentData;
    
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
    return 0;
  }

  /**
  This routine should create a new array that is the same
  size as the number of Nodes in the list.
  It should then copy all of the values to the array and return
  the array.
  */
  public String[] toArray(){
    return null;
  }

  /**
  Return a string representation of the list
  */
  public String toString(){
    // Use the existing toString Node method
    // Keep repeating while .getNext() != null
    String visual = head.toString();
    Node currentNode = head;

    while (currentNode != null){
      currentNode = currentNode.getNext();
      visual += currentNode.toString();
    }
    
    return visual;
  }


}