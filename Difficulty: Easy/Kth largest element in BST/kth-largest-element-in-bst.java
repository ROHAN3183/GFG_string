
class Solution {
    int pos=0;
    public int kthLargest(Node root, int k) {
    Node node=reversedInorder(root,k);
        return node.data;
        
    }
    Node reversedInorder(Node root,int k){
        if(root==null){
            return null;
        }
        Node right=reversedInorder(root.right,k);
        if(right!=null){
            return right;
        }
        pos++;
        if(pos==k){
            return root;
        }
        Node left=reversedInorder(root.left,k);
        if(left!=null){
            return left;
        }
        return null;
        
    }
}