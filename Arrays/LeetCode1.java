public class LeetCode1 {
    //Input: nums = [2,7,11,15], target = 9
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] newArray=twoSum(nums,target);
        for(int x: newArray){
            System.out.println(x);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] newArray=new int[2];
       for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<nums.length;j++){
               if(nums[i]+nums[j]==target){
                   System.out.println("FOUND!"+i+" and "+j);
                   newArray[0]=i;
                   newArray[1]=j;
               }
           }
       }
       return newArray;
    }
}
