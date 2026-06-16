class Solution {

    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    private boolean solve(String s1, String s2) {

        // base cases
        if (s1.equals(s2))
            return true;

        if (s1.length() != s2.length())
            return false;

        String key = s1 + "-" + s2;

        if (map.containsKey(key))
            return map.get(key);

        int n = s1.length();

        boolean result = false;

        for (int i = 1; i < n; i++) {

            // swapped case
            boolean swapped =
                    solve(s1.substring(0, i), s2.substring(n - i))
                    &&
                    solve(s1.substring(i), s2.substring(0, n - i));

            if (swapped) {
                result = true;
                break;
            }

            // not swapped case
            boolean notSwapped =
                    solve(s1.substring(0, i), s2.substring(0, i))
                    &&
                    solve(s1.substring(i), s2.substring(i));

            if (notSwapped) {
                result = true;
                break;
            }
        }

        map.put(key, result);
        return result;
    }
}