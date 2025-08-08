package com.ryan;


/**
 * @author wenshuiqing
 * @description 主方法
 * @date 2025-08-08 14:28
 */
public class Main {

    public static void main(String[] args) {
        DfaTree tree = new DfaTree();
        tree.addWord("hello");
        tree.addWord("world");
        System.out.println(tree.contains("hello"));
    }

}
