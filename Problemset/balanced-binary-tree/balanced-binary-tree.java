
// @Title: 平衡二叉树 (Balanced Binary Tree)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-23 16:03:11
// @Runtime: 1 ms
// @Memory: 40.8 MB

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getInfo(root).isBalance;
    }

    public static class Info {
        public boolean isBalance;
        public int height;

        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    
 public Info getInfo(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = getInfo(node.left);
        if (!leftInfo.isBalance){
            return new Info(false,0);
        }
        Info rightInfo = getInfo(node.right);
        if (!rightInfo.isBalance){
            return new Info(false,0);
        }
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean flag = leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(flag, height);
    }
}
