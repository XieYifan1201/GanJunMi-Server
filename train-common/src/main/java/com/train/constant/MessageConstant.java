package com.train.constant;

/**
 * 信息提示常量类
 * 定义系统中使用的各种错误提示和消息常量
 */
public final class MessageConstant {

    /** 密码错误提示 */
    public static final String PASSWORD_ERROR = "密码错误";
    
    /** 账号不存在提示 */
    public static final String ACCOUNT_NOT_FOUND = "账号不存在";
    
    /** 账号或密码错误提示 */
    public static final String USER_NOT_FOUND = "账号或密码输入错误";
    
    /** 账号被锁定提示 */
    public static final String ACCOUNT_LOCKED = "账号被锁定";
    
    /** 未知错误提示 */
    public static final String UNKNOWN_ERROR = "未知错误";
    
    /** 用户未登录提示 */
    public static final String USER_NOT_LOGIN = "用户未登录";
    
    /** 登录失败提示 */
    public static final String LOGIN_FAILED = "登录失败";
    
    /** 文件上传失败提示 */
    public static final String UPLOAD_FAILED = "文件上传失败";
    
    /** 密码修改失败提示 */
    public static final String PASSWORD_EDIT_FAILED = "密码修改失败";
    
    /** 图片资源未找到提示 */
    public static final String NOT_FIND_IMG = "没有该图片资源";

    private MessageConstant() {
        // 防止实例化
    }
}
