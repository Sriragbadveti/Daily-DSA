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
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traversal(root);
        return ans;

    }

    public int traversal(TreeNode root){

        if(root == null) return 0;

        //use a post order traversal for this question and for every node calculate max until that node and max including that node

        int left = traversal(root.left);
        int right = traversal(root.right);

        left = Math.max(0 , left);
        right = Math.max(0 , right);

        int pathSum = left+right+root.val;
        ans = Math.max(ans , pathSum);

        return Math.max(left , right)+root.val;
    }
}