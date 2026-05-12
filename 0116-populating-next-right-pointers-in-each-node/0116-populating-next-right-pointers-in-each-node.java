/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null){
            return root;
        }
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0 ; i<levelSize ;i ++) {

                Node curr = queue.poll();

                if(i!=levelSize-1){
                    curr.next = queue.peek();

                }else{
                    curr.next = null;
                }

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            
        }
        return root;
    }
}