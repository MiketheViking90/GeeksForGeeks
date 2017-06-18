package algorithms;

import java.util.Arrays;

public class ReverseWords {

    public void reverse(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n/2; i++) {
            String tmp = words[i];
            words[i] = words[n - i - 1];
            words[n - i - 1] = tmp;
        }

        System.out.println(Arrays.toString(words));
    }

    public void reverseWords(String sentence) {
        int n = sentence.length();
        char[] charArray = sentence.toCharArray();
        int start = 0;

        for (int i = 0; i < n; i++) {
            if (charArray[i] == ' ') {
                reverse(charArray, start, i);
                start = i + 1;
            }
        }
        System.out.println(String.valueOf(charArray));
        reverse(charArray, 0, n);
        System.out.println(String.valueOf(charArray));
    }

    private void reverse(char[] charArray, int i, int j) {
        System.out.println(i + ", " + j + charArray[i] + ", " + charArray[j-1]);
        int mid = (j - i) / 2;
        for (int k = 0; k < mid; k++) {
            char tmp = charArray[i + k];
            charArray[i + k] = charArray[j - k - 1];
            charArray[j - k - 1] = tmp;
        }
        System.out.println("\t" + charArray[i] + ", " + charArray[j-1]);
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String str = "I want to join Two Sigma ";
        rw.reverse(str);

        rw.reverseWords(str);
    }
}
