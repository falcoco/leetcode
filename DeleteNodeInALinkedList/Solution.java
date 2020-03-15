package DeleteNodeInALinkedList;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 *
 *
 *  
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *  
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import utils.ListNode;

import java.rmi.UnexpectedException;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode root = new ListNode(4);
    public static ListNode node1 = new ListNode(5);
    public static ListNode node2 = new ListNode(1);
    public static ListNode node3 = new ListNode(9);

    public static void deleteNode(ListNode node) {
        while ( node != null && node.next != null){
            node.val = node.next.val;

            if (node.next.next == null){
                node.next = null;
            }

            if(node.next != null){
                node = node.next;
            }

        }

        System.out.println("123");
    }

    public static void main(String[] args) {
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        deleteNode(node1);
    }
}