
  public int totalOccurrence(int[] array, int target) {
    if (array == null || array.length == 0) return 0;
    int pos = binarySearch(array, target);
    if (pos == -1) return 0;
    
    int left = pos - 1;
    int right = pos + 1;
    
    while (left >= 0 && array[left] == target) {
      left--;
    }
    while (right < array.length && array[right] == target) {
      right++;
    }
    return right - left - 1;
  }
  
  public int binarySearch(int[] array, int target) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = start + (end- start)/2;
      if (array[mid] == target) return mid;
      if (array[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

