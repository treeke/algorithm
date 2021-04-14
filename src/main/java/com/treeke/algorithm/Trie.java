package com.treeke.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 */
public class Trie {
    Map<Character, Set<String>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Set<String> set = map.get(word.charAt(0));
        if(set == null){
            set = new HashSet<>();
            map.put(word.charAt(0), set);
        }
        set.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Set<String> set = map.get(word.charAt(0));
        return set == null ? false : set.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Set<String> set = map.get(prefix.charAt(0));
        if(set == null){
            return false;
        }
        AtomicBoolean res = new AtomicBoolean(false);
        set.forEach(e->{
            if(e.startsWith(prefix)){
                res.set(true);
                return;
            }
        });
        return res.get();

    }
}
