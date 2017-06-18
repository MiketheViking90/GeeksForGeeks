package algorithms.dyanamicprogramming;

public class CountHops {

    public int countHops(int n) {
        int[] M = new int[n+1];
        M[1] = 1;
        M[2] = 2;
        M[3] = 3;

        for (int i = 4; i <= n; i++) {
            M[i] = M[i-1] + M[i-2] + M[i-3];
        }

        return M[n];
    }

    public static void main(String[] args) {
        CountHops ch = new CountHops();
        int hops = ch.countHops(12);

        System.out.println(hops);
    }
}
