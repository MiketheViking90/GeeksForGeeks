package algorithms;

public class SumOfMiddleElements {

    public int sum(int[] A, int[] B) {
        int len = A.length;

        int i = 0;
        int j = 0;

        while ((i + j) < (len-1)) {
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return A[i] + B[j];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 6, 10};
        int[] B = {4, 5, 6, 9, 12};

        SumOfMiddleElements s = new SumOfMiddleElements();
        int sum = s.sum(A, B);
        System.out.println(sum);
    }
}
