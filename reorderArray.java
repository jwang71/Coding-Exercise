  public int[] reorder(int[] array) {
    if (array == null || array.length <= 1) return array;
    int n = array.length;
    int k = n/2;
    int[] res = new int[n];
    int i = 0;
    int j = k;
    int count = 0;
    
    while (i < k  && count < n && j < array.length) {
      if (count % 2 == 0) {
        res[count] = array[i];
        count++;
        i++;
      } else {
        res[count] = array[j];
        count++;
        j++;
      }
    }
    
    if (n % 2 == 0) {
      res[count] = array[n - 1];
      return res;
    } else {
      res[count++] = array[n-2];
      res[count] = array[n - 1];
    }
    return res;
  }

  public int[] reorder(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    if (array.length % 2 != 0) {
      convert(array, 0, array.length-2);
    } else {
      convert(array, 0, array.length-1);
    }

    return array;
  }
  
  public void convert(int[] array, int left, int right) {
    if (array == null) return;
    if (right - left <= 1) {
      return;
    }
    int size = right - left + 1;
    int mid = left + size /2;
    int leftmid = left + size/4;
    int rightmid = left + size * 3/4;
    
    reverse(array, leftmid, mid-1);
    reverse(array, mid, rightmid - 1);
    reverse(array, leftmid, rightmid - 1);
    
    convert(array, left, left+2*(leftmid-left)-1);
    convert(array, left+2*(leftmid-left), right);
  }
  
  public void reverse(int[] array, int i, int j) {
    for (; i < j; i++, j--) {
      swap(array, i, j);
    }
  }
  
  public void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }