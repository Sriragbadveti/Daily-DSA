class Solution {
    int dp[][];
    int squares[];
    public int numSquares(int n) {
        
        List <Integer> sq = new ArrayList<>();
        for(int i  = 1 ; i*i<=n; i++){
            sq.add(i*i);
        }

        squares = new int [sq.size()];
        for( int i = 0 ; i<sq.size() ; i++){
            squares[i] = sq.get(i);
        }

        dp = new int[squares.length+1][n+1];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }

        return traversal( n , 0 ,0 );
    }

    public int traversal( int n , int currSum , int index){

        //base case
        if(currSum == n) return 0;
        if(currSum>n) return 100000;
        if(index == squares.length) return 100000;

        //check cache
        if(dp[index][currSum] != -1) return dp[index][currSum];

        int take = 1+traversal( n, currSum+squares[index] , index);
        int skip = traversal(n , currSum , index+1);

        return dp[index][currSum] = Math.min(take ,skip);
    }
}