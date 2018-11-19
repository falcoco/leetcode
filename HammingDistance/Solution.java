package HammingDistance;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-19 17:20
 **/

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 */

/**
 * Refer to https://blog.csdn.net/katrina95/article/details/79039998
 */

class Solution {
  public int hammingDistance(int x, int y) {
    int temp = x^y;
    int count = 0;
    for (int i = 0; i < 31; i++) {
      count += (temp >> i) & 1;
    }
    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.hammingDistance(1 ,4));
  }
}
