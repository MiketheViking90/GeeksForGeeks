package algorithms;

public class MaxRepeatingNumber {

    int getMaxRepeatingNumber(int[] nums) {
        int maxRepeating = 0;
        int curMax = 0;
        boolean hasRepeated = false;

        for (int n : nums) {
            curMax = Math.max(n, curMax);
            if (!hasRepeated) {
                hasRepeated = true;
            } else {
                maxRepeating = Math.max(curMax, maxRepeating);
                hasRepeated = false;
            }
        }
        return maxRepeating;
    }

    int getMaxByIndexing(int[] nums, int k) {
        for (int n : nums) {
            int i = (n%k);
            nums[i] += k;
        }

        int maxVal = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        MaxRepeatingNumber mpn = new MaxRepeatingNumber();
        int[] nums = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
        int max = mpn.getMaxRepeatingNumber(nums);
        int maxI = mpn.getMaxByIndexing(nums, 9);

        System.out.println(maxI);
    }
}
