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
    Queue<TreeNode> queue  = new LinkedList<>();
    public void flatten(TreeNode root) {
        //Solving in the most brute force solution using a queue

        if(root == null) return ;
        traversal(root);

        TreeNode curr = queue.poll();
        while(!queue.isEmpty()){
            curr.left = null;
            curr.right = queue.poll();
            curr = curr.right;
        }
    }

    public void traversal(TreeNode root){

        if(root == null) return ;
        queue.offer(root);

        traversal(root.left);
        traversal(root.right);
    }
}