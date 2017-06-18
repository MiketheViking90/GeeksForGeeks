package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinCostOfRopes {

    public int findCost(int[] ropes) {
        int cost = 0;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (int n : ropes) {
            minQueue.add(n);
        }

        while (minQueue.size() > 1) {
            int curRope= minQueue.poll();
            int nextRope = minQueue.poll();
            int curCost = curRope + nextRope;

            cost += (curCost + curCost);
            minQueue.offer(curCost);

            System.out.println(Arrays.toString(minQueue.toArray()));
        }

        return minQueue.poll();
    }

    public static void main(String[] args) {
//        int[] ropes1 = {4, 3, 2, 6};
        int[] ropes2 = {4, 3, 2, 6, 3, 1, 4, 8, 9};
        MinCostOfRopes mc = new MinCostOfRopes();
        mc.findCost(ropes2);
    }
}
