  public int stairs(int n) {
    int f1 = 1;
    int f2 = 2;
    if (n == 1) return f1;
    if (n == 2) return f2;
    for (int i = 3; i <= n; i++) {
      int f3 = f1 + f2;
      f1 = f2;
      f2 = f3;
    }
    return f2;
  }

  public int stairsII(int n) {
    int[] dp = new int[n + 1];
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }