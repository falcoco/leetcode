package IncreasingOrderSearchTree;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-13 13:29
 **/

/**
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the
 * root of the tree, and every node has no left child and only 1 right child.
 */

import apple.laf.JRSUIUtils.Tree;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
  public TreeNode increasingBST(TreeNode root) {
    List<Integer> collection = new LinkedList<>();
    collection = IOT(root, collection);
    TreeNode zero = new TreeNode(collection.get(0));
    TreeNode cursor = zero;
    for (int i = 1; i < collection.size(); i++) {
      cursor.right = new TreeNode(collection.get(i));
      cursor = cursor.right;
    }
    return zero;
  }
  public List<Integer> IOT(TreeNode root, List<Integer> collection){
    if (root != null){
      TreeNode leftChild = root.left;
      TreeNode rightChild = root.right;
      IOT(leftChild, collection);
      collection.add(root.val);
      IOT(rightChild, collection);
    }
    return collection;
  }
}