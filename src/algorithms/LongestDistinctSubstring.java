package algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinctSubstring {

    public int getLongest(String s) {
        char[] chars = s.toCharArray();

        Set<Character> distinct = new HashSet<>();
        int curRange = 0;
        int maxRange = 0;
        for (char c : chars) {
            if (!distinct.contains(c)) {
                distinct.add(c);
                curRange++;

                if (curRange > maxRange) {
                    maxRange = curRange;
                }
            } else {
                distinct.clear();
                curRange = 0;
            }
        }
        return maxRange;
    }

    public static void main(String[] args) {
        LongestDistinctSubstring ld = new LongestDistinctSubstring();
        String str = "geeksforgeeks";
        int len = ld.getLongest(str);
        System.out.println(len);
    }
}
