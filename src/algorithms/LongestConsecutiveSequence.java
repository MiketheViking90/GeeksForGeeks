package algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    int getLongestConsecutiveSequence(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            numSet.add(n);
        }

        int maxLen = 1;

        for (int n : nums) {
            int left = n-1;
            int right = n+1;
            int curLen = 1;

            while (numSet.contains(left)) {
                left--;
                curLen++;
            }

            while (numSet.contains(right)) {
                right++;
                curLen++;
            }

            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }
}
