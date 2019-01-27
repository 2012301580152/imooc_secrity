package com.imooc.tree.exception;

/**
 * @ClassName UserNotExistException
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 14:43
 * @Version 1.0
 */
public class UserNotExistException extends RuntimeException {
    private static final long serialVersionUID = 4005646477788499170L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
