package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinct {

    int getLength(String str) {
        Map<Character, Integer> charToCountMap = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (charToCountMap.containsKey(c)) {
                int cnt = charToCountMap.get(c);
                charToCountMap.put(c, cnt+1);
            } else {
                charToCountMap.put(c, 1);
            }

            if (charToCountMap.size() > 2) {
                maxLen = Math.max(maxLen, i - start);

                while (charToCountMap.size() > 2) {
                    char d = str.charAt(start);

                    if (charToCountMap.get(d) > 2) {
                        int cnt = charToCountMap.get(d);
                        charToCountMap.put(d, cnt-1);
                    } else {
                        charToCountMap.remove(d);
                    }
                    start++;
                }
            }
        }
        return maxLen;
    }
}
