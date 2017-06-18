package algorithms.dyanamicprogramming;

public class UniqueBST {

    public int countBST(int n) {
        int[] M = new int[n+1];

        M[0] = 1;
        M[1] = 1;
        M[2] = 2;

        for (int i = 3; i <= n; i++) {
            int cnt = 0;

            for (int j = 0; j < i; j++) {
                cnt += (M[j] * M[i-1-j]);
            }
            M[i] = cnt;
        }

        return M[n];
    }

    public static void main(String[] args) {
        UniqueBST ub = new UniqueBST();
        System.out.println(ub.countBST(3));
        System.out.println(ub.countBST(4));
        System.out.println(ub.countBST(5));
        System.out.println(ub.countBST(6));
    }
}
