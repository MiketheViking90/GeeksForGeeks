package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    boolean wordBreak(Set<String> dictionary, String word) {
        int n = word.length();

        if (n == 0) {
            return false;
        }

        if (dictionary.contains(word)) {
            System.out.println(word);
            return true;
        }

        for (int i = 1; i < n-1; i++) {
            String left = word.substring(0, i);
            String right = word.substring(i, n);

            if (dictionary.contains(left) && dictionary.contains(right)) {
                System.out.println(left);
                System.out.println(right);

                return true;
            } else {
                boolean recur = wordBreak(dictionary, left) && wordBreak(dictionary, right);
                if (recur) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "like", "sam", "sung"};
        String word = "ilikesamsung";

        WordBreak wb = new WordBreak();
        wb.wordBreak(new HashSet<>(Arrays.asList(words)), word);
    }
}
