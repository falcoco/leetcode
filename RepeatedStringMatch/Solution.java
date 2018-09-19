package RepeatedStringMatch;


import utils.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-14 16:57
 **/

class Solution {

  private static int ans;

  public static int longestUnivaluePath(TreeNode root) {
    if (root == null) return 0;
    find(root);
    return ans;
  }

  public static int find(TreeNode root) {
    if (root == null){
      return 0;
    }
    int leftDepth = 0;
    int rightDepth = 0;

    TreeNode left = root.left;
    TreeNode right = root.right;

    if (left != null && root.val == left.val) leftDepth = find(left) + 1;

    if (right != null && root.val == right.val) rightDepth = find(right) + 1;

    ans = Math.max(ans, leftDepth + rightDepth);

    return Math.max(leftDepth, rightDepth);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(5);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(4);

    System.out.println(longestUnivaluePath(root));
  }
}