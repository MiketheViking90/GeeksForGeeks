package datastructures.linkedlist;

public class SegregateEvenOddNodes {

    public ListNode segregate(ListNode head) {
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;

        while (head != null) {
            if ((head.val % 2) != 0) {
                if (oddHead == null) {
                    oddHead = head;
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) {
                    evenHead = head;
                    evenTail = evenHead;
                } else {
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            }
            head = head.next;
        }
        oddTail.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.makeList();
        SegregateEvenOddNodes s = new SegregateEvenOddNodes();
        node = s.segregate(node);
        ListNode.printList(node);
    }
}
