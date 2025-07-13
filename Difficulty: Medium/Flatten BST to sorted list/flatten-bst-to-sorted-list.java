/*logic of the code : inorder traversal
Always add the lastvisit.right=root so that it will form the chain and also store head for the first time when lastvisit is null
*/
class Solution {
    Node lastvisit=null;
    Node head=null;
    
    public Node flattenBST(Node root){
        inorder(root);
        return head;
    
    }
    void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        
        if(lastvisit==null){
            
            head=root;
        }
        else{
            lastvisit.right=root;
        }
        
        root.left=null;
        lastvisit=root;
        
        inorder(root.right);
    }
}
