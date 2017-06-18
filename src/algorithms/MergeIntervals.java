package algorithms;

import java.util.*;

public class MergeIntervals {

    public static class Interval {
        int min;
        int max;

        public Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public String toString() {
            return "{" + min + ", " + max + "}";
        }
    }

    public Interval[] mergeIntervals(List<Interval> intervals) {
        intervals.sort(byMin);
        Deque<Interval> stack = new LinkedList<>();

        for (Interval interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                Interval topInterval = stack.peek();
                if (topInterval.max >= interval.min) {
                    Interval merged = new Interval(topInterval.min, interval.max);
                    stack.pop();
                    stack.push(merged);
                } else {
                    stack.push(interval);
                }
            }
        }

        return stack.toArray(new Interval[stack.size()]);
    }

    Comparator<Interval> byMin = (Interval in1, Interval in2) -> {
        if (in1.min < in2.min) {
            return -1;
        } else if (in1.min > in2.min) {
            return 1;
        } else {
            return 0;
        }
    };

    public static void main(String[] args) {
        Interval i4 = new Interval(8, 15);
        Interval i1 = new Interval(0, 2);
        Interval i2 = new Interval(1, 5);
        Interval i3 = new Interval(7, 8);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        MergeIntervals mi = new MergeIntervals();
        Interval[] vals = mi.mergeIntervals(intervals);
        System.out.println(Arrays.toString(vals));
    }
}
