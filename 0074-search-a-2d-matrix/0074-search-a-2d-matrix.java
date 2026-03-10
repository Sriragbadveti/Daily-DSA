class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;//rows
        int m = arr[0].length;//columns
        int start = 0;
        int end = n*m-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            int row_index = mid/m;
            int col_index = mid%m;

            if(arr[row_index][col_index] == target) return true;
            if(arr[row_index][col_index] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}