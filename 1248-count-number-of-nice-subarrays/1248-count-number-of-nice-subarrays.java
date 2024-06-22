class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int result = 0, oddCount = 0;
        for (int num : nums) {
            oddCount += num & 1;
            if (oddCount - k >= 0) {
                result += count[oddCount - k];
            }
            count[oddCount]++;
        }
        return result;
    }
}