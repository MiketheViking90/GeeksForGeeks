package algorithms;

import java.util.Arrays;

public class TrappingRainWater {

    public int amountWater(int[] heights) {
        int n = heights.length;

        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];

        leftHeight[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftHeight[i] = Math.max(leftHeight[i-1], heights[i]);
        }

        rightHeight[n-1] = heights[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightHeight[i] = Math.max(rightHeight[i+1], heights[i]);
        }

        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(leftHeight));
        System.out.println(Arrays.toString(rightHeight));

        int vol = 0;
        for (int i = 0; i < n; i++) {
            int curVol = Math.min(leftHeight[i], rightHeight[i]) - heights[i];
            vol += curVol;
        }
        return vol;
    }

    public static void main(String[] args) {
        int[] heights = {3, 0, 0, 2, 0, 4};

        TrappingRainWater trw = new TrappingRainWater();
        int vol = trw.amountWater(heights);

        System.out.println(vol);
    }
}
