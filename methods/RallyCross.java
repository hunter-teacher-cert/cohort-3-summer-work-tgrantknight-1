public class RallyCross {

  public static void main (String[] args){
   
    int[] x = new int[] {0,1,2,3};
    //barGraphify(x);
    vBarGraphify(x);
    System.out.println("");
    int[] y = new int[] {1,0,3,2};
    //barGraphify(y);
    vBarGraphify(y);
    
  }

  // `barGraphify(int[] nums)` takes an array of non-negative 
  // integers and prints a horizontal bar for each index, 
  // commensurate with the value at said index.
  public static void barGraphify(int[] nums){

    for(int i = 0; i < nums.length; i++)
    {
      System.out.print(i + ": ");
      for(int count = 0; count < nums[i]; count++)
      {
        System.out.print("=");//on a given index it will print an equal sign for the value of the element
      }

      System.out.println("");
    }
  }


  // vBarGraphify(int[] nums) takes an array of non-negative integers and prints a set of vertical bars visualizing the magnitude of the value at each index.
  public static void vBarGraphify(int[] nums){

    int max = 0;

    for(int i = 0; i < nums.length; i++)
    {
      if (nums[i] > max)
      {
        max = nums[i];
      }

    }
    String output = "";

    //Make the starting row of numbers:
    // Need to print backwards
    for(int i = nums.length-1; i >= 0; i--)
    {
        output = i + " " + output;
    }

    for(int height = 1; height < max +1; height++)
    {
      // add a new row before
      output = "\n" + output;
      // Need to print backwards
      for(int i = nums.length-1; i >= 0; i--)
      {
        if (nums[i] >= height){
          output = "* " + output;
        } else {
          output = "  " + output;
        }
      }
    }
    
    System.out.println(output);
    // Different print lines
    // Computers print top to bottom, left to right

    /*
    if x=[3,1,2,3] then barGraphify(x) will output
      *  * 
      * ** 
      **** 
      0123 

      There are i spaces (either "*" or " ") before index i

      How to print backwards:
      String output starts empty = ""
      Then print out the 0123:
          output = TOP STUFF + "\n" + output;

      If backwards, check

      End we print(output);
    */
    
  }
  
  
}