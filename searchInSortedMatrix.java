public class Solution {
  public int[] search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return new int[]{-1,-1};
    
    int m = matrix.length;
    int n = matrix[0].length;
    
    int start = 0;
    int end = m*n-1;
    
    int[] res = new int[2];
    
    while (start <= end) {
      int mid = (start + end)/2;
      int row = mid/n;
      int col = mid%n;
      if (matrix[row][col] == target) {
        res[0] = row;
        res[1] = col;
        return res;
      } else if (matrix[row][col] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return new int[]{-1,-1};
  }
}
