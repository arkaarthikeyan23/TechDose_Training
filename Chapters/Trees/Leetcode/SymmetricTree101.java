package Leetcode;
public class SymmetricTree101 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //TC:O(N) SC:O(N)
    public boolean isSymmetric(TreeNode root) {
        return root==null || helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.val != right.val)   return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
