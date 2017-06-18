package algorithms.dyanamicprogramming;

public class ReachNthPoint {

    int countCombos(int n) {
        int[] counts = new int[n+1];

        counts[0] = 1;
        counts[1] = 1;
        counts[2] = 2;

        for (int i = 3; i <= n; i++) {
            counts[i] = counts[i-1] + counts[i-2];
        }
        return counts[n];
    }

    public static void main(String[] args) {
        ReachNthPoint r = new ReachNthPoint();
        int cnt = r.countCombos(5);
        System.out.println(cnt);
    }
}
