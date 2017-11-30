public int maxProfitI(int[] array) {
	int min = array[0];
	int maxProfit = 0;

	for (int i = 0; i < array.length; i++) {
	  min = Math.min(min, array[i]);
	  maxProfit = Math.max(maxProfit, array[i] - min);
	}
	return maxProfit;
}

public int maxProfitII(int[] array) {
	int profit = 0;
	for (int i = 0; i < array.length - 1; i++) {
	  if (array[i + 1] > array[i]) {
	    profit += array[i + 1] - array[i];
	  }
	}
	return profit;
}

public int maxProfitIII(int[] array) {
	if (array == null || array.length < 2) return 0;
	int len = array.length;

	int[] left = new int[len];
	int[] right = new int[len];

	int min = array[0];
	for (int i = 1; i < len; i++) {
	  min = Math.min(min, array[i]);
	  left[i] = Math.max(left[i - 1], array[i] - min);
	}

	int max = array[len - 1];
	for (int i = len - 2; i >= 0; i--) {
	  max = Math.max(max, array[i]);
	  right[i] = Math.max(right[i +1], max - array[i]);
	}

	int maxProfit = 0;
	for (int i = 0; i < len; i++) {
	  maxProfit = Math.max(maxProfit, left[i] + right[i]);
	}
	return maxProfit;
}

public int maxProfitIV(int[] prices, int k) {
    if (k == 0) {
        return 0;
    }
    if (k >= prices.length / 2) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    int n = prices.length;
    int[][] mustsell = new int[n + 1][n + 1];   // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
    int[][] globalbest = new int[n + 1][n + 1];  // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
    
    mustsell[0][0] = globalbest[0][0] = 0;
    // for (int i = 1; i <= k; i++) {
    //     mustsell[0][i] = globalbest[0][i] = 0;
    // }
    
    for (int i = 1; i < n; i++) {
        int gainorlose = prices[i] - prices[i - 1];
        for (int j = 1; j <= k; j++) {
            mustsell[i][j] = Math.max(globalbest[(i - 1)][j - 1] + Math.max(0,gainorlose),
                                        mustsell[(i - 1)][j] + gainorlose);
            globalbest[i][j] = Math.max(globalbest[(i - 1)][j], mustsell[i ][j]);
        }
    }
    return globalbest[(n - 1)][k];
}
