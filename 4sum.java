  public boolean exist(int[] array, int target) {
    if (array == null) return false;
    Arrays.sort(array);
    
    for (int i = 0; i < array.length - 3; i++) {
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < array.length - 2; j++) {
        if (j > i + 1 && array[j] == array[j - 1]) {
          continue;
        }       
        
        int k = j + 1;
        int m = array.length - 1;
        while (k < m) {
          int sum = array[i] + array[j] + array[k] + array[m];
          if (sum == target) {
            return true;
          } else if (sum < target) {
            k++;
          } else {
            m--;
          }
        }
      }
    } 
    return false;
  }

