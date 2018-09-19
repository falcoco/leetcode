package BinaryTreeTilt;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-17 11:51
 **/

import utils.TreeNode;

/**
 * Given a binary tree, return the tilt of the whole tree.

 The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

 The tilt of the whole tree is defined as the sum of all nodes' tilt.

 Example:
 Input:
 1
 /   \
 2     3
 Output: 1
 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1
 Note:

 The sum of node values in any subtree won't exceed the range of 32-bit integer.
 All the tilt values won't exceed the range of 32-bit integer.

 */
class Solution {
  public static int findTilt(TreeNode root) {
    int sum = 0;
    if (root != null){
      TreeNode left = root.left;
      TreeNode right = root.right;

      if (left != null && right != null){
        sum += Math.abs(count(left) - count(right));
      }else if(left == null && right != null){
        sum += Math.abs(count(right));
      }else if (left != null && right == null){
        sum += Math.abs(count(left));
      }
      sum += findTilt(left);
      sum += findTilt(right);
      return sum;
    }
    return sum;
  }

  private static int count(TreeNode root){
    int sum  = 0;
    if (root != null){
      TreeNode left = root.left;
      TreeNode right = root.right;
      sum += root.val;
      if (left != null){
        sum += count(left);
      }
      if (right != null){
        sum += count(right);
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    System.out.println(findTilt(root));
  }
}
