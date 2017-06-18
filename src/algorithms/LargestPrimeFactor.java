package algorithms;

public class LargestPrimeFactor {

    int lpf(int n) {
        boolean[] sieve = new boolean[n+1];
        sieve[0] = sieve[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!sieve[i]) {
                int cnt = i * 2;
                while (cnt <= n) {
                    sieve[cnt] = true;
                    cnt += i;
                }
            }
        }
//
//        for (int i = 0; i <= n; i++) {
//            System.out.println(i + ": " + sieve[i]);
//        }

        int maxFactor = 0;
        for (int i = 2; i <= n; i++) {
            if (!sieve[i] && isFactor(n, i)) {
                maxFactor = i;
            }
        }

        return maxFactor;
    }

    private boolean isFactor(int n, int i) {
        return (n % i) == 0;
    }

    public static void main(String[] args) {
        LargestPrimeFactor lpf = new LargestPrimeFactor();
        int f = lpf.lpf(11);
        System.out.println(f);

        f = lpf.lpf(12);
        System.out.println(f);

        f = lpf.lpf(37);
        System.out.println(f);

        f = lpf.lpf(127);
        System.out.println(f);
    }
}
