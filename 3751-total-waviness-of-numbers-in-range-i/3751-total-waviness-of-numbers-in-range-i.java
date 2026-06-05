class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i = num1 ; i<=num2 ; i++){
            int count = solve(i);
            ans+=count;
        }

        return ans;
    }

    private int solve(int num){
        String s = String.valueOf(num);
        int wavy = 0;
        for(int i = 1 ; i<s.length()-1 ; i++){
            char left = s.charAt(i-1);
            char middle = s.charAt(i);
            char right = s.charAt(i+1);

            if(left<middle && right<middle)wavy++;
            if(left>middle && right>middle) wavy++;
        }

        return wavy;
    }
}