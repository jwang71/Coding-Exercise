
  public double largestProduct(double[] array) {
    double[] max = new double[array.length];
    double[] min = new double[array.length];
    double res = array[0];
    max[0] = array[0];
    min[0] = array[0];
    
    for (int i = 1; i < array.length; i++) {
      if (array[i] > 0) {
        max[i] = Math.max(array[i], max[i - 1] * array[i]);
        min[i] = Math.min(array[i], min[i - 1] * array[i]);
      } else {
        max[i] = Math.max(array[i], min[i - 1] * array[i]);
        min[i] = Math.min(array[i], max[i - 1] * array[i]);
      }
      res = Math.max(res, max[i]);   
    }
    
    return res;
  }
