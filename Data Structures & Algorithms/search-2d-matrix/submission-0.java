class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = findRowIdx(matrix,target);
        if(rowIdx!=-1) {
            return searchInRow(matrix,target,rowIdx);
        }
        return false;
    }
    private int findRowIdx(int[][] matrix, int target){
        int l=0,h=matrix.length-1;

        while(l<=h){
            int m = l+(h-l)/2;
            if(matrix[m][0] <= target && target<=matrix[m][matrix[0].length-1]){
                return m;
            }
            else if(matrix[m][0]>target){
                h=m-1;
            }
            else{
                l=m+1;
            }

        }
        return -1;
    }

private boolean searchInRow(int[][] matrix, int target, int rowIdx){
    int l=0,h=matrix[0].length-1;

    while(l<=h){
        int m = l+(h-l)/2;

        if(matrix[rowIdx][m]==target){
            return true;
        }
        else if (matrix[rowIdx][m] > target){
            h=m-1;
        }
        else{
            l=m+1;
        }
    }
    return false;
}
}
