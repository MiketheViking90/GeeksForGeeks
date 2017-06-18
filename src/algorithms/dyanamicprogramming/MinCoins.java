package algorithms.dyanamicprogramming;

public class MinCoins {

    public int countCoins(int[] coins, int val) {
        int[] M = new int[val+1];

        for (int i = 1; i <= val; i++) {
            M[i] = Integer.MAX_VALUE;
            int coinIndex = 0;
            while (coinIndex < coins.length && coins[coinIndex] <= i) {
                if (coins[coinIndex] == i) {
                    M[i] = 1;
                    break;
                } else {
                    int prev = (i - coins[coinIndex]);
                    M[i] = Math.min(M[i], M[prev] + 1);
                    coinIndex++;
                }
            }
        }

        return M[val];
    }

    public static void main(String[] args) {
        MinCoins mc = new MinCoins();
        int[] coins = {2, 3, 7, 10};
        int val = 7;

        int n = mc.countCoins(coins,val);
        System.out.println(n);
    }
}
