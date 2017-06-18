package algorithms.dyanamicprogramming;

public class LongestCommonSubsequence {

    public int getLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] M = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            char char1 = str1.charAt(i-1);

            for (int j=1; j<=n; j++) {
                char char2 = str2.charAt(j-1);

                if (char1 == char2) {
                    M[i][j] = M[i-1][j-1] + 1;
                    System.out.println(char1 + "," + M[i][j]);
                } else {
                    M[i][j] = Math.max(M[i-1][j], M[i][j-1]);
                }
            }
        }

        return M[m][n];
    }

    public int findLongest(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] M = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            int char1 = str1.charAt(i-1);

            for (int j = 1; j <= n; j++) {
                int char2 = str2.charAt(j-1);

                if (char1 == char2) {
                    M[i][j] = M[i-1][j-1] + 1;
                } else {
                    int left = M[i-1][j];
                    int down = M[i][j-1];

                    M[i][j] = Math.max(left, down);
                }
            }
        }
        return M[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
//        int l = lcs.getLength("afjiejfibjidfjijc", "aaibc");
        int l = lcs.findLongest("afjiejfibjidfjijc", "aaibc");
        System.out.println(l);
    }
}
