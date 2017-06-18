package algorithms.dyanamicprogramming;

public class MinNumberOfJumps {

    int countJumps(int[] jumps) {
        int n = jumps.length;
        int[] M = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int min = M[i-1];

            for (int j = 0; j < i-1; j++) {
                if (jumps[j] + j >= i) {
                    min = Math.min(min, M[j+1] +1);
                }
            }
            M[i] = min;
        }
        return M[n];
    }
    
}
