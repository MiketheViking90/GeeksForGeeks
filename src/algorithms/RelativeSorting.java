package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSorting {

    public int[] relativeSort(int[] input, int[] order) {
        Map<Integer, Integer> valueToCount = new HashMap<>();
        for (int n : input) {
            int cnt = valueToCount.getOrDefault(n, 0);
            valueToCount.put(n, cnt+1);
        }
        System.out.println(valueToCount);

        int[] output = new int[input.length];
        int i = 0;
        int j = 0;
        while (j < order.length) {
            int curPri = order[j];
            int cnt = valueToCount.get(curPri);
            valueToCount.remove(curPri);
            while (cnt-- > 0) {
                output[i++] = curPri;
            }

            j++;
        }

        System.out.println(Arrays.toString(output));
        System.out.println(valueToCount);
        for (int n : valueToCount.keySet()) {
            int cnt = valueToCount.get(n);
            while (cnt-- > 0) {
                output[i++] = n;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] order = {2, 1, 8, 3};

        RelativeSorting rs = new RelativeSorting();
        int[] output = rs.relativeSort(input, order);
        System.out.println(Arrays.toString(output));
    }
}
