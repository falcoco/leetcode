package ReverseInteger;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * 通过次数298,500提交次数882,165
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

class Solution {
    public static int reverse(int x) {
        int result = 0;
        while (x % 10 != 0 || x / 10 != 0){

            if (Integer.MAX_VALUE / 10 < result || Integer.MIN_VALUE /10 > result ){
                return 0;
            }

            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1534236469));
    }
}