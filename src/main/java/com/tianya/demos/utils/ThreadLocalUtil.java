package com.tianya.demos.utils;

/**
 * ThreadLocal 工具类：用于在同一线程内共享数据（如当前登录用户信息）
 */
@SuppressWarnings("all")
public class ThreadLocalUtil {
    // 提供ThreadLocal对象，线程隔离
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    // 获取当前线程存储的值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }

    // 向当前线程存储值
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }

    // 清除ThreadLocal，防止内存泄漏
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
