package algorithms;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSubsequence {

    public int getLongest(int[] nums) {
        Set<Integer> orderedNums = new TreeSet<>();
        for (int n : nums) {
            orderedNums.add(n);
        }

        int maxLen = 1;
        int curLen = 1;

        Iterator<Integer> it = orderedNums.iterator();
        int prevNum = it.next();

        while (it.hasNext()) {
            int n = it.next();
            if (n == (prevNum+1)) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 0;
            }

            prevNum = n;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();

        int[] nums1 = {2, 6, 1, 9, 4, 5, 3};
        int[] nums2 = {1, 9, 3, 10, 4, 20, 2};

        System.out.println(lcs.getLongest(nums1));
        System.out.println(lcs.getLongest(nums2));
    }
}
