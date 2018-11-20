package ArrayPartitionI;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-20 13:47
 **/

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say
 * (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large
 * as possible.
 *
 * Example 1: Input: [1,4,3,2]
 *
 * Output: 4 Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4). Note: n
 * is a positive integer, which is in the range of [1, 10000]. All the integers in the array will be
 * in the range of [-10000, 10000].
 */
class Solution {

  public int arrayPairSum(int[] nums) {
    int sum = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length/2; i++) {
      sum += nums[i*2];
    }
    return sum;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.arrayPairSum(new int[]{1,4,6,5,3,2}));
  }
}