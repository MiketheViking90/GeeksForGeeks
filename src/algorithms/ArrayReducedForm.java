package algorithms;

import java.util.*;

public class ArrayReducedForm {

    public int[] getReducedForm(int[] nums) {
        Set<Integer> ordered = new TreeSet<>();
        for (int n : nums) {
            ordered.add(n);
        }

        Map<Integer, Integer> valueToOrder = new HashMap<>();
        int order = 0;
        for (int n : ordered) {
            valueToOrder.put(n, order++);
        }

        int[] orderedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int o = valueToOrder.get(n);
            orderedNums[i] = o;
        }

        return orderedNums;
    }


    public static void main(String[] args) {
        ArrayReducedForm arf = new ArrayReducedForm();

        int[] a1 = {10, 40, 20 };
        int[] a2 = {5, 10, 40, 30, 20 };

        int[] a1Ordered = arf.getReducedForm(a1);
        int[] a2Ordered = arf.getReducedForm(a2);

        System.out.println(Arrays.toString(a1Ordered));
        System.out.println(Arrays.toString(a2Ordered));

    }
}
