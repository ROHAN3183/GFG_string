/*Complete the function below
Node is as follows
class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}*/
class Solution {
     int count = 0;
    public int longestConsecutive(Node root) {
        // add code here.
         dfs(root);
        return count < 2 ? -1 : count;
        
    }
        int dfs(Node root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftcount = 1, rightcount = 1;

        if (root.left != null && root.left.data == root.data + 1) {
            leftcount = left + 1;
        }
        if (root.right != null && root.right.data == root.data + 1) {
            rightcount = right + 1;
        }

        int temp = Math.max(leftcount, rightcount);
        count = Math.max(count, temp);
        return temp;
    }
    
}