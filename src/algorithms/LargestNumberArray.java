package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumberArray {

    Comparator<Integer> digitComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            if (a.equals(b)) {
                return 0;
            }

            String aStr = String.valueOf(a);
            String bStr = String.valueOf(b);

            int aLen = aStr.length();
            int bLen = bStr.length();
            int len = Math.min(aLen, bLen);
            int i = 0;
            while (i < len) {
                System.out.println(aStr + ": " + aStr.charAt(i));
                System.out.println(bStr + ": " + bStr.charAt(i));
                if (aStr.charAt(i) > bStr.charAt(i)) {
                    return 1;
                } else if (aStr.charAt(i) < bStr.charAt(i)) {
                    return -1;
                }
                i++;
            }

            if (i == aLen) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    String getLargestNumber(List<Integer> nums) {
        nums.sort(digitComparator.reversed());
        System.out.println(Arrays.toString(nums.toArray()));
        StringBuilder str = new StringBuilder();
        for (int n : nums) {
            str.append(n);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        LargestNumberArray lna = new LargestNumberArray();
        List<Integer> nums = Arrays.asList(1, 34, 3, 98, 9, 76, 45, 4);
        List<Integer> nums1 = Arrays.asList(54, 546, 548, 60);

        String str = lna.getLargestNumber(nums);
        System.out.println(str);

        String str1 = lna.getLargestNumber(nums1);
        System.out.println(str1);
    }
}
