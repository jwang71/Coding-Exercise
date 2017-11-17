  public int largest(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int max = 0;
    
    int[][] dp = new int[m][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i];
      if (matrix[0][i] == 1) {
        max = 1;
      }
    }
    
    for (int i = 0; i < m; i++) {
      dp[i][0] = matrix[i][0];
      if (matrix[i][0] == 1) {
        max = 1;
      }
    }
    
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    return max;
  }