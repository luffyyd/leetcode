
// @Title: 路径总和 II (Path Sum II)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-23 18:00:04
// @Runtime: 1 ms
// @Memory: 42.1 MB

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        process(root, 0, targetSum, path, ans);
        return ans;
    }

    public static void process(TreeNode root, int preSum, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (preSum + root.val == sum) {
                path.add(root.val);
                ans.add(copy(path));
                path.remove(path.size()-1);
                return;
            }
        }
        preSum += root.val;
        path.add(root.val);
        if (root.left != null) {
            process(root.left, preSum, sum, path, ans);
        }
        if (root.right != null) {
            process(root.right, preSum, sum, path, ans);
        }
        path.remove(path.size()-1);
    }
    
    public static List<Integer> copy(List<Integer> path){
        List<Integer> copy = new ArrayList<>();
        for (Integer integer : path) {
            copy.add(integer);
        }
        return copy;
    }
}
