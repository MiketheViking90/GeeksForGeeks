package algorithms;

import java.util.Arrays;

public class MergeSortedArray {

    void merge(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;

        int i = len1-len2-1;
        int j = len2-1;
        int k = len1-1;

        while (k > i) {
            System.out.println(A[i] + ", " + B[j]);
            if (B[j] > A[i]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray ms = new MergeSortedArray();

        int[] A = {1, 3, 8, 12, 0, 0, 0, 0, 0};
        int[] B = {2, 3, 5, 6, 16};

        ms.merge(A, B);
        System.out.println(Arrays.toString(A));
    }
}
