class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int num = 100; num <= 999; num++) {
            if (num % 2 == 1) continue; // must be even

            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            int[] temp = new int[10];
            temp[d1]++;
            temp[d2]++;
            temp[d3]++;

            boolean isValid = true;
            for (int i = 0; i < 10; i++) {
                if (temp[i] > freq[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(num);
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
