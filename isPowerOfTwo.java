  public boolean isPowerOfTwo(int x) {
    if (x <= 0) return false;
    while (x % 2 != 1) {
      x = x / 2;
    }
    return x == 1;
  }

  public boolean isPowerOfTwo(int x) {
    if (x <= 0) return false;
    return (x &(x - 1)) == 0;
  }

  public boolean isPowerOfTwo(int x) {
    if (x <= 0) return false;
    int count = 0;
    while (x != 0) {
      if ((x & 1) != 0) {
        count++;
      }
      x = x >> 1;
    }
    return count == 1;
  }