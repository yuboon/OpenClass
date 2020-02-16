package com.yuboon.springboot.tree.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.yuboon.springboot.tree.entity.MenuEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 树工具类-泛型改造
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
public class TreeUtil_2_0 {

    public interface Convert<T,TreeNode>{
        public void convert(T object,TreeNode treeNode);
    }

    /**
     * 树构建
     */
    public static <T> List<TreeNode> build(List<T> list,Object parentId,Convert<T,TreeNode> convert){
        List<TreeNode> treeNodes = CollectionUtil.newArrayList();
        for(T obj : list){
            TreeNode treeNode = new TreeNode();
            convert.convert(obj,treeNode);
            treeNodes.add(treeNode);
        }

        List<TreeNode> finalTreeNodes = CollectionUtil.newArrayList();
        for(TreeNode treeNode : treeNodes){
            if(parentId.equals(treeNode.getParentId())){
                finalTreeNodes.add(treeNode);
                innerBuild(treeNodes,treeNode);
            }
        }
        return finalTreeNodes;
    }

    private static void innerBuild(List<TreeNode> treeNodes,TreeNode parentNode){
        for(TreeNode childNode : treeNodes){
            if(parentNode.getId().equals(childNode.getParentId())){
                List<TreeNode> children = parentNode.getChildren();
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
        // 1、模拟菜单数据
        List<MenuEntity> menuEntityList = CollectionUtil.newArrayList();
        menuEntityList.add(new MenuEntity("1","0","系统管理","sys","/sys"));
        menuEntityList.add(new MenuEntity("11","1","用户管理","user","/sys/user"));
        menuEntityList.add(new MenuEntity("111","11","用户添加","userAdd","/sys/user/add"));
        menuEntityList.add(new MenuEntity("2","0","店铺管理","store","/store"));
        menuEntityList.add(new MenuEntity("21","2","商品管理","shop","/shop"));

        // 2、树结构构建
        List<TreeNode> treeStructureNodes = TreeUtil_2_0.build(menuEntityList, "0", new Convert<MenuEntity,TreeNode>(){
            @Override
            public void convert(MenuEntity menuEntity, TreeNode treeNode) {
                treeNode.setId(menuEntity.getId());
                treeNode.setParentId(menuEntity.getPid());
                treeNode.setCode(menuEntity.getCode());
                treeNode.setName(menuEntity.getName());
                treeNode.setLinkUrl(menuEntity.getUrl());
            }
        });

        Console.log(JSONUtil.formatJsonStr(JSONUtil.toJsonStr(treeStructureNodes)));
    }

}
