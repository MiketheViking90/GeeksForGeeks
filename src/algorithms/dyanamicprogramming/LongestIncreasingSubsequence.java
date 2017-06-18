package algorithms.dyanamicprogramming;

public class LongestIncreasingSubsequence {

    public int LIS(int[] nums) {
        int len = nums.length;
        int[] M = new int[len+1];

        for (int i = 1; i <= len; i++) {
            int num = nums[i-1];
            int prevIndex = prev(i, nums);

            System.out.println(prevIndex + ": " + nums[prevIndex]);
            int include = M[prevIndex + 1] + 1;
            int uninclude = M[i-1];
            M[i] = Math.max(include, uninclude);

            if (include > uninclude) {
                System.out.println("\tinclude: " + nums[i-1]);
            }
        }
        return M[len];
    }

    private int prev(int i, int[] nums) {
        int val = nums[i-1];
        for (int j = i-2; j >= 0; j--) {
            if (nums[j] < val) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        int[] nums2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int len = lis.LIS(nums);
        System.out.println(len);
    }
}
