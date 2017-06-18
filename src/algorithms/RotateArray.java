package algorithms;

import java.util.Arrays;

public class RotateArray {

    int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RotateArray ra = new RotateArray();
        int[] rotated = ra.rotate(nums, 3);

        System.out.println(Arrays.toString(rotated));
    }
}
