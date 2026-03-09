class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        int left = 0;
        int right = arr.length-1;
   

        while(left<=right){


            int mid = (left+right)/2;
            if(arr[mid] == arr[mid+1]){
                int isOdd = mid-left;
                if(isOdd%2==0){
                    left = mid+2;
                }else{
                    right = mid-1;
                }
            }else if(arr[mid] == arr[mid-1]){
                int isOdd = mid-1-left;
                if(isOdd%2==0){
                    left = mid+1;
                }else{
                    right = mid-2;
                }
            }else{
               return arr[mid];
            }
        }
        return -1;
        
    }
}