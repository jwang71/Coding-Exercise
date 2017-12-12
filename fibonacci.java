  public long fibonacci(int K) {
    if (K <= 0) return 0;
    if (K == 1) return 1;
    long[] dp = new long[K+1];
    dp[0] = 0;
    dp[1] = 1;
    
    for (int i = 2; i <= K; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[K];
  }


  public long fibonacci(int K) {
    long f1 = 0;
    long f2 = 1;
    if (K <= 0) return f1;
    if (K == 1) return f2;
    
    for (int i = 2; i <= K; i++) {
      long f3 = f1 + f2;
      f1 = f2;
      f2 = f3;
    }
    return f2;
  }