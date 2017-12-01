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

public int maxProfit(int[] array, int k) {
	int len = array.length;
	if (k == 0) return 0;
	if (k >= len/2) {
	  int profit = 0;
	  for (int i = 1; i < len; i++) {
	    if (array[i] > array[i - 1]) {
	      profit += array[i] - array[i - 1];
	    }
	  }
	  return profit;
	}

	int[][] local = new int[len][k + 1];
	int[][] global = new int[len][k + 1];
	local[0][0] = global[0][0] = 0;

	for (int i = 1; i < len; i++) {
	  int gain = array[i] - array[i - 1];
	  for (int j = 1; j <= k; j++) {
	    local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, gain), local[i-1][j]+gain);
	    global[i][j] = Math.max(global[i - 1][j], local[i][j]);
	  }
	}
	return global[len-1][k];
}