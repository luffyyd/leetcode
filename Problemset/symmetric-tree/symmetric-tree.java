
// @Title: 对称二叉树 (Symmetric Tree)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-22 20:29:26
// @Runtime: 0 ms
// @Memory: 39.6 MB

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
    public boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root,root);
    }

    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        }
        return p.val == q.val && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }
}
