class Solution {
    public int maxDistance(String moves) {
        int dx=0;
        int dy =0;
        int underscore =0;
        // find the absolute distance that was moved 
        for(char c: moves.toCharArray()){
            switch (c){
                    case('U'):dy++;break;
                    case('D'):dy-- ;break;
                    case('L'):dx++;break;
                    case('R'):dx--;break;
                    case('_'):underscore++;break;
            }
        }
        return Math.abs(dy)+Math.abs(dx)+underscore;
    }
}