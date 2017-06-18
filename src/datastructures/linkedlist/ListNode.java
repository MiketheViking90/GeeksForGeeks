package datastructures.linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static void printList(ListNode head) {
        StringBuffer listString = new StringBuffer();
        while (head != null) {
            listString.append(head.val+">");
            head = head.next;
        }

        System.out.println(listString.toString());
    }

    public static ListNode makeList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode n6 = new ListNode(6);
        n5.next = n6;

        return n1;
    }

}
