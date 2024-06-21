class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int maxIncrease = 0;
        
        // Calculate the total satisfaction without using the secret technique
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        
        // Calculate the additional satisfaction that could be gained by using the secret technique
        int increase = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                increase += customers[i];
            }
            if (i >= minutes && grumpy[i - minutes] == 1) {
                increase -= customers[i - minutes];
            }
            maxIncrease = Math.max(maxIncrease, increase);
        }
        
        return totalSatisfied + maxIncrease;
    }
}
