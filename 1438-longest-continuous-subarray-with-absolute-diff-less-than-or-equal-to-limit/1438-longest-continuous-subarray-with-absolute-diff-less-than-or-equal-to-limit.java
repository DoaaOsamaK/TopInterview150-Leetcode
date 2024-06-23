class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> increase = new ArrayDeque<>();
        Deque<Integer> decrease = new ArrayDeque<>();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];

            while (!increase.isEmpty() && current < increase.peekLast()) {
                increase.pollLast();
            }
            increase.offerLast(current);

            while (!decrease.isEmpty() && current > decrease.peekLast()) {
                decrease.pollLast();
            }
            decrease.offerLast(current);

            while (decrease.peekFirst() - increase.peekFirst() > limit) {
                if (nums[left] == decrease.peekFirst()) {
                    decrease.pollFirst();
                }
                if (nums[left] == increase.peekFirst()) {
                    increase.pollFirst();
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
