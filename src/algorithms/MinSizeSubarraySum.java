package algorithms;

public class MinSizeSubarraySum {

    int measure(int[] nums, int target) {
        int i = 0;
        int j = 1;
        int len = nums.length;

        int minLength = len;
        while (j < len) {
            int curSum = nums[i];
            for (int k = i+1; k<=j; k++) {
                curSum += nums[k];
            }

            if (curSum >= target) {
                int curLength = (j - i);

                if (curLength < minLength) {
                    minLength = curLength;
                }
                i++;
            } else {
                j++;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 7, 1, 0, 3, 1};
        int target = 10;

        MinSizeSubarraySum ms = new MinSizeSubarraySum();
        int len = ms.measure(nums, target);
        System.out.println(len);
    }
}
