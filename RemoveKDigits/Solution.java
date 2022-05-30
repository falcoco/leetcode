package RemoveKDigits;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public static String removeKdigits(String num, int k) {
        if(num.length() <= k){
            return "0";
        }
        char[] chars = num.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < chars.length; ++i){
            int value = Integer.parseInt(String.valueOf(chars[i]));
            while(!stack.isEmpty() && value < stack.peek() && k-->0){
                stack.pop();
            }
            if (stack.isEmpty() && value == 0){
                continue;
            }
            stack.push(value);
        }
        while(!stack.isEmpty() && k-- > 0){
            stack.pop();
        }
        if(stack.isEmpty()){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.insert(0,stack.pop().toString());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10001",
                4));
    }
}
