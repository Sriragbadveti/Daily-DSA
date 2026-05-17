class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        
        for(int i = 0 ; i<s.length()-1 ; i++){

            char ch = s.charAt(i);
            int digit1 = ch - '0';
            char ch2 = s.charAt(i+1);
            int digit2 = ch2-'0';

            if(Math.abs(digit1 - digit2) > 2){
                return false;
            }
        }
        return true;
        

    }
}