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

    char[] chs = null;
    int l = 0;
    public String smallestFromLeaf(TreeNode root) {
        int d = depth(root);
        solve(root, new char[d], d-1);
        return new String(chs, l, d-l);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private void solve(TreeNode node, char[] t, int i) {
        if (node == null) {
            return;
        }
        t[i] = (char) ('a' + node.val);
        if (node.left == null && node.right == null) {
            if (chs == null) {
                chs = Arrays.copyOf(t, t.length);
                l = i;
            } else {
                for (int k = 0, d = Math.max(l, i); k + d < t.length; k++) {
                    if (chs[l+k] < t[i+k]) {
                        return;
                    } else if (chs[l+k] > t[i+k]) {
                        chs = Arrays.copyOf(t, t.length);
                        l = i;
                        return;
                    }
                }
                if (l < i) {
                    chs = Arrays.copyOf(t, t.length);
                    l = i;
                }
            }
            return;
        }
        solve(node.left, t, i-1);
        solve(node.right, t, i-1);
    }
}