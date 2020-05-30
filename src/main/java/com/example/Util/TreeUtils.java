package com.example.Util;

import com.example.entity.Menu;
import com.example.entity.MsTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Project: management_system
 * @Package: com.example.Util
 * @Author: 周博义
 * @Date: Created in 2020/5/30 10:55
 */
//树状菜单工具类
public class TreeUtils {

    /**
     * 根据父节点的ID获取所有子节点
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public static List<MsTree> getChildPerms(List<Menu> list, int parentId) {
        List<MsTree> returnList = new ArrayList<MsTree>();
        for (Menu menu : list) {
            //一、根据传入的某个父节点ID，遍历该父节点的所有子节点
            if (menu.getParentId() == parentId) {
                MsTree tree = fromMenuToTree(menu);
                //开始递归，把所有菜单和当前菜单放入
                recursionFn(list, tree);
                returnList.add(tree);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     * @param list
     * @param tree
     */
    private static void recursionFn(List list, MsTree tree) {
        //得到t的子节点列表
        List<MsTree> childList = getChildList(list, tree);
        tree.setChildren(childList);
        for (MsTree treeChild :childList) {
            if (hasChild(list, treeChild)) {
                //判断是否有子节点
                Iterator<MsTree> it = childList.iterator();
                while (it.hasNext()) {
                    MsTree next = it.next();
                    recursionFn(list, next);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<MsTree> getChildList(List<Menu> list, MsTree tree) {
        List<MsTree> treeList = new ArrayList<MsTree>();
        Iterator<Menu> it = list.iterator();
        while (it.hasNext()) {
            Menu menu = (Menu) it.next();
            if (menu.getParentId() == tree.getId()) {
                MsTree msTree = fromMenuToTree(menu);
                treeList.add(msTree);
            }
        }
        return treeList;
    }

    /**
     * 判断是否有子节点
     */
    private static boolean hasChild(List<Menu> list, MsTree tree) {
        int size = getChildList(list, tree).size();
        if (size > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将menu对象转换成tree对象
     * @param menu
     * @return
     */
    private static MsTree fromMenuToTree(Menu menu) {
        //构造tree对象
        MsTree tree = new MsTree();
        tree.setId(menu.getMenuId());
        tree.setTitle(menu.getMenuName());
        tree.setChecked(false);
        tree.setUrl(menu.getUrl());
        return tree;
    }
}
