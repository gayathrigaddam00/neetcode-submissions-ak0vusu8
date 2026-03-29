class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int x = 0; x < k; x++) {
                if (mat1[i][x] != 0) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] += mat1[i][x] * mat2[x][j];
                    }
                }
            }
        }
        
        return result;
    }
}