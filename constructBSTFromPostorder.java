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
  public TreeNode reconstruct(int[] post) {
    if (post == null || post.length == 0 ) return null;
    int n = post.length;
    return helper(post, 0, n-1);
  }
  
  public TreeNode helper(int[] post, int start, int end) {
    if (start > end) return null;
    if (start >= end) return new TreeNode(post[start]);
    TreeNode root = new TreeNode(post[end]);
    int rootValue = post[end];
    int pos = findPos(post, rootValue);
    if (pos == -1) {
      root.left = null;
    } else {
      root.left = helper(post, start, pos);
    }
    root.right = helper(post, pos+1, end - 1);
    return root;
  }
  
  public int findPos(int[] post, int target) {
    int i = -1;
    while (i + 1 < post.length && post[i + 1] < target) {
      i++;
    }
    return i;
  }
