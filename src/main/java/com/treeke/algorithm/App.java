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
        /*A o1 = new A(); // constructor
        long a = o1.a(); // prints 1
        System.out.println(a);
        A o2 = A.class.newInstance(); // reflection
        long b = o2.a(); // prints 1
        System.out.println(b);
        A o3 = (A) unsafe.allocateInstance(A.class); // unsafe
        long c = o3.a(); // prints 0
        System.out.println(c);*/
        
        /*long intClassAddress = normalize(getUnsafe().getInt(new Integer(0), 4L));
        long strClassAddress = normalize(getUnsafe().getInt("", 4L));
        getUnsafe().putAddress(intClassAddress + 36, strClassAddress);
        String str = (String)(Object)new Integer(1);
        System.out.println(str);*/
        
        
        Guard guard = new Guard();
        System.out.println(guard.giveAccess());   // false, no access

        // bypass
        Unsafe unsafe = getUnsafe();
        Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard, unsafe.objectFieldOffset(f), 42); // memory corruption

        System.out.println(guard.giveAccess()); // true, access granted
        System.out.println(sizeOf(guard));
    }
	
	private static long normalize(int value) {
		    if(value >= 0) return value;
		    return (~0L >>> 64) & value;
		}

	public static long sizeOf(Object object){
		System.out.println(normalize(getUnsafe().getInt(object, 8L)) + 32L);
	    return getUnsafe().getAddress(
	        normalize(getUnsafe().getInt(object, 8L)) + 32L);
	}
	
	public static Unsafe getUnsafe() {
        try {
            Field singletonInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singletonInstanceField.setAccessible(true);
            return (Unsafe) singletonInstanceField.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
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
    
    static class Guard {
        private int ACCESS_ALLOWED = 1;

        public boolean giveAccess() {
               return 42 == ACCESS_ALLOWED;
        }
 }
}
