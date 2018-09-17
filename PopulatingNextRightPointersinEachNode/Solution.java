package PopulatingNextRightPointersinEachNode;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-07 14:23
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
  Populate each next pointer to point to its next right node. If there is no next right node, the
  next pointer should be set to NULL. Initially, all next pointers are set to NULL.

Note:
  You may only use constant extra space.
  Recursive approach is fine, implicit stack space does not count as extra space for this problem.
  You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every
  parent has two children).
Example:

  Given the following perfect binary tree,

          1
        /  \
      2    3
    / \  / \
  4  5  6  7
After calling your function, the tree should look like:

          1 -> NULL
        /  \
      2 -> 3 -> NULL
    / \  / \
  4->5->6->7 -> NULL
 **/



/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null){
      return;
    }
    TreeLinkNode leftChild = root.left;
    TreeLinkNode rightChild = root.right;
    // target: get next right node
    if (leftChild != null && rightChild != null){

      // create connection in the same level
      leftChild.next = rightChild;

      // create connection between two adjacent leaves that are not brother
      if (leftChild.right != null && rightChild.left != null){
        leftChild.right.next = rightChild.left;
      }
      if (root.next != null){
        root.right.next = root.next.left;
      }
      connect(leftChild);
      connect(rightChild);
    }
  }

  public class TreeLinkNode {

    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
      val = x;
    }
  }

}
