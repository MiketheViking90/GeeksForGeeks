package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairGreatestProductInArray {

    public boolean findGreatest(int[] nums) {
        Set<Integer> hashedNums = new HashSet<>();
        for (int n : nums) {
            hashedNums.add(n);
        }

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int product = nums[i];

            for (int j = 0; nums[j] < Math.sqrt(product); j++) {
                if (hashedNums.contains(product/nums[j])) {
                    System.out.println(nums[j] + "*" + (product/nums[j]) + "=" + product);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4, 6, 21, 28};
        PairGreatestProductInArray pg = new PairGreatestProductInArray();
        pg.findGreatest(nums);
    }
}
