package com.solution.pointswordtooffer.reconstructionofbinarytree7;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ReconstructionOfBinaryTree
 * @Description 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 *
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @Author
 * @Date 2021/3/9 15:13
 */
public class ReconstructionOfBinaryTree {
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left,
                                int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1,
                preorder_left + size_left_subtree, inorder_left,
                inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder,
                preorder_left + size_left_subtree + 1, preorder_right,
                inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0,
                n - 1, 0, n - 1);
    }
}


class Solution2 {
    // 保存先序遍历
    int[] preorder;
    // 标记中序遍历
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root  当前根节点
     * @param left  中序遍历中左子树边界
     * @param right 中序遍历中右子树边界
     * @return
     */
    TreeNode recur(int root, int left, int right) {
        // 防止越界（在中序遍历中，左子树一定在右子树前面）
        // 相等表示根节点本身
        if (left > right) {
            return null;
        }

        // 新建根节点（初始值即整棵树的根节点由先序遍历给出）
        TreeNode node = new TreeNode(preorder[root]);

        // 划分根节点、左子树、右子树（根据根节点在中序遍历中的位置）
        int i = dic.get(preorder[root]);

        // 开启左子树递归（在先序遍历中，左子树第一个节点紧挨当前根节点后面；
        // 在中序遍历中，左子树最后一个节点在当前根节点的前一个位置）
        node.left = recur(root + 1, left, i - 1);

        // 开启右子树递归（在先序遍历中，右子树第一个节点紧挨左子树最后一个节点后面；
        // 在中序遍历中，右子树第一个节点紧挨当前根节点后面）
        node.right = recur(root + (i - left) + 1, i + 1, right);

        // 回溯返回根节点
        return node;
    }
}
