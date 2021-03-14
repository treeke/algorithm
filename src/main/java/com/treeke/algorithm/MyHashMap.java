package com.treeke.algorithm;

public class MyHashMap {

    int size = 16;

    Object[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Object[(int)Math.pow(10,6)];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(key >= arr.length){
            resize(key);
        }
        arr[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(key >= size){
            return -1;
        }
        Object object = arr[key];
        return object == null ? -1 : (int)arr[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(key >= size){
            return;
        }
        arr[key] = null;
    }

    public void resize(int size){
        Object[] target = new Object[size + 1];
        System.arraycopy(arr, 0, target, 0, this.size);
        arr = target;
        this.size = size + 1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */