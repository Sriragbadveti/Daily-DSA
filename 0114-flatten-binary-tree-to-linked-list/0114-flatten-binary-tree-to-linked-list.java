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
    public void flatten(TreeNode root) {
        
        //this is the most optimal solution in 0(1) space -> find the empty space in left hand side of the current's right hand side and then cut and paste and shift this is what entirely you have to be doing...
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode temp = curr.left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}