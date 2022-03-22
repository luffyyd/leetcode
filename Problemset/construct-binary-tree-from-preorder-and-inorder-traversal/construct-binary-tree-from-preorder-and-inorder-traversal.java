
// @Title: 从前序与中序遍历序列构造二叉树 (Construct Binary Tree from Preorder and Inorder Traversal)
// @Author: luffyyy@vip.qq.com
// @Date: 2022-03-22 22:48:26
// @Runtime: 1 ms
// @Memory: 40.7 MB

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        int length = preorder.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            hashMap.put(inorder[i], i);
        }
        return getNodes(preorder, 0, length - 1, inorder, 0, length - 1, hashMap);
    }

    public TreeNode getNodes(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> hashMap) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = hashMap.get(pre[L1]);
        head.left = getNodes(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, hashMap);
        head.right = getNodes(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, hashMap);
        return head;
    }

}
