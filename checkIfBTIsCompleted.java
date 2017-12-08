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
  public boolean isCompleted(TreeNode root) {
    if (root == null) return true;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    boolean flag = false;
    
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur.left == null) {
        flag = true;
      } else if (flag) {
        return false;
      } else {
        q.offer(cur.left);
      }
      if (cur.right == null) {
        flag = true;
      } else if (flag) {
        return false;
      } else {
        q.offer(cur.right);
      }
    }
    return true;
  }
}
