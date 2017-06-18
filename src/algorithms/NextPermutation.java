package algorithms;

import java.util.Arrays;

public class NextPermutation {

    public int[] nextPermutation(int[] in) {
        int len = in.length;
        int[] maxRight = new int[len];
        maxRight[len-1] = in[len-1];

        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], in[i]);
        }

        System.out.println("in: " + Arrays.toString(in));
        System.out.println("right: " + Arrays.toString(maxRight));

        boolean foundSwap = false;

        for (int i = len-2; i >= 0; i--) {
            if (in[i] < maxRight[i]) {
                swap(in, i, maxRight[i]);
                return in;
            }
        }
        Arrays.sort(in);
        return in;
    }

    private void swap(int[] in, int i, int val) {
        int t = in[i];
        in[i] = val;

        System.out.println("mid: " + Arrays.toString(in));
        for (int j = in.length - 1; j >= 0; j--) {
            if (in[j] == val) {
                in[j] = t;
                break;
            }
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] in = {3, 4, 7, 2, 3, 1};
        in = np.nextPermutation(in);
        System.out.println("out: " + Arrays.toString(in));
    }
}
