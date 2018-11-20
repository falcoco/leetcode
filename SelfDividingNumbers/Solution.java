package SelfDividingNumbers;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-11-20 13:20
 **/

import java.util.LinkedList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.

 For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

 Also, a self-dividing number is not allowed to contain the digit zero.

 Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

 Example 1:
 Input:
 left = 1, right = 22
 Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 Note:

 The boundaries of each input argument are 1 <= left <= right <= 10000.

 */
class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> selfDividingNumbers = new LinkedList<>();
    for (int i = left; i <= right; i++) {
      if(isSelfDividingNumber(i)){
        selfDividingNumbers.add(i);
      }
    }
    return selfDividingNumbers;
  }

  public boolean isSelfDividingNumber(int number){

    int temp = number;
    while (temp > 0){
      if (temp % 10 == 0){
        return false;
      }
      if (number % (temp%10) !=0){
        return false;
      }
      temp = temp / 10;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<Integer> result = solution.selfDividingNumbers(66,708);
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i)+ ", ");
    }
  }
}
