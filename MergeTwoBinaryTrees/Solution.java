package MergeTwoBinaryTrees;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-20 11:04
 **/

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

 Example 1:

 Input:
        Tree 1                     Tree 2
          1                         2
        / \                       / \
      3   2                     1   3
     /                           \   \
    5                             4   7
 Output:
 Merged tree:
      3
    / \
  4   5
 / \   \
 5  4   7


 Note: The merging process must start from the root nodes of both trees.
 */

import utils.TreeNode;


class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

    int rootValue = 0;
    if (t1 != null){
      rootValue += t1.val;
    }
    if (t2 != null){
      rootValue += t2.val;
    }
    if (rootValue == 0 && t1 == null && t2 ==null){
      return null;
    }

    TreeNode root = new TreeNode(rootValue);
    if (t1 != null && t2 != null) {
      root.left = mergeTrees(t1.left, t2.left);
      root.right = mergeTrees(t1.right, t2.right);
    }else if (t1 == null && t2 != null){
      root.left = mergeTrees(null, t2.left);
      root.right = mergeTrees(null, t2.right);
    }
    else if (t1 != null && t2 == null){
      root.left = mergeTrees(t1.left, null);
      root.right = mergeTrees(t1.right, null);
    }

    return root;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(3);
    t1.left.left = new TreeNode(5);
    t1.right = new TreeNode(2);

    TreeNode t2 = new TreeNode(2);
    t2.left = new TreeNode(1);
    t2.left.right = new TreeNode(4);
    t2.right = new TreeNode(3);
    t2.right.right = new TreeNode(7);

    TreeNode root = new Solution().mergeTrees(t1, t2);
    System.out.println(root.val);
    System.out.println(root.left.val+" , "+root.right.val);
    System.out.println(root.left.left.val+" , "+root.left.right.val + " , " + root.right.right.val);
  }
}
