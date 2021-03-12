package com.treeke.algorithm;

/**
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 */
public class IsValidSerialization {

    public static void main(String[] args) {
        IsValidSerialization isValidSerialization = new IsValidSerialization();
        //boolean validSerialization = isValidSerialization.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        //boolean validSerialization = isValidSerialization.isValidSerialization("#,#,#");
        //boolean validSerialization = isValidSerialization.isValidSerialization("1");
        //boolean validSerialization = isValidSerialization.isValidSerialization("1,#");
        //boolean validSerialization = isValidSerialization.isValidSerialization("91,13,14,#,#,10");
        boolean validSerialization = isValidSerialization.isValidSerialization("9,#,92,#,#");
        System.out.println(validSerialization);
    }

    int index = 0;
    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        if(split[0].equals("#")){
            if(split.length != 1){
                return false;
            }
            return true;
        }
        if(split.length < 2 || split.length % 2 == 0){
            return false;
        }
        boolean ergodic = ergodic(split);
        if(index + 1 != split.length){
            return false;
        }
        return ergodic;
    }

    private boolean ergodic(String[] split) {
        boolean left;
        boolean right;
        if(split[index + 1].equals("#")){
            left = true;
            index++;
        }else {
            index++;
            left = ergodic(split);
        }
        if(split[index+1].equals("#")){
            right = true;
            index++;
        }else {
            index++;
            right = ergodic(split);
        }
        return left && right;
    }
}


