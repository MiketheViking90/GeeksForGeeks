package algorithms.dyanamicprogramming;

public class LongestPalindromeSubstring {

    int getLongestPalindrome(String str) {
        int n = str.length();

        boolean[][] M = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            M[i][i] = true;
        }
        int maxLen = 1;

        char[] chars = str.toCharArray();
        for (int i = 0; i < n-1; i++) {
            if (chars[i] == chars[i+1]) {
                M[i][i+1] = true;
                maxLen = 2;
            }
        }

        for (int len = 3; len < n; len++) {
            System.out.println("len: " + len);
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                System.out.println(chars[i] + ", " + chars[j]);
                if (M[i+1][j-1] && chars[i] == chars[j]) {
                    System.out.println(str.substring(i, j + 1));
                    M[i][j] = true;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring lp = new LongestPalindromeSubstring();
        int len = lp.getLongestPalindrome("aaabba");
        System.out.println(len);
    }

}
