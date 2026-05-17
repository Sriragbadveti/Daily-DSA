class Solution {
    public int countKthRoots(int l, int r, int k) {

        //okay to solve this particular question we ll be implementing 2 binary searches to find the lowest valid nuimber and the highest valid number and their difference would be the answer;

        //binary search->1 to find the largest valid element

        int start = 0;
        int end = r;
        int ans1 = -1;
        int ans2 = -1;
        int res = 0;

        while (start <= end) {

            int mid = (start + end) / 2;

            double cube = Math.pow(mid, k);

            if (cube >= l && cube <= r) {
                ans1 = mid;
                start = mid + 1;
            } else if (cube < l) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        //binary search -> 2 for finding the smallest valid number 

        start = 0;
        end = r;

        while (start <= end) {

            int mid = (start + end) / 2;
            double cube = Math.pow(mid, k);
            if (cube >= l && cube <= r) {
                ans2 = mid;
                end = mid - 1;
            } else if (cube < l) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //now find the final answer
        if (ans1 == -1 || ans2 == -1) {
            return 0;
        }
        res = ans1 - ans2 + 1;
        return res;

    }

}