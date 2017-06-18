package algorithms;

public class MaxProductSubarray {

    int getProduct(int[] nums) {
        int product = 1;
        int negCount = 0;
        int maxNeg = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n < 0) {
                product *= n;
                negCount++;
                maxNeg = Math.max(maxNeg, n);
            } else if (n > 0) {
                product *= n;
            }
        }

        if (negCount % 2 != 0) {
            product /= maxNeg;
        }
        return product;
    }

    public static void main(String[] args) {
        MaxProductSubarray mps = new MaxProductSubarray();
        int[] nums = {8, -2, -2, 0, 8, 0, -6, -8, -6, -1};
        int prod = mps.getProduct(nums);
        System.out.println(prod);
    }
}
