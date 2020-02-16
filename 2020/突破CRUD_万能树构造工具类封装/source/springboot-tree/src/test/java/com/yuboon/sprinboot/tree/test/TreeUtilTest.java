package com.yuboon.sprinboot.tree.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.yuboon.springboot.tree.entity.MenuEntity;
import com.yuboon.springboot.tree.util.TreeNode;
import com.yuboon.springboot.tree.util.TreeUtil_2_0;

import java.util.List;

/**
 * 此处为类介绍
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
public class TreeUtilTest {

    public static void main(String[] args) {

        List<MenuEntity> menuEntityList = CollectionUtil.newArrayList();
        menuEntityList.add(new MenuEntity("1","0","系统管理","sys","/sys"));
        menuEntityList.add(new MenuEntity("11","1","用户管理","user","/sys/user"));
        menuEntityList.add(new MenuEntity("111","11","用户添加","userAdd","/sys/user/add"));
        menuEntityList.add(new MenuEntity("2","0","店铺管理","store","/store"));
        menuEntityList.add(new MenuEntity("21","2","商品管理","shop","/shop"));

        List<TreeNode> treeNodes = TreeUtil_2_0.build(menuEntityList, "1", new TreeUtil_2_0.Convert<MenuEntity, TreeNode>() {
            @Override
            public void convert(MenuEntity object, TreeNode treeNode) {
                treeNode.setId(object.getId());
                treeNode.setParentId(object.getPid());
                treeNode.setCode(object.getCode());
                treeNode.setName(object.getName());
            }
        });

        Console.log(JSONUtil.toJsonStr(treeNodes));
    }
}
