package com.treeke.algorithm;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Unsafe 绕过构造方法直接生成对象
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        
        A o1 = new A(); // constructor
        long a = o1.a(); // prints 1
        System.out.println(a);
        A o2 = A.class.newInstance(); // reflection
        long b = o2.a(); // prints 1
        System.out.println(b);
        A o3 = (A) unsafe.allocateInstance(A.class); // unsafe
        long c = o3.a(); // prints 0
        System.out.println(c);
    }

    static class A {
        private long a; // not initialized value, default 0
        public A() {
            this.a = 1; // initialization
        }
        public long a() {
            return this.a;
        }
    }
}
