public class LeetCode26 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int x = removeDuplicates(nums);
        System.out.println(x);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean isDuplicate = false;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    isDuplicate = true;
                    break;//found duplicate
                }
            }
            if (!isDuplicate) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}

