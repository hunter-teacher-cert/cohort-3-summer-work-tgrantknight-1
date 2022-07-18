public class lessonDemo{
  public static void main (String[] args){
    int[] nums = new int[]{1,2,3,4,5};
    System.out.println(findMax(nums));
  }

  public static int findMax(int[] nums){
    int max = nums[0];
    for (int i = 0; i < nums.length; i++){
      if(max < nums[i]){
        max = nums[i];
      }
    }
    return max;
  }
}