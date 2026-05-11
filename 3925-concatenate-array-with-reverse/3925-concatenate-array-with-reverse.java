class Solution {
    public int[] concatWithReverse(int[] arr) {
        //this is going to be the brute-force approach 
        int n = arr.length;
        int res[] = new int[2*n];

        for(int i = 0 ; i<n ;i++){
            res[i] = arr[i];
        }
        int j = n;
        for(int i = n-1; i>=0 ;i--){
            res[j++] = arr[i];

        }
        return res;
    }
}