package algorithms.dyanamicprogramming;

public class StringEditDistance {

    public int getEditDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] M = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            char char1 = str1.charAt(i-1);

            for (int j = 1; j <= n ; j++) {
                char char2 = str2.charAt(j-1);

                if (char1 == char2) {
                    M[i][j] = M[i-1][j-1];
                } else {
                    int delete = M[i-1][j];
                    int replace = M[i][j-1];

                    M[i][j] = Math.min(delete, replace) + 1;
                }
            }
        }

        return M[m][n];
    }

    public static void main(String[] args) {
        String str1 = "jimjimjim";
        String str2 = "jimjimjim";

        StringEditDistance sed = new StringEditDistance();
        int dist = sed.getEditDistance(str1, str2);
        System.out.println(dist);
    }
}
