class Solution {
    public int minimumIndex(int[] arr, int itemSize) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int curr = 0;
        int ans = -1;
        for(int i = 0 ; i<n ; i++){
            if(arr[i] >= itemSize){
                curr = arr[i];

               if(curr<min){
                min = curr;
                ans = i;
               }

            }

        }
        return ans;
    }
}