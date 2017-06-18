package algorithms;

import java.util.Arrays;

public class PythagoreanTriplet {

    public boolean checkExistence(int[] nums) {
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            if (hasTriple(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTriple(int[] nums, int k) {
        int i = 0;
        int j = k-1;

        while (i < j) {
            int compare = comparePythagorean(nums[i], nums[j], nums[k]);
            if (compare == -1) {
                i++;
            } else if (compare == 1) {
                j--;
            } else {
                System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
                return true;
            }
        }
        return false;
    }

    private int comparePythagorean(int a, int b, int c) {
        int sum = (a*a) + (b*b);
        int res = (c*c);

        if (sum < res) {
            return -1;
        } else if (sum > res) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 2, 5, 40, 41, 9};
        PythagoreanTriplet pt = new PythagoreanTriplet();
        pt.checkExistence(nums);
    }
}
