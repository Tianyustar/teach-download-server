package com.teach.download.demo.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author libre
 * @since 2019-11-09
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String id;
    private String path;
    private String type;
    private String url;
    private String parentId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Node{" +
        ", name=" + name +
        ", id=" + id +
        ", path=" + path +
        ", type=" + type +
        ", url=" + url +
        ", parentId=" + parentId +
        "}";
    }
}
