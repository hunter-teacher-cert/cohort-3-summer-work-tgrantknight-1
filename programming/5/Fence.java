/**
 * Recursion Practice with Strings by Team SweatEquity
 * First Last
 * collaborators: First Last, First Last
 */

// DONE
public class Fence
{

  /**
     String fenceR(int) -- recursive fence generator
     precond:  input is a positive integer
     postcond: returns fence with n posts
     eg
     fenceR(1) -> "|"
     fenceR(2) -> "|--|"
  */
  public static String fenceR( int n )
  {
    /* YOUR SIMPLE, SMART IMPLEMENTATION HERE */

    // Three cases:
    // (1) Base case 1: n == 0 -> ""
    if (n == 0){
      return "";
      
    // (2) Base case 2: n == 1 -> "|"      
    } else if (n == 1){
      return "|";

    // (3) Recursive case: n >= 2 -> fenceR(n-1) + "--|"
    } else {
      return fenceR(n-1) + "--|";
    }
  }


  public static void main( String[] args )
  {

    for( int i = 0; i < 10; i++ ) {
      System.out.println( i + "-post fences: " );
      System.out.println( fenceR(i) );
    }

    /* feel free to add extra tests... */

  }
}