package datastructures.linkedlist;

public class LinkedListInsert {

    public void insert(ListNode head, int val) {
        ListNode node = head;

        boolean foundEnd = false;
        while (node.next != null && !foundEnd) {
            if (node.val < val) {
                node = node.next;
            } else {
                foundEnd = true;
            }
        }

        ListNode insert = new ListNode(val);
        insert.next = node.next;
        node.next = insert;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.makeList();
        LinkedListInsert ll = new LinkedListInsert();
        ll.insert(head, 123);
        ListNode.printList(head);
    }
}
