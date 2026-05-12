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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>  result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null){
            return result;
        }

       
       

        while(!queue.isEmpty()){
            double average = 0;
            double sum = 0;
            int level = queue.size();
            int counter = 0;
            for(int i = 0 ; i<level ; i++){

                TreeNode curr = queue.poll();
                sum+=curr.val;
                counter++;

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null ){
                    queue.offer(curr.right);
                }
            }

            average = sum/counter;
            result.add(average);
        }
        return result;
    }
}