package algorithms;

public class MedianSortedArrays {

    public int findMedian(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;

        int med = (len1 + len2) / 2;

        int i = 0;
        int a = len1-1;
        int b = len2-1;
        while (i < med) {
            System.out.println(A[a] + ", " + B[b]);
            if (A[a] > B[b]) {
                a--;
            } else {
                b--;
            }
            i++;
        }
        return Math.max(A[a], B[b]);
    }

    public static void main(String[] args) {
        MedianSortedArrays ms = new MedianSortedArrays();

        int[] A = {1, 3, 5, 12, 123};
        int[] B = {2, 3, 4};
        int med = ms.findMedian(A, B);
        System.out.println(med);
    }
}
