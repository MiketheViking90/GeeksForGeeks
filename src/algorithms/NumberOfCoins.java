package algorithms;

public class NumberOfCoins {

    public int count(int value, int[] coins) {
        int count = 0;

        int i = 0;
        while (value > 0) {
            if (value >= coins[i]) {
                System.out.println(coins[i]);
                value -= coins[i];
                count++;
            } else if (value < coins[i]) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfCoins nc = new NumberOfCoins();
        int[] coins = {25, 10, 5, 1};
        int n = nc.count(43, coins);
        System.out.println(n);
    }

}
