package MaximumDepthofBinaryTree;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-13 10:49
 **/

/**
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Note: A leaf is a node with no children.

 Example:

 Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
     / \
    15  7
 return its depth = 3.
 */


import utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
//  private static int depth = 1;
//  public static int maxDepth(TreeNode root) {
//
//    if (root == null){
//      return 0;
//    }
//    havaSon(root);
//    return depth;
//  }
//
//  public static int havaSon(TreeNode root){
//
//    TreeNode leftChild;
//    TreeNode rightChild;
//
//    int exist = 0;
//
//    if(root != null){
//      leftChild = root.left;
//      rightChild = root.right;
//      if (leftChild != null || rightChild != null){
////        System.out.println("Current root node is : "+root.val);
//        if (leftChild != null){
//          System.out.println("Left node is : "+leftChild.val);
//        }
//        if (rightChild != null){
//          System.out.println("Right node is : "+rightChild.val);
//        }
//        depth ++;
//      }else{
//        return exist;
//      }
//      if (leftChild != null){
//        depth += havaSon(leftChild);
////        System.out.println("Left child node is : "+leftChild.val);
//        exist = 1;
//      }
//      if (rightChild != null){
//        depth += havaSon(rightChild);
////        System.out.println("Left child node is : "+rightChild.val);
//        exist = 1;
//      }
//    }
//    return exist;
//  }

    public static int maxDepth(TreeNode root) {
      if (root == null){
        return 0;
      }else {
        return 1 + findMaxDepth(root);
      }
    }
    public static int findMaxDepth(TreeNode root){
      // mark the depth of current node
      int nodeDepth = 0;

      if (root == null){
        return 0;
      }
      else {
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null){
          leftDepth ++;
          leftDepth += findMaxDepth(root.left);
        }
        if (root.right != null){
          rightDepth ++;
          rightDepth += findMaxDepth(root.right);
        }
        nodeDepth += leftDepth > rightDepth ? leftDepth : rightDepth;
      }
      return nodeDepth;
    }

  public static void main(String[] args) {
      TreeNode root = null;
//    TreeNode root = new TreeNode(0);
//    root.left = new TreeNode(9);
//    root.right = new TreeNode(20);
//    root.right.left = new TreeNode(15);
//    root.right.right = new TreeNode(7);
    System.out.println(maxDepth(root));
  }
}
