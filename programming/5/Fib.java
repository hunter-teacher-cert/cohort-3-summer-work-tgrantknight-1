/**
 * nth Fibonacci number generator by Team SumEmIfYaGotEm
 * First Last
 * collaborators: First Last, First Last
 */

// DONE
public class Fib
{
  
  //your implementation of fib(n) here
  public static int fib(int n) {
    // Three cases:
    // (1) Base case 1: n == 0 -> 0
    if (n == 0) {
      return 0;
      
    // (2) Base case 2: n == 1 -> 1
    } else if (n == 1){
      return 1;

    // (3) Recursive case: n >= 2 -> fib(n-1) + fib(n-2)      
    } else {
      return fib(n-1) + fib(n-2);
    }
  }


  public static void main( String[] args )
  {

      System.out.println( fib(0) ); // -> 0
      System.out.println( fib(1) ); // -> 1
      System.out.println( fib(2) ); // -> 1
      System.out.println( fib(3) ); // -> 2
      System.out.println( fib(4) ); // -> 3
      System.out.println( fib(5) ); // -> 5
      //now go big:
      System.out.println( fib(10) ); // -> 55
      System.out.println( fib(20) ); // -> 6765
      System.out.println( fib(40) ); // -> 102334155

  }//end main()

}//end class Fib