class Solution {
    public boolean searchMatrix(int[][] arr, int target) {

        int rows = arr.length;
        int cols = arr[0].length;

        for(int i = 0; i < rows; i++){

            if(arr[i][0] <= target && target <= arr[i][cols-1]){

                int start = 0;
                int end = cols-1;

                while(start <= end){

                    int mid = start + (end-start)/2;

                    if(arr[i][mid] == target) return true;

                    if(arr[i][mid] < target)
                        start = mid+1;
                    else
                        end = mid-1;
                }
            }
        }

        return false;
    }
}