import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int start = 1;
        int end = (position[position.length - 1] - position[0]) / (m - 1);
        
        while (start <= end) {
            int mid = (end + start) / 2;
            int req = dist(position, mid);
            
            if (req >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }

    public int dist(int[] nums, int mid) {
        int count = 1;
        int last = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= mid) {
                count++;
                last = nums[i];
            }
        }
        
        return count;
    }
}