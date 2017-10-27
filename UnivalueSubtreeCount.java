/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        
        int left = countUnivalSubtrees(root.left);
        int right = countUnivalSubtrees(root.right);
        
        if (root.left == null) {
            if (isUniValueSubtree(root)) {
                return right + 1;
            } else {
                return right;
            }
        } else if (root.right == null) {
            if (isUniValueSubtree(root)) {
                return left + 1;
            } else {
                return left;
            }
        } else {
            if (isUniValueSubtree(root)) {
                return left + right + 1;
            } else {
                return left + right;
            }
        }
    }
    
    
    public boolean isUniValueSubtree(TreeNode root) {
        if (root == null) return true;   
        return helper(root, root.val);
    }
    
    public boolean helper(TreeNode root, int value) {
        if (root == null) return true;
        if (root.val != value) return false;
        return helper(root.left, value) && helper(root.right, value);
    }
}