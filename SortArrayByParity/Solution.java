package SortArrayByParity;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-19 16:57
 **/

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [3,1,2,4]
 Output: [2,4,3,1]
 The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


 Note:

 1 <= A.length <= 5000
 0 <= A[i] <= 5000

 */
class Solution {
  public int[] sortArrayByParity(int[] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = i; j < A.length; j++) {
        if (A[i] % 2 != 0 || A[j] % 2 == 0){
          int temp = A[j];
          A[j] = A[i];
          A[i] = temp;
        }
      }
    }
    return A;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] result = solution.sortArrayByParity(new int[]{3,7,2,8,0,4,1,2,4});
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i]+",");
    }
  }
}
