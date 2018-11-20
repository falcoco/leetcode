package PeakIndexInAMountainArray;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-20 15:06
 **/

/**
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] >
 * A[i+1] > ... > A[A.length - 1] Given an array that is definitely a mountain, return any i such
 * that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Example 1:
 *
 * Input: [0,1,0] Output: 1 Example 2:
 *
 * Input: [0,2,1,0] Output: 1 Note:
 *
 * 3 <= A.length <= 10000 0 <= A[i] <= 10^6 A is a mountain, as defined above.
 */

class Solution {

  public int peakIndexInMountainArray(int[] A) {
    int maxIndex = 0;
    int max = A[0];
    for (int i = 0; i < A.length; i++) {
      if (A[i] > max){
        max = A[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
  }
}
