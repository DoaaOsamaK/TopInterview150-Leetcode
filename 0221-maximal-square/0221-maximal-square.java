class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ds[][] = new int[n][m];
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i==0 || j==0) {
                    if (matrix[i][j]=='1') {
                        ds[i][j] = 1;
                        ans = Math.max(ans,ds[i][j]);
                    }
                }
                else {
                    if (matrix[i][j]=='1') {
                        ds[i][j] = Math.min(ds[i-1][j-1],Math.min(ds[i][j-1],ds[i-1][j]))+1;
                        ans = Math.max(ans,ds[i][j]);
                    }
                }
            }
        }
        return ans*ans;
    }
}