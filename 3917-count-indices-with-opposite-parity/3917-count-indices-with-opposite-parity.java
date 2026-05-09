class Solution {
    public int[] countOppositeParity(int[] arr) {
        int n = arr.length;
        int oddCount  = 0;
        int evenCount  = 0;
        int res[] = new int[n];

        for(int i = n-1; i>=0 ; i--){
            if(arr[i]%2==0){
                res[i] = oddCount;
                evenCount++;
            }else{
                res[i] = evenCount;
                oddCount++;
            }
        }
        return res;
        
    }
}