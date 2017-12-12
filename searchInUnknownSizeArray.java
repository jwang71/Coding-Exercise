/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    if (dict == null) return -1;
    
    int left = 0;
    int right = 1;
    
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right = 2 * right;
    }
    
    return binarySearch(dict, target, left, right);
  }
  
  public int binarySearch(Dictionary dict, int target, int left, int right) {
    int start = left;
    int end = right;
    while (start <= end) {
      int mid = (start+end)/2;
      if (dict.get(mid) == null || dict.get(mid) > target) {
        end = mid - 1;
      } else if (dict.get(mid) == target){
        return mid;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
