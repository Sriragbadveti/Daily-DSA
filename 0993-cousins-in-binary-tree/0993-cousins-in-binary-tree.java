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
    public boolean isCousins(TreeNode root, int x, int y) {

        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (Levels(root , xx , 0) == Levels(root , yy ,0) && !isSiblings(root , xx , yy));
    }

    //This function is specifically to find the particular node which matches the x or y given in the question as an input;

    public TreeNode findNode(TreeNode root, int x) {
        if (root == null)
            return null;

        if (root.val == x) {
            return root;
        }

        TreeNode leftSide = findNode(root.left, x);
        if (leftSide != null) {
            return leftSide;
        }

        return findNode(root.right, x);
    }

    // this function is to specifically find the level of the targetted node

    public int Levels(TreeNode root, TreeNode x, int l) {

        if (root == null)
            return 0;

        if (root == x)
            return l;

        int leftSide = Levels(root.left, x, l + 1);
        if (leftSide != 0)
            return leftSide;

        return Levels(root.right, x, l + 1);
    }

    //This function is to specifically find out if the 2 nodes are siblings or not;

    public boolean isSiblings(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null)
            return false;

        if (root.left == x && root.right == y || root.left == y && root.right == x) {
            return true;
        }

        return (isSiblings(root.left, x, y) || isSiblings(root.right, x, y));
    }
}