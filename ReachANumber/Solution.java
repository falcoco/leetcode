package ReachANumber;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-29 10:13
 **/

/**
 *
 * You are standing at position 0 on an infinite number line. There is a goal at position target.

 On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

 Return the minimum number of steps required to reach the destination.

 Example 1:
 Input: target = 3
 Output: 2
 Explanation:
 On the first move we step from 0 to 1.
 On the second step we step from 1 to 3.
 Example 2:
 Input: target = 2
 Output: 3
 Explanation:
 On the first move we step from 0 to 1.
 On the second move we step  from 1 to -1.
 On the third move we step from -1 to 2.
 Note:
 target will be a non-zero integer in the range [-10^9, 10^9].

 */

class Solution {
  public int reachNumber(int target) {
    int source = Math.abs(target);
    int count = 0;
    while (source > 0) {
      count++;
      source = source - count;
    }
    if (source % 2 == 0){
      return count;
    }else {
      return count + 1 + count % 2;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int testScore =  5;
    int result = solution.reachNumber(testScore);
    System.out.println(result);
  }
}
