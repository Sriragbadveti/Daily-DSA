class Solution {
    public int prefixConnected(String[] words, int k) {
        int n = words.length;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s1 = words[i];
            StringBuilder sb = new StringBuilder();
            if (s1.length() < k)
                continue;

            for (int j = 0; j < k; j++) {
                char ch = s1.charAt(j);
                sb.append(ch);
            }
            String s2 = sb.toString();

            if (map.containsKey(s2)) {
                count += map.get(s2);
                map.put(s2, map.getOrDefault(s2, 0) + 1);
            } else {
                map.put(s2, map.getOrDefault(s2, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() >= 2) {
                ans++;
            }
        }
        return ans;
    }
}