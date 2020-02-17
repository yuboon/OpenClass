package com.yuboon.springboot.tree.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.yuboon.springboot.tree.entity.MenuEntity;
import com.yuboon.springboot.tree.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 树控制器
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
@RestController
public class TreeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getTreeNodes")
    public List<TreeNode> getTreeNodes(){
        //List<MenuEntity> menuData = jdbcTemplate.query("select * from t_menu", new BeanPropertyRowMapper<>(MenuEntity.class));

        List<MenuEntity> menuEntityList = createMenuEntities();
        List<TreeNode> treeNodes = TreeUtil_2_0.build(menuEntityList, "0", new TreeUtil_2_0.Convert<MenuEntity, TreeNode>() {
            @Override
            public void convert(MenuEntity object, TreeNode treeNode) {
                treeNode.setId(object.getId());
                treeNode.setParentId(object.getPid());
                treeNode.setCode(object.getCode());
                treeNode.setName(object.getName());
            }
        });

        return treeNodes;
    }

    @RequestMapping("/getTreeNodes2")
    public List<TreeNodeMap> getTreeNodes2(){
        List<MenuEntity> menuEntityList = createMenuEntities();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setParentIdKey("pid");
        List<TreeNodeMap> treeNodes = TreeUtil_4_0.build(menuEntityList, "0",treeNodeConfig,new TreeUtil_4_0.Convert<MenuEntity, TreeNodeMap>() {
            @Override
            public void convert(MenuEntity object, TreeNodeMap treeNode) {
                treeNode.setId(object.getId());
                treeNode.setParentId(object.getPid());
                treeNode.setCode(object.getCode());
                treeNode.setName(object.getName());
                treeNode.extra("extra1","123");
            }
        });

        return treeNodes;
    }

    private List<MenuEntity> createMenuEntities() {
        List<MenuEntity> menuEntityList = CollectionUtil.newArrayList();
        menuEntityList.add(new MenuEntity("1", "0", "系统管理", "sys", "/sys"));
        menuEntityList.add(new MenuEntity("11", "1", "用户管理", "user", "/sys/user"));
        menuEntityList.add(new MenuEntity("111", "11", "用户添加", "userAdd", "/sys/user/add"));
        menuEntityList.add(new MenuEntity("2", "0", "店铺管理", "store", "/store"));
        menuEntityList.add(new MenuEntity("21", "2", "商品管理", "shop", "/shop"));
        return menuEntityList;
    }

}
