/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append('#').append(',');
                continue;
            } 
            sb.append(cur.val).append(',');
            q.offer(cur.left);
            q.offer(cur.right);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        
        q.offer(root);
        for (int i = 1; i < array.length; i++) {
            TreeNode cur = q.poll();
            if (!array[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(array[i]));
                cur.left = left;
                q.offer(left);
            }
            if (!array[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(array[i]));
                cur.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));