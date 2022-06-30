// Test of example of reversing a string from class

public class Day1 {

  public static void main(String[] args){

    String aString = "Heels";
    String aSentence = "Today is nice!";
    
    // reverse(aString);
    // toUpper(aString);
    secondWord(aSentence);
    
  }

  public static void reverse(String aString){

    for (int i = aString.length() - 1; 
         i >= 0; 
         i--)
    {
      System.out.print(aString.charAt(i));
    }

    System.out.println();
    
  }

  public static void toUpper(String aString){
    System.out.println(aString);

    String upperString = "";
    
    for (int i = 0; i < aString.length() - 1; i++){
      // get ASCII code of character
      int asciiCode = (int) aString.charAt(i);
      char newChar;

      // check if lower (between 97-122)
      if (asciiCode >= 97 && asciiCode <= 122){
        // if so, convert to upper by sub 32
        asciiCode = asciiCode - 32;
        newChar = (char) asciiCode;
        
      } else {
        // if not, keep it the same
        newChar = (char) asciiCode;
      }

      // concatenate all the strings together 
      upperString = upperString + newChar;
    }

    System.out.println(upperString);
  }

  public static void secondWord(String aSentence){

    int index = 0;
    
    // Look for the first space
    // Need to keep track of letter beyond just for loop
    while(aSentence.charAt(index) != ' '){
      index++;
    }

    // Once here in code, this is the space, so you need to jump to the next
    index++;
    
    // once you find the space, start printing characters
    // once you hit the next space, stop printing characters
    while(aSentence.charAt(index) != ' '){
      // no "ln" because we want once complete word
      System.out.print(aSentence.charAt(index));
      index++;
    }

    // If you're here, you hit the second space, so we're done.
    // Add new line for formatting in shell.
    System.out.println();
    
  }
  
}