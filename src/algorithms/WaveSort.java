package algorithms;

import java.util.Arrays;

public class WaveSort {

    void waveSort(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 1) {
            int tmp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tmp;

            i+=2;
        }
    }

    void waveSortLinear(int[] nums) {
        int n = nums.length;

        int i = 0;
        while (i < n-1) {
            if (nums[i] < nums[i+1]) {
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            }
            i+=2;
        }
    }
    public static void main(String[] args) {
        WaveSort ws = new WaveSort();
        int[] nums = {3, 1, 4, 1, 5, 9, 2};
        ws.waveSortLinear(nums);
        System.out.println(Arrays.toString(nums));
    }
}
