package com.treeke.algorithm;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class ReversePolish {

    public static void main(String[] args) {
        ReversePolish reversePolish = new ReversePolish();
        //int i = reversePolish.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        //int i = reversePolish.evalRPN(new String[]{"4","13","5","/","+"});
        int i = reversePolish.evalRPN(new String[]{"4"});
        //int i = reversePolish.evalRPN(new String[]{"4","-2","/","2","-3","-","-"});
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    Integer pop = stack.pop();
                    stack.push(stack.pop() - pop);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer p = stack.pop();
                    stack.push(stack.pop() / p);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
