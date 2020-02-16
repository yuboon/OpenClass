package com.yuboon.springboot.tree.util;

import cn.hutool.core.util.StrUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class TreeNodeMap extends HashMap implements Serializable {

    private static final long serialVersionUID = 8376668307601977428L;

    private TreeNodeConfig treeNodeConfig;

    public TreeNodeMap(){
        this.treeNodeConfig = TreeNodeConfig.getDefaultConfig();
    }

    public TreeNodeMap(TreeNodeConfig treeNodeConfig){
        this.treeNodeConfig = treeNodeConfig;
    }

/*
    // 树节点属性常量
    static final String TREE_ID = "id";
    static final String TREE_NAME = "name";
    static final String TREE_CODE = "code";
    static final String TREE_CHILDREN = "children";
    static final String TREE_PARENT_ID = "parentId";
*/

    public <T> T getId() {
        return (T)super.get(treeNodeConfig.getIdKey());
    }

    public void setId(String id) {
        super.put(treeNodeConfig.getIdKey(), id);
    }

    public <T> T getParentId() {
        return (T)super.get(treeNodeConfig.getParentIdKey());
    }

    public void setParentId(String parentId) {
        super.put(treeNodeConfig.getParentIdKey(), parentId);
    }

    public <T> T getName() {
        return (T)super.get(treeNodeConfig.getNameKey());
    }

    public void setName(String name) {
        super.put(treeNodeConfig.getNameKey(), name);
    }

    public <T> T  getCode() {
        return (T)super.get(treeNodeConfig.getCodeKey());
    }

    public TreeNodeMap setCode(String code) {
        super.put(treeNodeConfig.getCodeKey(), code);
        return this;
    }

    public List<TreeNodeMap> getChildren() {
        return (List<TreeNodeMap>)super.get(treeNodeConfig.getChildrenKey());
    }

    public void setChildren(List<TreeNodeMap> children) {
        super.put(treeNodeConfig.getChildrenKey(),children);
    }

    public void extra(String key,Object value){
        super.put(key,value);
    }


}