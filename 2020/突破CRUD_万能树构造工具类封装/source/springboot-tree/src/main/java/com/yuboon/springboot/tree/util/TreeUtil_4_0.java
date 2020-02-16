package com.yuboon.springboot.tree.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.yuboon.springboot.tree.entity.MenuEntity;

import java.util.List;

/**
 * 树工具类1.0版
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
public class TreeUtil_4_0 {

    public interface Convert<T,TreeNodeMap>{
        public void convert(T object, TreeNodeMap treeNode);
    }

    /**
     * 树构建
     */
    public static <T> List<TreeNodeMap> build(List<T> list,Object parentId,Convert<T,TreeNodeMap> convert){
        List<TreeNodeMap> treeNodes = CollectionUtil.newArrayList();
        for(T obj : list){
            TreeNodeMap treeNode = new TreeNodeMap();
            convert.convert(obj,treeNode);
            treeNodes.add(treeNode);
        }

        List<TreeNodeMap> finalTreeNodes = CollectionUtil.newArrayList();
        for(TreeNodeMap treeNode : treeNodes){
            if(parentId.equals(treeNode.getParentId())){
                finalTreeNodes.add(treeNode);
                innerBuild(treeNodes,treeNode);
            }
        }
        return finalTreeNodes;
    }

    /**
     * 树构建
     */
    public static <T> List<TreeNodeMap> build(List<T> list,Object parentId,TreeNodeConfig treeNodeConfig,Convert<T,TreeNodeMap> convert){
        List<TreeNodeMap> treeNodes = CollectionUtil.newArrayList();
        for(T obj : list){
            TreeNodeMap treeNode = new TreeNodeMap(treeNodeConfig);
            convert.convert(obj,treeNode);
            treeNodes.add(treeNode);
        }

        List<TreeNodeMap> finalTreeNodes = CollectionUtil.newArrayList();
        for(TreeNodeMap treeNode : treeNodes){
            if(parentId.equals(treeNode.getParentId())){
                finalTreeNodes.add(treeNode);
                innerBuild(treeNodes,treeNode);
            }
        }
        return finalTreeNodes;
    }

    private static void innerBuild(List<TreeNodeMap> treeNodes,TreeNodeMap parentNode){
        for(TreeNodeMap childNode : treeNodes){
            if(parentNode.getId().equals(childNode.getParentId())){
                List<TreeNodeMap> children = parentNode.getChildren();
                if(children == null){
                    children = CollectionUtil.newArrayList();
                    parentNode.setChildren(children);
                }
                children.add(childNode);
                childNode.setParentId(parentNode.getId());
                innerBuild(treeNodes,childNode);
            }
        }
    }

    public static void main(String[] args) {
        List<MenuEntity> menuEntityList = CollectionUtil.newArrayList();
        menuEntityList.add(new MenuEntity("1","0","系统管理","sys","/sys"));
        menuEntityList.add(new MenuEntity("11","1","用户管理","user","/sys/user"));
        menuEntityList.add(new MenuEntity("111","11","用户添加","userAdd","/sys/user/add"));
        menuEntityList.add(new MenuEntity("2","0","店铺管理","store","/store"));
        menuEntityList.add(new MenuEntity("21","2","商品管理","shop","/shop"));

        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名
        treeNodeConfig.setCodeKey("number");
        List<TreeNodeMap> treeNodes = TreeUtil_4_0.build(menuEntityList, "0",treeNodeConfig,new TreeUtil_4_0.Convert<MenuEntity, TreeNodeMap>() {
            @Override
            public void convert(MenuEntity object, TreeNodeMap treeNode) {
                treeNode.setId(object.getId());
                treeNode.setParentId(object.getPid());
                treeNode.setCode(object.getCode());
                treeNode.setName(object.getName());
                // 属性扩展
                treeNode.extra("extra1","123");
            }
        });

        Console.log(JSONUtil.formatJsonStr(JSONUtil.toJsonStr(treeNodes)));

    }

}
