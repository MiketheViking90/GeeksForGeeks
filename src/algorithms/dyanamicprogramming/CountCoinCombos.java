package algorithms.dyanamicprogramming;

import java.util.Arrays;

public class CountCoinCombos {

    public int countDP(int val, int[] coins) {
        int[] M = new int[val + 1];
        M[0] = 1;

        for (int c : coins) {
            for (int i = c; i <= val; i++) {
                M[i] += M[i - c];
            }
        }

        System.out.println(Arrays.toString(M));
        return M[val];
    }


    public static void main(String[] args) {
        CountCoinCombos ccc = new CountCoinCombos();
        int cnt = ccc.countDP(10, new int[]{2, 5, 3, 6});
        int cnt1 = ccc.countDP(4, new int[]{1, 2, 3});

        System.out.println(cnt);
    }
}
