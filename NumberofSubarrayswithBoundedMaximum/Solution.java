/**
 * 795. Number of Subarrays with Bounded Maximum
 *
 * We are given an array A of positive integers, and two positive integers L and R (L <= R). Return
 * the number of (contiguous, non-empty) subarrays such that the value of the maximum array element
 * in that subarray is at least L and at most R.
 *
 * Example:
 */

/*
    o(n2)
 */
class Solution {

  public static int numSubarrayBoundedMax(int[] A, int L, int R) {
    int countResult = 0;
    if (A.length == 0) {
      return 0;
    }
    int leftCur = 0;
    int rightCur = 0;
    int tempCount = 0;
    int tempScore = 0;

    for (int i = 0; i < A.length; i++) {
      // Start from left side
      rightCur = leftCur = i;

      // left cursor stand still
      tempScore = A[rightCur];

      while (rightCur < A.length) {
        // calculate the maximum of the subarray
        if (A[rightCur] >= tempScore && A[rightCur] <= R) {
          tempScore = A[rightCur];
        } else if (A[rightCur] > R) {
          break;
        }
        // System.out.println("The valid range is: " + leftCur + "->" + rightCur);

        // move forward the right cursor
        rightCur++;

        // calculate the number of the subarrays
        if (tempScore >= L || tempScore <= R) {
          tempCount++;
        } else if (tempScore < L) {
          continue;
        } else {
          break;
        }
      }

      //System.out.println("Length is:" + tempCount);

      countResult += tempCount;
      tempCount = 0;
    }
    return countResult;
  }

  public static void main(String[] args) {
//    int A[] = {2, 9, 2, 5, 6};
//    int L = 2;
//    int R = 8;

//    int A[] = {2,1,4,3};
//    int L = 2;
//    int R = 3;

    int A[] = {73,55,36,5,55,14,9,7,72,52};
    int L = 32;
    int R = 69;

    System.out.println(numSubarrayBoundedMax(A, L, R));
  }
}