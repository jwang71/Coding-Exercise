
  public int shiftPosition(int[] array) {
    if (array == null || array.length == 0) return -1;
    int start = 0;
    int end = array.length - 1;
    
    while (start + 1 < end) {
      int mid = start + (end- start)/2;
      if (array[start] > array[end]) {
        if (array[start] <= array[mid]) {
          start = mid;
        } else {
          end = mid;
        }
      } else {
        end = mid;
      }
    }
    if (array[start] < array[end]) {
      return start;
    } else {
      return end;
    }
  }

