
public List<Integer> closest(int[] array, int target) {
  List<Integer> res = new ArrayList<>();
  if (array == null || array.length == 0) return res;
  
  Arrays.sort(array);
  int i = 0;
  int j = array.length - 1;
  int diff = Integer.MAX_VALUE;
  
  while (i < j) {
    int val = array[i] + array[j];
    if (val < target) {
      if ((target - val) < diff) {
        res.clear();
        res.add(0, array[i]);
        res.add(1, array[j]);
        diff = target - val;
      }
      i++;
    } else {
      if ((val - target) < diff) {
        res.clear();
        res.add(0, array[i]);
        res.add(1, array[j]);
        diff = val - target;
      }
      j--;
    }
  }
  return res;
}