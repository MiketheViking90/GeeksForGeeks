package algorithms;

public class MaxDiff {

    public int getDiff(int[] nums) {
        int maxDiff = nums[0];
        int maxIndex = 0;
        int minDiff = nums[0];
        int minIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int diff = val - i;

            if (diff > maxDiff) {
                maxDiff = diff;
                maxIndex = i;
            }
            if (diff < minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }
        System.out.println("i: " + maxIndex + " j: " + minIndex);
        return maxDiff - minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, -1};
        MaxDiff md = new MaxDiff();
        int diff = md.getDiff(nums);
        System.out.println(diff);
    }
}
