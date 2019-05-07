package com.fenghua.common.pojo;

import java.io.Serializable;

/**
 * 选择类目时返回的pojo
 */
public class EasyUITreeNode implements Serializable {

    private Long id; //子节点id
    private String text; //子节点名称
    private String state; //子节点状态.open(展开状态:无子节点)   closed(闭合状态:有子节点)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
