package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

    public List<Integer> merge(int[][] arrays) {
        PriorityQueue<IndexArray> q = new PriorityQueue<>(arrays.length);
        for (int[] arr : arrays) {
            q.add(new IndexArray(arr));
        }

        List<Integer> sorted = new ArrayList<>();
        while (!q.isEmpty()) {
            IndexArray topArray = q.poll();
            sorted.add(topArray.getValue());

            if (topArray.index < topArray.array.length-1) {
                q.add(new IndexArray(topArray.array, topArray.index+1));
            }
        }
        return sorted;
    }

    class IndexArray implements Comparable<IndexArray> {
        int[] array;
        int index = 0;

        public int getValue() {
            return array[index];
        }

        public IndexArray(int[] array) {
            this.array = array;
        }

        public IndexArray(int[] array, int index) {
            this.array = array;
            this.index = index;
        }

        @Override
        public int compareTo(IndexArray o) {
            int thisValue = array[index];
            int thatValue = o.array[o.index];
            return Integer.compare(thisValue, thatValue);
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays msa = new MergeSortedArrays();
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[][] arrs = new int[][] { arr1, arr2, arr3 };
        List<Integer> sorted = msa.merge(arrs);
        System.out.println(Arrays.toString(sorted.toArray()));
    }

}
