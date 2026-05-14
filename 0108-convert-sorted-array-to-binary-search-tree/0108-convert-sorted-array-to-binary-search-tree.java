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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBst(nums , 0 , nums.length-1);

    }
    public TreeNode buildBst(int[] nums , int start , int end){

        if(start > end){
            return null;
        }
        //first find the mid in the arrya using binary search
        int mid = (start+end)/2;

        //now build towards the left and right hand side of the array
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBst(nums , start , mid-1 );
        node.right = buildBst(nums , mid+1 , end);
        return node;
    } 
}