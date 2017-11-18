  public int[] largestAndSmallest(int[] array) {
    // Write your solution here.
    // The first element is the largest number,
    // the second element is the smallest number.
    List<Integer> small = new ArrayList<>();
    List<Integer> large = new ArrayList<>();
    
    for (int i = 0; i < array.length; i += 2) {
      if (i == array.length - 1) {
        small.add(array[i]);
        large.add(array[i]);
      } else {
        if (array[i] < array[i+1]) {
          small.add(array[i]);
          large.add(array[i+1]);
        } else {
          small.add(array[i+1]);
          large.add(array[i]);
        }
      }
    }
    
    int[] result = new int[2];
    int smallest = getSmall(small);
    int largest = getLarge(large);
    result[0] = largest;
    result[1] = smallest;
    return result;
  }
  
  public int getSmall(List<Integer> list) {
    int res = list.get(0);
    for (int i : list) {
      res = Math.min(res, i);
    }
    return res;
  }
  
  public int getLarge(List<Integer> list) {
    int res = list.get(0);
    for (int i : list) {
      res = Math.max(res, i);
    }
    return res;
  }
