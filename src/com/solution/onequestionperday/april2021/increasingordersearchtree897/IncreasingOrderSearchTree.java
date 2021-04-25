package com.solution.onequestionperday.april2021.increasingordersearchtree897;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IncreasingOrderSearchTree
 * @Description 897. Increasing Order Search Tree
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 100].
 * 0 <= Node.val <= 1000
 * <p>
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author yi
 * @Date 2021/4/25 11:16
 */
public class IncreasingOrderSearchTree {
}

/**
 * 本方法，将中序遍历得到的值保存下来
 */
class Solution {

    TreeNode res = new TreeNode();

    List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        midOrder(root);

        TreeNode tree = new TreeNode();
        TreeNode p = tree;
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                p.val = list.get(i);
                p.right = new TreeNode();
                p = p.right;
            } else {
                p.val = list.get(i);
            }

        }

        return tree;
    }

    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        increasingBST(root.left);
        list.add(root.val);
        increasingBST(root.right);
    }
}

/**
 * 优化
 */
class Solution2 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
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