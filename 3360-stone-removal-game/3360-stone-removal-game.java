class Solution {
    public boolean canAliceWin(int n) {
        int num = 10;
        boolean aliceTurn = true;
        while(n>=num){
            n = n-num;
            num--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}