package com.ryan;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wenshuiqing
 * @description
 * @date 2025-08-08 14:39
 */
@SuppressWarnings("rawtypes")
public class DfaTree {

    private final Map<Character, Map> tree;

    private static final char END = '!';

    public DfaTree() {
        this.tree = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        Map<Character, Map> tree = this.tree;
        char[] charArray = word.toCharArray();

        Map<Character, Map> curNode = tree;
        for (char c : charArray) {
            curNode = curNode.computeIfAbsent(c, k -> new HashMap<>());
        }
        curNode.put(END, null);
    }

    @SuppressWarnings("unchecked")
    public boolean contains(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        char[] charArray = word.toCharArray();
        Map<Character, Map> curNode = tree;
        for (char c : charArray) {
            curNode = curNode.get(c);
            if (curNode == null) {
                return false;
            }
        }
        return checkEnd(curNode);
    }

    private boolean checkEnd(Map<Character, Map> node) {
        return node.containsKey(END);
    }

}
