import java.util.*;
public class HelloWorld{
     public static void main(String []args){
         int[] array = {5,2,6,1};
         List<Integer> list = countSmaller(array);
         for (int i : list) {
        System.out.println(i);
             
         }
     }
     
    private static class TreeNode {
        public int val;
        public int count = 1;
        public TreeNode left, right;
        
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = addNode(root, nums[i]);
            res.add(count);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    private static int addNode(TreeNode root, int val) {
        int curCount = 0;
        while(true) {
            if(val <= root.val) {
                root.count++;                   // add the inversion count
                if(root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                curCount += root.count;
                if(root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        
        return curCount;
    }
}