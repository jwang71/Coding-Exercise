public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (matrix == null) return list;
    int m = matrix.length;
    int n = matrix[0].length;
    
    int left = 0;
    int right = n-1;
    int top = 0;
    int bottom = m-1;
    
    while (left < right && top < bottom) {
      for (int i = left; i < right; i++) {
        list.add(matrix[top][i]);
      }
      for (int i = top; i < bottom; i++) {
        list.add(matrix[i][right]);
      }
      for (int i = right; i > left; i--) {
        list.add(matrix[bottom][i]);
      }
      for (int i = bottom; i > top; i--) {
        list.add(matrix[i][left]);
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    
    if (left == right) {
      for (int i = top; i <= bottom; i++) {
        list.add(matrix[i][left]);
      }
    } else {
      for (int i = left; i <= right; i++) {
        list.add(matrix[top][i]);
      }
    }    
    return list;
  }
}
