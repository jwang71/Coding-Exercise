
public class Solution {
  public List<Integer> majority(int[] array) {
    List<Integer> res = new ArrayList<Integer>();
    int count1 = 0;
    int count2 = 0;
    int a = 0;
    int b = 0;
    
    for (int i = 0; i < array.length; i++) {
      if (array[i] == a) {
        count1++;
      } else if (array[i] == b) {
        count2++;
      } else if (count1 == 0) {
        a = array[i];
        count1++;
      } else if (count2 == 0) {
        b = array[i];
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    count1 = 0;
    count2 = 0;
    for (int i : array) {
      if (a == i) {
        count1++;
      } else if (b == i) {
        count2++;
      }
    }
    
    if (count1 > array.length/3) {
      res.add(a);
    }
    if (count2 > array.length/3) {
      res.add(b);
    }
    Collections.sort(res);
    return res;
  }
}
