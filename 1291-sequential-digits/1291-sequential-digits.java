class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int lenLow = String.valueOf(low).length();
        int lenHigh = String.valueOf(high).length();

        for (int len = lenLow; len <= lenHigh; len++) {
            for (int start = 0; start <= 9 - len; start++) {
                int num = buildNumber(digits, start, len);
                if (num > high) break;
                if (num >= low) res.add(num);
            }
        }
        return res;
    }

    private int buildNumber(String digits, int start, int len) {
        int num = 0;
        for (int i = start; i < start + len; i++) {
            num = num * 10 + (digits.charAt(i) - '0');
        }
        return num;
    }
}