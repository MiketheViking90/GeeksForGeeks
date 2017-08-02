package datastructures.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListIntersection {

    public ListNode findIntersection(ListNode l1, ListNode l2) {
        Deque<ListNode> s1 = new LinkedList<>();
        Deque<ListNode> s2 = new LinkedList<>();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode intersection = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode c1 = s1.pop();
            ListNode c2 = s2.pop();

            if (c1.val == c2.val) {
                intersection = c1;
            } else {
                return intersection;
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.makeList();
        ListNode l2 = ListNode.makeList();

        LinkedListIntersection lli = new LinkedListIntersection();
        ListNode in = lli.findIntersection(l1, l2);
        ListNode.printList(in);
    }
}
