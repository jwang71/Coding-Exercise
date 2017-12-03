
public class Solution {
  public int whiteObjects(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return 0;
    
    int count = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] visited = new boolean[m][n];
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && matrix[i][j] == 0) {
          dfs(matrix, i, j, visited);
          count++;
        }
      }
    }
    return count;
  }
  
  public void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
      return;
    }
    
    if (!visited[i][j] && matrix[i][j] == 0) {
      visited[i][j] = true;
      dfs(matrix, i + 1, j, visited);
      dfs(matrix, i - 1, j, visited);
      dfs(matrix, i, j + 1, visited);
      dfs(matrix, i, j - 1, visited);
    }
  }
}
