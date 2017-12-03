
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
  public TreeNode reconstruct(int[] in, int[] post) {
    if (in.length != post.length) {
      return null;
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < in.length; i++) {
      map.put(in[i], i);
    }
    return helper(in, 0, in.length - 1, post, 0, post.length - 1, map);
  }
  public TreeNode helper(int[] in, int in_start, int in_end, 
            int[] post, int post_start, int post_end, 
            HashMap<Integer, Integer> map) {
    if (in_start > in_end) return null;
    int rootVal = post[post_end];
    int index = map.get(rootVal);
    TreeNode root = new TreeNode(rootVal);
    root.left = helper(in, in_start, index-1, post, post_start, post_start+index-in_start-1,map);
    root.right = helper(in, index+1, in_end, post, post_start+index-in_start, post_end-1,map);
    return root;
  }
}
