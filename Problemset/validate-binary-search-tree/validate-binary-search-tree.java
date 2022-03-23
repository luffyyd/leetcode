
// @Title: 验证二叉搜索树 (Validate Binary Search Tree)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-23 16:49:35
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
    public boolean isValidBST(TreeNode root) {
        return getInfo(root).isValidBST;
    }

    public static class Info{
        public boolean isValidBST;
        public int max;
        public int min;

        public Info(boolean isValidBST, int max, int min) {
            this.isValidBST = isValidBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info getInfo(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = getInfo(root.left);
        Info rightInfo = getInfo(root.right);

       int max = root.val;
        int min = root.val;
        boolean isValidBST = true;
        if (leftInfo!=null){
            max = Math.max(max,leftInfo.max);
            min = Math.min(min,leftInfo.min);
            isValidBST = leftInfo.isValidBST;
        }
        if (rightInfo!=null){
            max = Math.max(max,rightInfo.max);
            min = Math.min(min,rightInfo.min);
            isValidBST = (isValidBST && rightInfo.isValidBST);
        }
    
        boolean leftIsValid = leftInfo == null || (leftInfo.max < root.val);
        boolean rightIsValid = rightInfo == null || (rightInfo.min > root.val);
        if(!leftIsValid||!rightIsValid){
            isValidBST = false;
        }
        return new Info(isValidBST,max,min);
    }
}
