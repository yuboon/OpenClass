package com.yuboon.springboot.tree.tree;

import com.yuboon.springboot.tree.util.TreeNode;

/**
 * 菜单实体扩展的树节点
 *
 * @author yuboon
 * @version v1.0
 * @date 2020/02/09
 */
public class MenuEntityTreeNode extends TreeNode {

    // 扩展备注属性
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
