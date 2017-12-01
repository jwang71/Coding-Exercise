
  public int smallerPairs(int[] array, int target) {
    // write your solution here
    Arrays.sort(array);
    int count = 0;
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      int val = array[i] + array[j];
      if (val < target) {
        count += j - i;
        i++;
      } else {
        j--;
      }
    }
    return count;
  }
