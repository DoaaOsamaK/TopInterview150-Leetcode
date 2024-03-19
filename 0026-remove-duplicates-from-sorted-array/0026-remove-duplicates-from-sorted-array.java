class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1; // Index for the next unique element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i]; // Copy the current element to the next position in the array
                j++; // Move to the next position for the next unique element
            }
        }
        return j; // Return the length of the resulting array
    }
}
