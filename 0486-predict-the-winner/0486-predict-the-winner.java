class Solution {

    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, true);
    }

    private boolean solve(int[] nums, int i, int j,
                          int p1, int p2,
                          boolean turn) {

        if (i > j) {
            return p1 >= p2;
        }

        if (turn) {

            boolean left = solve(nums, i + 1, j,
                    p1 + nums[i], p2, false);

            boolean right = solve(nums, i, j - 1,
                    p1 + nums[j], p2, false);

            return left || right;

        } else {

            boolean left = solve(nums, i + 1, j,
                    p1, p2 + nums[i], true);

            boolean right = solve(nums, i, j - 1,
                    p1, p2 + nums[j], true);

            return left && right;
        }
    }
}