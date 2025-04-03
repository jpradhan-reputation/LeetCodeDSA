package jp.dsa.llist;

import java.util.Stack;

public class LinkedPalindrome {
    static ListNode head;

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tempHead = head;
        while (tempHead.next != null) {
            stack.push(tempHead.val);
            tempHead = tempHead.next;
        }
        stack.push(tempHead.val);

        while (head.next != null) {
            if (stack.peek() == head.val) {
                stack.pop();
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        head = ListNode.append(head, 1);
        head = ListNode.append(head, 2);
        head = ListNode.append(head, 3);
        head = ListNode.append(head, 2);
        head = ListNode.append(head, 1);
        System.out.println(isPalindrome(head));
    }
}