class Solution {
    public int minFlips(String s) {
        
        // so the approach over here is check all combinations all zeroes , all ones , one 1 , and one 1 at both the ends
        int n = s.length();
        int ones = 0;
        for(int i = 0 ; i<n ; i++){
            if(s.charAt(i)=='1')ones++;
        }

        int zeroes = n-ones;

        //all zeroes and ones
        int ans = 0;
        ans = Math.min(ones , zeroes);

        //atleast one 1 we can allow in our string
        ans = Math.min(ans , Math.abs(ones-1));

        //now try for the [1......1] combination
        if(n>1){

            int cost  = 0;
            if(s.charAt(0) == '0')cost++;
            if(s.charAt(0) == '0') cost++;

            for(int i = 1; i<n-1 ;i++){
                if(s.charAt(i) == '1')cost++;
            }
            ans = Math.min(ans , cost);
        }
        return ans;
    }
}