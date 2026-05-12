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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.offer(root);
        if(root == null){
            return result;
        }
      
        int level = 0;
        while(!queue.isEmpty()){

            Deque<Integer> stage = new LinkedList<>();
            int levelSize = queue.size();

            for(int i = 0 ; i <levelSize ; i++){

                TreeNode currNode = queue.poll();

                if(level % 2 == 0){
                    stage.addLast(currNode.val);
                }else{
                    stage.addFirst(currNode.val);
                }

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }

                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(new ArrayList<>(stage));
            level++;
        }
        return result;
    }
}