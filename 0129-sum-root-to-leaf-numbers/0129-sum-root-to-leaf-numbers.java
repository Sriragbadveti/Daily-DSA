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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        traversal(root , 0);
        return sum;
    }

    public void traversal(TreeNode root , int path){

        if(root == null) return ;

        //we are doing a pre order traversal so lets process the root first and then the left and right subtree
        path = path*10+root.val;
        if(root.left == null && root.right == null){
            sum+=path;
        }

        traversal(root.left , path);
        traversal(root.right , path);
    }
}