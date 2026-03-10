class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        char ans = letters[0];
        int left = 0;
        int right = n-1;

        while(left<right){

            int mid = left+(right-left)/2;

            if(letters[mid] > target){
                ans = letters[mid];
                right = mid;
            }else if(letters[mid]<=target){
                left = mid+1;
            }
        }
         if(letters[left] > target) return letters[left];
        return ans;
    }
}