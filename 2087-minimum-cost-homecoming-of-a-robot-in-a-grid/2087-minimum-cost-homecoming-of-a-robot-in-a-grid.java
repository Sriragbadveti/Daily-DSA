class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        //easy greedy solution

        int startRow = startPos[0];
        int homeRow = homePos[0];
        int ans = 0;
        while (startRow != homeRow) {
            if (startRow < homeRow) {
                startRow++;
                ans += rowCosts[startRow];
            } else {
                startRow--;
                ans += rowCosts[startRow];
            }
        }

        int startCol = startPos[1];
        int homeCol = homePos[1];
        while (startCol != homeCol) {

            if (startCol < homeCol) {
                startCol++; // move right
                ans += colCosts[startCol];
            } else {
                startCol--; // move left
                ans += colCosts[startCol];
            }
        }
        return ans;
    }
}