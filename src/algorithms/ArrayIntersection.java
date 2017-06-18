package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    public int[] findIntersection(int[] A, int[] B) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : A) {
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : B) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }

        int[] intersect = new int[set2.size()];
        int i = 0;
        for (int j : set2) {
            intersect[i++] = j;
        }
        return intersect;
    }

    public static void main(String[] args) {
        ArrayIntersection ai = new ArrayIntersection();

        int[] A = {1, 2, 2, 1, 3, 8};
        int[] B = {2, 3};
        int[] intersect = ai.findIntersection(A, B);
        System.out.println(Arrays.toString(intersect));
    }
}
