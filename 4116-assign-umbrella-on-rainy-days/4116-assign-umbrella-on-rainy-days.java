class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String ans[] = new String[n];
        int aliceCount  = 0;
        int bobCount  = 0;
        for(int i  = 0 ; i<n ; i++){
            if(rain[i] == 0){
                ans[i] = "None";
                continue;
            }

            boolean needA = (i+1 < n && rain[i+1] == 1);

            if(needA && aliceCount<=bobCount){
                ans[i] = "Alice";
                aliceCount++;
            }else{
                ans[i] = "Bob";
                bobCount++;
            }
        }
        return ans;
    }
}