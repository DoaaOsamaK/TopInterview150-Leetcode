class Solution {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Traverse the right subtree
        bstToGst(root.right); 
        // Update the sum 
        sum += root.val;    
        // Update the current node's value   
        root.val = sum;
        // Traverse the left subtree        
        bstToGst(root.left);   
        
        return root;
    }
}