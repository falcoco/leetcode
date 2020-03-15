package ReverseLinkedList;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

import sun.security.krb5.internal.APRep;
import utils.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode reverseList(ListNode root) {
        root = printCurrentNodeIfNextIsNull(root);
        return root;
    }

    public static ListNode printCurrentNodeIfNextIsNull(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode p = printCurrentNodeIfNextIsNull(root.next);
        root.next.next = root;
        root.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode reversed = reverseList(root);

        System.out.println("");
        while (reversed != null) {
            System.out.print(reversed.val + "->");
            reversed = reversed.next;
        }
    }
}