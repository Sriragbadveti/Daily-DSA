class ProductOfNumbers {
    ArrayList<Long> prefix = new ArrayList<>();

    public ProductOfNumbers() {

    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            return;
        }

        if (prefix.size() == 0) {
            prefix.add((long) num);
            return;
        }

        long prev = prefix.get(prefix.size() - 1);
        long newValue = prev * num;
        prefix.add(newValue);
    }

    public int getProduct(int k) {
        int n = prefix.size();
        if (k > n)
            return 0;

        if (k == n)
            return prefix.get(n - 1).intValue();
        int tempIndex = n - k - 1;
        long tempValue1 = prefix.get(tempIndex);
        long tempValue2 = prefix.get(n - 1);

        int ans = (int) (tempValue2 / tempValue1);
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */