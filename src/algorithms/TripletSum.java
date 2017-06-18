package algorithms;

import java.util.HashSet;
import java.util.Set;

public class TripletSum {

    int countTriplets(int[] nums, int X) {
        int n = nums.length;
        int cnt = 0;

        Set<Integer> remainders = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num1 = nums[i];
            if (remainders.contains(num1)) {
                cnt++;
            }
            for (int j = i+1; j < n; j++) {
                int num2 = nums[j];

                remainders.add(X - (num1 + num2));
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7, 2, 3, -2};
        int k = 6;

        TripletSum ts= new TripletSum();
        int cnt = ts.countTriplets(nums, k);
        System.out.println(cnt);
    }
}
