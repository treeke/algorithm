package com.treeke.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 */
public class NestedIterator implements Iterator<Integer> {
    public static void main(String[] args) {
        NestedIntegerImpl nestedInteger1 = new NestedIntegerImpl(1);
        NestedIntegerImpl nestedInteger2 = new NestedIntegerImpl(2);
        ArrayList<NestedInteger> list1 = new ArrayList<>();
        list1.add(nestedInteger1);
        list1.add(nestedInteger1);
        NestedIntegerImpl nestedInteger4 = new NestedIntegerImpl(list1);
        ArrayList<NestedInteger> list3 = new ArrayList<>();
        list3.add(nestedInteger4);
        list3.add(nestedInteger2);
        list3.add(nestedInteger4);

        /*ArrayList<NestedInteger> list1 = new ArrayList<>();
        ArrayList<NestedInteger> list2 = new ArrayList<>();
        NestedIntegerImpl nestedInteger1 = new NestedIntegerImpl(list1);
        list2.add(nestedInteger1);
        NestedIntegerImpl nestedInteger2 = new NestedIntegerImpl(list2);
        ArrayList<NestedInteger> list3 = new ArrayList<>();
        list3.add(nestedInteger2);*/

        NestedIterator nestedIterator = new NestedIterator(list3);
        while (nestedIterator.hasNext()){
            System.out.println(nestedIterator.next());
        }
    }
    List<NestedInteger> nestedList;
    NestedIterator nextIterator;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.index = 0;
    }

    @Override
    public Integer next() {
        NestedInteger nestedInteger = nestedList.get(index);
        if(nestedInteger == null){
            index++;
            return null;
        }
        if(nestedInteger.isInteger()){
            index++;
            return nestedInteger.getInteger();
        }
        nextIterator = nextIterator == null ? new NestedIterator(nestedInteger.getList()) : nextIterator;
        if(nextIterator.hasNext()){
            return nextIterator.next();
        }
        return next();
    }
    @Override
    public boolean hasNext() {
        if(nestedList == null || nestedList.size() <= index){
            return false;
        }
        if(nextIterator != null){
            if(!nextIterator.hasNext()){
                index++;
                nextIterator = null;
                return hasNext();
            }
            return true;
        }
        if(!nestedList.get(index).isInteger()){
            if(nestedList.get(index).getList().isEmpty()){
                index++;
                return hasNext();
            }
            nextIterator = new NestedIterator(nestedList.get(index).getList());
            return hasNext();
        }
        return true;
    }
}

interface NestedInteger {
    //return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}
class NestedIntegerImpl implements NestedInteger{
    Integer value;
    List<NestedInteger> list;
    public NestedIntegerImpl(Integer value) {
        this.value = value;
    }
    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
    }
    @Override
    public boolean isInteger() {
        return value != null;
    }
    @Override
    public Integer getInteger() {
        return value;
    }
    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
