package com.yuboon.springboot.tree.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;

import java.util.Map;

/**
 * 此处为类介绍
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
public class TreeNodeConfig {

    // 默认属性的单例对象
    private static TreeNodeConfig defaultConfig = new TreeNodeConfig();

    // 树节点默认属性常量
    static final String TREE_ID = "id";
    static final String TREE_NAME = "name";
    static final String TREE_CODE = "code";
    static final String TREE_CHILDREN = "children";
    static final String TREE_PARENT_ID = "parentId";

//    static {
//        defaultConfig = new TreeNodeConfig();
//        defaultConfig.setIdKey(TREE_ID);
//        defaultConfig.setCodeKey(TREE_CODE);
//        defaultConfig.setNameKey(TREE_NAME);
//        defaultConfig.setChildrenKey(TREE_CHILDREN);
//        defaultConfig.setParentIdKey(TREE_PARENT_ID);
//    }

    // 属性
    private String idKey;
    private String codeKey;
    private String nameKey;
    private String childrenKey;
    private String parentIdKey;

    public String getIdKey() {
        return getOrDefault(idKey,TREE_ID);
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    public String getCodeKey() {
        return getOrDefault(codeKey,TREE_CODE);
    }

    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    public String getNameKey() {
        return getOrDefault(nameKey,TREE_NAME);
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getChildrenKey() {
        return getOrDefault(childrenKey,TREE_CHILDREN);
    }

    public void setChildrenKey(String childrenKey) {
        this.childrenKey = childrenKey;
    }

    public String getParentIdKey() {
        return getOrDefault(parentIdKey,TREE_PARENT_ID);
    }

    public void setParentIdKey(String parentIdKey) {
        this.parentIdKey = parentIdKey;
    }

    public String getOrDefault(String key,String defaultKey){
        if(key == null) {
            return defaultKey;
        }
        return key;
    }

    public static TreeNodeConfig getDefaultConfig(){
        return defaultConfig;
    }

}
