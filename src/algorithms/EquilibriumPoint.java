package algorithms;

public class EquilibriumPoint {

    public int findPoint(int[] nums) {
        int rSum = getSum(nums);
        int lSum = 0;

        for (int n : nums) {
            rSum -= n;
            lSum += n;

            if (rSum == lSum) {
                return rSum;
            }
        }
        return -1;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, -1};
        EquilibriumPoint ep = new EquilibriumPoint();
        int i = ep.findPoint(nums);
        System.out.println(i);
    }
}
