class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] frequencies = new int[max - min + 1];

        int left = 0;
        
        int maxWindow = 0;

        for (int right = 0; right < nums.length; right++) {
            frequencies[nums[right] - min]++;

            while (frequencies[nums[right] - min] > k) {
                frequencies[nums[left] - min]--;

                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}