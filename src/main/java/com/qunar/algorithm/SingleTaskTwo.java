package com.qunar.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ershu.liang on 2017/7/12.
 */
public class SingleTaskTwo {
    class TreeNode {
        private int val;
        private int curId;
        private List<TreeNode> childList = new ArrayList<>();

        public TreeNode() {
        }

        public boolean isLeaf() {
            if(childList.size() == 0) {
                return true;
            }
            return false;
        }
    }
}
