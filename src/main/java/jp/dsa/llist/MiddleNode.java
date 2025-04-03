package jp.dsa.llist;

public class MiddleNode {
    static ListNode head;

    public static void main(String[] args) {
        head = ListNode.append(head, 1);
        head = ListNode.append(head, 2);
        head = ListNode.append(head, 1);
        head = ListNode.append(head, 3);
        head = ListNode.append(head, 4);
        head = ListNode.append(head, 6);
        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}