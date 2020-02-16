package com.yuboon.springboot.tree.util;

import cn.hutool.core.collection.CollectionUtil;
import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * 树节点
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
public class TreeNode {

    // 树节点ID
    private String id;

    // 树节点名称
    private String name;

    // 树节点编码
    private String code;

    // 树节点链接
    private String linkUrl;

    // 树节点图标
    private String icon;

    // 父节点ID
    private String parentId;

    private List<TreeNode> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

}
