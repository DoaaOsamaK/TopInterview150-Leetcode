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
    Integer prev = null; // KEY: Use Integer wrapper for null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return minDiff;
        }

        // KEY: in order traversal to compare all nodes
        
        // Traverse the left subtree
        getMinimumDifference(root.left);

        // Update minDiff and prev value when not at the first node
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;

        // Traverse the right subtree
        getMinimumDifference(root.right);

        return minDiff;
    }
}