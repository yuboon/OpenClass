package com.yuboon.springboot.tree.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.json.JSONUtil;
import com.yuboon.springboot.tree.entity.MenuEntity;
import com.yuboon.springboot.tree.tree.MenuEntityTreeNode;

import java.util.List;

/**
 * 树工具类-属性可扩展
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
public class TreeUtil_3_0 {

    public interface Convert<T,E>{
        public void convert(T object, E treeNode);
    }

    /**
     * 树构建
     */
    public static <T,E extends TreeNode> List<E> build(List<T> list,Object parentId,Class<E> treeNodeClass,Convert<T,E> convert){
        List<E> treeNodes = CollectionUtil.newArrayList();
        for(T obj : list){
            E treeNode = (E)ReflectUtil.newInstance(treeNodeClass);
            convert.convert(obj, treeNode);
            treeNodes.add(treeNode);
        }

        List<E> finalTreeNodes = CollectionUtil.newArrayList();
        for(E treeNode : treeNodes){
            if(parentId.equals(treeNode.getParentId())){
                finalTreeNodes.add((E)treeNode);
                innerBuild(treeNodes,treeNode);
            }
        }
        return finalTreeNodes;
    }

    private static void innerBuild(List<? extends TreeNode> treeNodes,TreeNode parentNode){
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
        List<MenuEntityTreeNode> treeStructureNodes = TreeUtil_3_0.build(menuEntityList, "0",MenuEntityTreeNode.class,new TreeUtil_3_0.Convert<MenuEntity,MenuEntityTreeNode>(){

            @Override
            public void convert(MenuEntity object, MenuEntityTreeNode treeNode) {
                treeNode.setId(object.getId());
                treeNode.setParentId(object.getPid());
                treeNode.setCode(object.getCode());
                treeNode.setName(object.getName());
                treeNode.setLinkUrl(object.getUrl());
                treeNode.setRemark("添加备注属性");
            }
        });

        Console.log(JSONUtil.formatJsonStr(JSONUtil.toJsonStr(treeStructureNodes)));
    }

}
