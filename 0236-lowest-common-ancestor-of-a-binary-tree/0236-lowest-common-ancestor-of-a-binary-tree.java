/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // we are starting a pre order traversal because the root itself can also be the answer so lets process the root first and then the left and right subtree

        
        if(root == null) return null;
        if(root== p || root==q) return root;

        //explore left and right subtree
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        //now if left reaches null then automaticall right becomes the answer else left is the one 
        if(left!=null && right!=null) return root;
        return left==null ? right : left;
    }
}