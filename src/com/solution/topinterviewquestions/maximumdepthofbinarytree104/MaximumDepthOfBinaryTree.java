package com.solution.topinterviewquestions.maximumdepthofbinarytree104;

/**
 * @ClassName MaximumDepthOfBinaryTree
 * @Description 104. Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 * <p>
 * Input: root = []
 * Output: 0
 * Example 4:
 * <p>
 * Input: root = [0]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Author
 * @Date 2021/3/5 14:57
 */
public class MaximumDepthOfBinaryTree {

    static class TreeNode {
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

    /**
     * 初始方法，深度优先遍历，求深度
     * 待优化
     */
    static class Solution {
        public int maxDepth(TreeNode root) {
            return seekDepth(root);
        }

        public int seekDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left != null && root.right != null) {
                int leftDepth = seekDepth(root.left) + 1;
                int rightDepth = seekDepth(root.right) + 1;

                return Math.max(leftDepth, rightDepth);

            } else if (root.left != null && root.right == null) {
                return seekDepth(root.left) + 1;
            } else if (root.left == null && root.right != null) {
                return seekDepth(root.right) + 1;
            } else {
                return 1;
            }
        }
    }

    /**
     * 优化  理清if-else的逻辑
     */
    static class Solution2 {
        public int maxDepth(TreeNode root) {
            return seekDepth(root);
        }

        public int seekDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left != null && root.right == null) {
                return seekDepth(root.left) + 1;
            } else if (root.left == null) {
                return seekDepth(root.right) + 1;
            } else {
                int leftDepth = seekDepth(root.left) + 1;
                int rightDepth = seekDepth(root.right) + 1;
                return Math.max(leftDepth, rightDepth);
            }

        }
    }


    /**
     * 优化  理清递归（遍历）思路：树与子树的关系
     * 根节点不为空==》求左/右节点深度
     * 为什么不用再判断深度为1的情形==》深度为1即为单节点即叶子节点（单根节点也可视为叶子节点）,
     *    而自己在后续处理过程中深度加了1的，所以可以直接在节点为空时返回
     * 为什么可以省去那些复杂的判断==》自己对递归遍历理解不够深：对只有单孩子的节点，其另一孩子为空，程序判断到这里时会返回0，
     *    相当于该孩子子树深度为0
     */
    static class Solution3 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }else {
                int leftDepth = maxDepth(root.left) + 1;
                int rightDepth = maxDepth(root.right) + 1;
                return Math.max(leftDepth, rightDepth);
            }
        }

    }
}
