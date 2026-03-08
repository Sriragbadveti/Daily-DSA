class Solution {
    public int smallestBalancedIndex(int[] arr) {
        int n = arr.length;
        long suff[] = new long[arr.length];
        suff[suff.length - 1] = 1;
        long leftSum = 0;
        long totalSum = 0;

        //first calculate the total sum
        for(int i = 0; i<n;i++){
            totalSum+=arr[i];
        }

        //build the suffix array
        for (int i = n - 2; i >= 0; i--) {

            if(arr[i+1] == 0)suff[i] = 0;
            if (suff[i + 1] > totalSum / arr[i + 1]) {
                suff[i] = totalSum + 1;
            } else {
                suff[i] = suff[i + 1] * arr[i + 1];
            }
        }

        //now compute the entire sum
        for (int i = 0; i < n; i++) {
            if (leftSum == suff[i])
                return i;

            leftSum += arr[i];
        }
        return -1;
    }
}