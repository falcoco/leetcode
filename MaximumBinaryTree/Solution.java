package MaximumBinaryTree;

import java.util.Arrays;
import utils.TreeNode;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-19 11:50
 **/
class Solution {
  public static TreeNode constructMaximumBinaryTree(int[] nums) {
    TreeNode newNode = null;
    if (nums.length > 0){
      int max = nums[0];
      int maxIndex = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max){
          max = nums[i];
          maxIndex = i;
        }
      }
      newNode = new TreeNode(max);
      if (maxIndex > 0) {
        int[] leftSubNums = Arrays.copyOfRange(nums, 0, maxIndex);
        newNode.left = constructMaximumBinaryTree(leftSubNums);
      }else {

      }
      if (maxIndex < nums.length) {
        int[] rightSubNums = Arrays.copyOfRange(nums, maxIndex+1, nums.length);
        newNode.right = constructMaximumBinaryTree(rightSubNums);
      }else {

      }
    }
    return newNode;
  }

  public static void main(String[] args) {
    int[] nums = {3,2,1,6,0,5};
    TreeNode root = constructMaximumBinaryTree(nums);
    System.out.println(root.val);
  }
}