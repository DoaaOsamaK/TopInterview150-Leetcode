class Solution {
    public int findMaxK(int[] nums) {
        int[] sum = new int[1001];
        int max = -1;
        for (int n : nums) {
            int index = n > 0 ? n : -n;
            if (sum[index] != n) {
                sum[index] += n;
            }
            
            if (sum[index] == 0) {
                max = max > index ? max : index;
            }
        }
        return max;
    }
}