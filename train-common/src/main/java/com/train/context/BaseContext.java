package com.train.context;

/**
 * 用户上下文工具类
 * 使用ThreadLocal存储当前登录用户的ID，保证线程隔离
 */
public final class BaseContext {

    /** 存储当前用户ID的线程局部变量 */
    private static final ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal<>();

    private BaseContext() {
        // 防止实例化
    }

    /**
     * 设置当前用户ID
     * @param id 用户ID
     */
    public static void setCurrentId(Long id) {
        THREAD_LOCAL.set(id);
    }

    /**
     * 获取当前用户ID
     * @return 用户ID
     */
    public static Long getCurrentId() {
        return THREAD_LOCAL.get();
    }

    /**
     * 移除当前用户ID，防止内存泄漏
     */
    public static void removeCurrentId() {
        THREAD_LOCAL.remove();
    }
}
