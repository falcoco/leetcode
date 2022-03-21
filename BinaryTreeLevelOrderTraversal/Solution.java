package BinaryTreeLevelOrderTraversal;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        ArrayList<TreeNode> nodes =new ArrayList();
        nodes.add(root);
        List<List<Integer>> traversal = traversal(nodes);
        return traversal;
    }
    public static List<List<Integer>> traversal(List<TreeNode> nodes){
        if(nodes == null || nodes.size() == 0){
            return null;
        }
        List<List<Integer>> finalResult =new ArrayList();

        List<Integer> result =new ArrayList();

        List<TreeNode> newNodes = new ArrayList<>();
        for(TreeNode node: nodes){
            result.add(node.val);
            if(node.left != null) {
                newNodes.add(node.left);
            }
            if (node.right != null) {
                newNodes.add(node.right);
            }
        }
        finalResult.add(result);
        List<List<Integer>> traversalResult = traversal(newNodes);
        if (traversalResult != null){
            finalResult.addAll(traversalResult);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        root.left = left1;
        root.right = right1;
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        right1.left = left2;
        right1.right = right2;
        levelOrder(root);
    }
}