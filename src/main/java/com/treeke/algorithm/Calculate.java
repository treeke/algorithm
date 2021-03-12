package com.treeke.algorithm;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 */
public class Calculate {

    public static void main(String[] args) {
        //String s = "(11 + ( 4 - 5 + 2 )-(3+2))+(6+8)";
        String s = "2 -1 +2";
        //String s = "(1)";
        //String s = "1231";
        System.out.println(calculate(s));
    }

    static int index = 0;
    static boolean first = true;

    public static int calculate(String s) {
        int res = 0;
        String str = "";
        Boolean flag = null;
        for (int i = index; i < s.length(); i = index) {
            if(first){
                first = false;
                res = calculate(s);
                if(index >= s.length()){
                    return res;
                }
                i = index;
            }
            index++;
            if(s.charAt(i) == '('){
                int calc = calculate(s);
                if(flag == null){
                    res = calc;
                }else {
                    res = flag ? res + calc : res - calc;
                }
            }
            else if(s.charAt(i) == ')'){
                Integer integer = str.isEmpty() ? 0 : Integer.valueOf(str);
                if(flag == null){
                    return integer;
                }
                return flag ? res + integer : res - integer;
            }
            else if(s.charAt(i) == '+'){
                if(flag != null){
                    Integer integer = str.isEmpty() ? 0 : Integer.valueOf(str);
                    res = flag ? res + integer : res - integer;
                }else {
                    res = str.isEmpty() ? res : Integer.valueOf(str);
                }
                flag = true;
                str = "";
            }
            else if(s.charAt(i) == '-'){
                if(flag != null){
                    Integer integer = str.isEmpty() ? 0 : Integer.valueOf(str);
                    res = flag ? res + integer : res - integer;
                }else {
                    res = str.isEmpty() ? res : Integer.valueOf(str);
                }
                flag = false;
                str = "";
            }
            else if(s.charAt(i) == ' '){
                continue;
            }
            else {
                str = str + s.charAt(i);
            }
        }
        Integer integer = str.isEmpty() ? 0 : Integer.valueOf(str);
        if(flag == null){
            return res + integer;
        }
        res = flag ? res + integer : res - integer;
        return res;
    }
}
