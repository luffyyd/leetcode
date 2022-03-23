
// @Title: 二叉树的层序遍历 (Binary Tree Level Order Traversal)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-23 15:13:24
// @Runtime: 0 ms
// @Memory: 41.6 MB

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left!=null){
                    q.add(cur.left);
                }
                if (cur.right!=null){
                    q.add(cur.right);
                }
                integerList.add(cur.val);
            }
            list.add(integerList);
        }
        return list;
    }
}
