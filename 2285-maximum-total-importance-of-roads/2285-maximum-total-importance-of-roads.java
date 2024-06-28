class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] nodeDegrees = new int[n];
        for (int[] road : roads) {
            nodeDegrees[road[0]]++;
            nodeDegrees[road[1]]++;
        }
        
        int[] degreeCount = new int[n];
        for (int degree : nodeDegrees) {
            degreeCount[degree]++;
        }
        
        long totalImportance = 0;
        long value = 1;
        for (long i = 0; i < n; i++) {
            for (int j = 0; j < degreeCount[(int)i]; j++) {
                totalImportance += i * value++;
            }
        }
        
        return totalImportance;
    }
}
