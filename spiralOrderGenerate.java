public class Solution {
  public int[][] spiralGenerate(int m, int n) {
    int[][] matrix = new int[m][n];
    if (m == 0 || n == 0) return matrix;
    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = m - 1;
    
    int count = 1;
    while (left < right && top < bottom) {
      for (int i = left; i < right; i++) {
        matrix[top][i] = count++;
      }
      for (int i = top; i < bottom; i++) {
        matrix[i][right] = count++;
      }
      for (int i = right; i > left; i--) {
        matrix[bottom][i] = count++;
      }
      for (int i = bottom; i > top; i--) {
        matrix[i][left] = count++;
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    
    if (left > right && top > bottom) {
      return matrix;
    }
    if (left == right) {
      for (int i = top; i <= bottom; i++) {
        matrix[i][left] = count++;
      }
    } else {
      for (int i = left; i <= right; i++) {
        matrix[top][i] = count++;
      }
    }
    return matrix;
  }
}
