package algorithms;

import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

    public String[] summaryRanges(int[] nums) {
        int len = nums.length;
        String[] ranges;
        if (len % 2 == 0) {
            ranges = new String[len / 2];
        } else {
            ranges = new String[(len / 2) + 1];
        }

        int  i = 0;
        int j = 0;
        while (i < len) {
            int curInt = nums[i];
            if (i+1 == len) {
                ranges[j] = String.valueOf(curInt);
                return ranges;
            }

            int nextInt = nums[i+1];
            String range = String.valueOf(curInt) + ">" + String.valueOf(nextInt);
            ranges[j++] = range;
            i += 2;
        }

        return ranges;
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        int[] nums = {1, 2, 3, 5, 6};
        String[] r = sr.summaryRanges(nums);
        System.out.println(Arrays.toString(r));
    }
}
