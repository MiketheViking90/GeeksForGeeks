package algorithms.dyanamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    public int[] getFibonacciNumbers(int n) {
        int[] nums = new int[n];
        nums[1] = 1;

        for (int i = 2; i < n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int[] fibs = fib.getFibonacciNumbers(13);
        System.out.println(Arrays.toString(fibs));
    }

}
