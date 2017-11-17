public int[] dedupI(int[] array) {
  if (array == null || array.length <= 1) {
    return array;
  }
  int slow = 0;
  int fast = 1;
  
  while (fast < array.length) {
    if (array[fast] == array[slow]) {
      fast++;
    } else {
      array[++slow] = array[fast++];
    }
  }
  int[] result = new int[slow + 1];
  for (int i = 0; i <= slow; i++) {
    result[i] = array[i];
  }
  return result;
}


public int[] dedupII(int[] array) {
  if (array == null || array.length <= 2) {
    return array;
  }
  int slow = 1;
  int fast = 2;
  
  while (fast < array.length) {
    if (array[fast] == array[slow - 1]) {
      fast++;
    } else {
      array[++slow] = array[fast++];
    }
  }
  
  int[] result = new int[slow + 1];
  for (int i = 0; i <= slow; i++) {
    result[i] = array[i];
  }
  return result;
}

public int[] dedup(int[] array) {
  if (array == null || array.length == 1) return array;
  int slow = 0;
  int fast = 1;
  boolean flag = false;
  
  while (fast < array.length) {
    if (array[fast] == array[slow]) {
      flag = true;
      fast++;
    } else if (flag == true) {
      array[slow] = array[fast++];
      flag = false;
    } else {
      array[++slow] = array[fast++];
    }
  }
  
  if (flag == true) {
    int[] res = new int[slow];
    for (int i = 0; i < slow; i++) {
      res[i] = array[i];
    }
    return res;
  } else {
    int[] res = new int[slow+1];
    for (int i = 0; i <= slow; i++) {
      res[i] = array[i];
    }
    return res;
  }
}

public int[] dedupIV(int[] array) {
  if (array == null || array.length <= 1) {
    return array;
  }
  int slow = -1;
  int fast = 0;
  
  while (fast < array.length) {
    if (slow == -1 || array[fast] != array[slow]) {
      array[++slow] = array[fast++];
    } else {
      while (fast + 1 < array.length && array[fast + 1] == array[fast]) {
        fast++;
      }
      slow--;
      fast++;
    }
  }
  
  int[] res = new int[slow + 1];
  for (int i = 0; i <= slow; i++) {
    res[i] = array[i];
  }
  return res;
}