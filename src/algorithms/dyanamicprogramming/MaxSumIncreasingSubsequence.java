package algorithms.dyanamicprogramming;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {

    public int maxSum(int[] nums) {
        int n = nums.length;
        int[] M = new int[n];

        for (int i = 0; i < n; i++) {
            M[i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            for (int j = 0; j < i; j++) {
                if (nums[i-1] > nums[j]) {

                }
            }
        }

        System.out.println(Arrays.toString(M));
        return M[n];
    }

    private int getPrev(int i, int val, int[] nums) {
        for (int j = i-2; j >= 0; j--) {
            if (nums[j] < val) {
                return j;
            }
        }
        return 0;
    }

    private int getPrevGreater(int i, int val, int[] nums) {
        for (int j = i-2; j >= 0; j--) {
            if (nums[j] > val) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MaxSumIncreasingSubsequence max = new MaxSumIncreasingSubsequence();
        int[] nums = {1, 101, 2, 3, 100, 4, 5};
        int sum = max.maxSum(nums);
        System.out.println(sum);
    }
}
