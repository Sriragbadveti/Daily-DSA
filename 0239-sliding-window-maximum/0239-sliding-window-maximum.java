class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        

        //let's take a monotonic dequeue because its flexible to do operations at first or last ->

        ArrayDeque<Integer> queue = new ArrayDeque();
        int idx = 0;
        int n = arr.length;
        int res[] = new int[n-k+1];
        for(int i = 0 ; i<arr.length ; i++ ){

            //first remove the waste elements which are expired

            while(!queue.isEmpty() && queue.peekFirst()<= i-k){
                queue.pollFirst();
            }

            //remove all the smaller elements
            while(!queue.isEmpty() && arr[queue.peekLast()] < arr[i]){
                queue.pollLast();
            }

            queue.addLast(i);

            //now add in the resultant array only if the size k is satisfied
            if(i>=k-1){
                res[idx++] = arr[queue.peekFirst()];
            }
        }
        return res;
    }
}