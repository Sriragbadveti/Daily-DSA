class Solution {
    int dp[][];
    public int countSubstrings(String s) {
        

        //-1 means not computed , 0 means not a palindrome and 1 means it is a palindrome
        dp = new int[s.length()+1][s.length()+1];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        int n = s.length();
        int count= 0 ;
        for(int i = 0 ; i <n ; i++){
            for(int j = i ; j<n ; j++){
                if(isPalindrome(s , i , j) == 1)count++;
            }
        }
        return count;
    }

    public int isPalindrome(String s , int i , int j){

        //base cases
        int n = s.length();
        if(s.length()==1)return 1;
        if(i>=j) return 1;

        //check cache
        if(dp[i][j]!=-1)return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = isPalindrome(s , i+1 , j-1);
        }
    
         return dp[i][j] = 0;

    }
}