package algorithms;

import java.util.*;

public class SmallestDistinctWindow {

    public int findSmallestWindow(String s) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            characterSet.add(c);
        }

        int totalCount = characterSet.size();

        Map<Character, Integer> charCounts = new HashMap<>();

        int len = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (j < s.length() - 1) {
            if (charCounts.keySet().size() < totalCount) {
                char curChar = s.charAt(j++);
                System.out.println(curChar);
                int curCount = charCounts.getOrDefault(curChar, 0);
                charCounts.put(curChar, curCount + 1);
            } else {
                int diff = j - i;
                len = Math.min(diff, len);
                i++;
                char curChar = s.charAt(i);
                System.out.println(curChar);
                int curCount = charCounts.get(curChar);
                if (curCount == 1) {
                    charCounts.remove(curChar);
                } else {
                    charCounts.put(curChar, curCount - 1);
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        SmallestDistinctWindow sdw = new SmallestDistinctWindow();
        int len = sdw.findSmallestWindow("aabcbcdbca");
        System.out.println(len);
    }
}
