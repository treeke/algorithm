package com.treeke.algorithm.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiffList {

    public static void main(String[] args) {
        DiffList diffList = new DiffList();
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(5);
        ArrayList<Integer> oldList = new ArrayList<>();
        oldList.add(3);
        oldList.add(4);
        oldList.add(5);
        oldList.add(6);
        oldList.add(7);
        diffList.diffList(newList, oldList);
    }

    public void diffList(List<Integer> newList, List<Integer> oldList){
        //stream实现
        List<Integer> inserList = newList.stream().filter(integer -> !oldList.contains(integer)).collect(Collectors.toList());
        System.out.print("inserList:");
        inserList.forEach(integer -> System.out.print(integer));
        List<Integer> updateList = newList.stream().filter(oldList::contains).collect(Collectors.toList());
        System.out.print("\nupdateList:");
        updateList.forEach(integer -> System.out.print(integer));
        List<Integer> deleteList = oldList.stream().filter(integer -> !newList.contains(integer)).collect(Collectors.toList());
        System.out.print("\ndeleteList:");
        deleteList.forEach(integer -> System.out.print(integer));
    }
}
