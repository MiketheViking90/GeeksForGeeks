package algorithms;

public class KadaneAlgorithm {

    public int maxSum(int[] nums) {

        int curMax = 0;
        int max = 0;

        for (int i : nums) {
            curMax += i;
            System.out.println(i + ", " + curMax);
            if (curMax > max) {
                max = curMax;
            }
            if (curMax < 0) {
                curMax = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        KadaneAlgorithm ka = new KadaneAlgorithm();
        int[] nums = {5, -2, -6, 4, -3, 7};
        int sum = ka.maxSum(nums);
        System.out.println(sum);
    }
}
