package com.imooc.dto;

/**
 * @ClassName FileInfo
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 16:55
 * @Version 1.0
 */
public class FileInfo {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileInfo(String path) {
        this.path = path;
    }
}
