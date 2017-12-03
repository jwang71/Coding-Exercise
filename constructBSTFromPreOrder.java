
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode reconstruct(int[] pre) {
    if (pre == null || pre.length == 0) return null;
    return helper(pre, 0, pre.length - 1);
  }
  
  public TreeNode helper(int[] pre, int start, int end) {
    if (start > end) return null;
    int rootVal = pre[start];
    TreeNode root = new TreeNode(rootVal);
    int pos = start;
    for (; pos < pre.length; pos++) {
      if (pre[pos] > rootVal) {
        break;
      }
    }
    root.left = helper(pre, start + 1, pos - 1);
    root.right = helper(pre, pos, end);
    return root;
  }
}
