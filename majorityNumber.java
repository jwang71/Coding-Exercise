  public int majority(int[] array) {
    int count = 0;
    int res = array[0];
    for (int i = 0; i < array.length; i++) {
      if (count == 0) {
        res = array[i];
        count++;
      } else if (array[i] == res) {
        count++;
      } else {
        count--;
      }
    }
    return res;
  }