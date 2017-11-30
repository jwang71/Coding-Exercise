//this solution also works for array with duplicates

  public int search(int[] array, int target) {
    if (array.length == 0) return -1;
    int start = 0;
    int end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start)/2;
      if (array[mid] == target) {
        return mid;
      } else {
        if (array[start] < array[mid]) {
          if (array[start] <= target && target <= array[mid]) {
            end = mid;
          } else {
            start = mid;
          }
        } else {
          if (array[mid] <= target && target <= array[end]) {
            start = mid;
          } else {
            end = mid;
          }
        }
      }
    }
    
    if (array[start] == target) {
      return start;
    }
    if (array[end] == target) {
      return end;
    }
    return -1;
  }