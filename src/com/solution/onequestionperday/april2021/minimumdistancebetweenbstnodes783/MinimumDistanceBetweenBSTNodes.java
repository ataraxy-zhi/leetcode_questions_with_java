package com.solution.onequestionperday.april2021.minimumdistancebetweenbstnodes783;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MinimumDistanceBetweenBSTNodes
 * @Description 783. Minimum Distance Between BST Nodes
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 105
 * <p>
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/4/13 8:23
 */
public class MinimumDistanceBetweenBSTNodes {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        search(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                min = Math.min(min, Math.abs(list.get(i) - list.get(j)));
            }
        }

        return min;
    }

    public void search(TreeNode root) {
        if (root != null) {
            list.add(root.val);
        } else {
            return;
        }

        search(root.left);
        search(root.right);
    }
}


