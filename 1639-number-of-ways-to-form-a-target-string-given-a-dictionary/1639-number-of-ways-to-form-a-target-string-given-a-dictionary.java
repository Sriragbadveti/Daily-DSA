class Solution {
    int mod = 1_000_000_007;

    public int numWays(String[] words, String target) {

        int n = words.length;
        int m = words[0].length();

        // first make the frequency array
        int freq[][] = new int[m][26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }

        int dp[][] = new int[target.length()][m];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, dp, freq, target, words);
    }

    private int solve(int i, int j, int dp[][], int freq[][], String target, String words[]) {

        // base case
        if (i == target.length())
            return 1;

        if (j == words[0].length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // we skip this column
        long skip = solve(i, j + 1, dp, freq, target, words) % mod;

        // we choose this column
        long take = 0;

        int count = freq[j][target.charAt(i) - 'a'];

        if (count > 0) {
            take = (1L * count * solve(i + 1, j + 1, dp, freq, target, words)) % mod;
        }

        return dp[i][j] = (int) ((skip + take) % mod);
    }
}