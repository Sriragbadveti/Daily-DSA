class Solution {
    public int smallestNumber(int n, int t) {
        for(int i  = n ; i<=n+10 ; i++){
            if(findProd(i)%t==0){
                return i;
            }
        }
        return -1;

    }

    private int findProd(int num){
        int prod = 1;
        while(num>0){
            prod *= num%10;
            if(prod==0)return 0;
            num/=10;
        }
        return prod;
    }
}