package algorithms;

import java.util.PriorityQueue;

public class ThreeGreatCandidates {

    public int getProduct(int[] candidates) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for (int n : candidates) {
            pq.add(n);
        }

        int product = 1;
        for (int val : pq) {
            product *= val;
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 6, 2, 3, 2};

        ThreeGreatCandidates tg = new ThreeGreatCandidates();
        int prod = tg.getProduct(nums);
        System.out.println(prod);
    }
}
