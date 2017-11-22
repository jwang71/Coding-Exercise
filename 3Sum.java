  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> res= new ArrayList<List<Integer>>();
    if (array == null || array.length < 3) return res;
    Arrays.sort(array);
    
    for (int i = 0; i < array.length - 2; i++) {
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = array.length - 1;
      while (j < k) {
        int sum = array[i] + array[j] + array[k];
        if (sum == target) {
          List<Integer> list = new ArrayList<>();
          list.add(array[i]);
          list.add(array[j]);
          list.add(array[k]);
          j++;
          k--;
          res.add(list);
          while (j < k && array[j] == array[j - 1]) {
            j++;
          } 
          while (k > j && array[k] == array[k + 1]) {
            k--;
          }
        } else if (sum < target) {
          j++;
        } else {
          k--;
        }
      }
    }
    return res;
  }
