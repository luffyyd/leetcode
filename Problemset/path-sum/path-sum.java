
// @Title: 路径总和 (Path Sum)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-23 17:14:55
// @Runtime: 0 ms
// @Memory: 41.1 MB

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
    public static boolean isSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, targetSum);
        return isSum;
    }

    public static void process(TreeNode root, int preSum, int sum) {
        if(isSum){
            return;
        }
        if (root.left == null && root.right == null) {
            if (preSum + root.val == sum) {
                isSum = true;
                return;
            }
        }
        preSum += root.val;
        if (root.left != null) {
            process(root.left, preSum, sum);
        }
        if (root.right != null) {
            process(root.right, preSum, sum);
        }
    }
}
