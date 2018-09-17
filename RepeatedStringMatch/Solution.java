package RepeatedStringMatch;


/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-14 16:57
 **/

class Solution {
  public int longestUnivaluePath(TreeNode root) {
    int leftDepth = 0;
    int rightDepth = 0;
    if (root != null) {
      TreeNode left = root.left;
      TreeNode right = root.right;
      if (left != null && right != null && left.val == right.val && right.val == root.val){
        leftDepth++;
        rightDepth++;
      }




//      if (left != null && left.val == root.val) {
//        leftDepth++;
//        leftDepth += longestUnivaluePath(left);
//      } else {
//        leftDepth = 0;
//        leftDepth += longestUnivaluePath(left);
//      }
//      if (right != null && right.val == root.val) {
//        rightDepth++;
//        rightDepth += longestUnivaluePath(right);
//      } else {
//        rightDepth = 0;
//        rightDepth += longestUnivaluePath(right);
//      }
    }
    return leftDepth > rightDepth ? leftDepth : rightDepth;
  }
}