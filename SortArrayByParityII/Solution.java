package SortArrayByParityII;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-20 15:15
 **/

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the
 * integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [4,2,5,7] Output: [4,5,2,7] Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have
 * been accepted.
 *
 *
 * Note:
 *
 * 2 <= A.length <= 20000 A.length % 2 == 0 0 <= A[i] <= 1000
 */

class Solution {

  public int[] sortArrayByParityII(int[] A) {
    int index = 1;
    for (int i = 0; i < A.length - 1; i++) {
      if (index <= i){
        index = i+1;
      }
      while (true) {
        // If i is even.
        if (i % 2 == 0) {
          if (A[i] % 2 == 0) {
            break;
          } else if (A[index] % 2 == 0) {
            int temp = A[i];
            A[i] = A[index];
            A[index] = temp;
          } else {
            index++;
          }
        } else {
          // If i is odd.
          if (A[i] % 2 != 0) {
            break;
          } else if (A[index] % 2 != 0) {
            int temp = A[i];
            A[i] = A[index];
            A[index] = temp;
          } else {
            index++;
          }
        }
      }
    }
    return A;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] result = solution.sortArrayByParityII(new int[]{7,4,3,4,5,2,3,4,1,1,8,6});
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + ", ");
    }
  }
}
