/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode result=new TreeNode();
        return dfs(root,result);        
    }
    public TreeNode dfs(TreeNode root,TreeNode result){
        if(root==null){
            return null;
        }
        result.val=root.val;
        createResultNodes(root,result);
        dfs(root.right,result.left);
        dfs(root.left,result.right);
        return result;
        
    }
    public void createResultNodes(TreeNode root,TreeNode result){
        if(root.right!=null){
            result.left=new TreeNode();
        }
        if(root.left!=null){
            result.right=new TreeNode();
        }
    }
}
