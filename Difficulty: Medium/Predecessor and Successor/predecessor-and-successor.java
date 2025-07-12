
class Solution {
    Node predecessor=null;
    Node successor=null;
        
    public ArrayList<Node> findPreSuc(Node root, int key) {
        
        ArrayList<Node>result=new ArrayList<>();
        
        inorder(root,key);
        
        result.add(predecessor);
        result.add(successor);
        
        return result;
        
    }
    void inorder(Node root,int key){
        if(root==null){
            return;
        }
        if(root.data==key){
            if(root.left!=null){
                Node temp=root.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                predecessor=temp;
            }
            
            if(root.right!=null){
                Node temp=root.right;
                while(temp.left!=null){
                    temp=temp.left;
                }
                successor=temp;
            }
            
        }
        else if(root.data>key){
            successor=root;
            inorder(root.left,key);
            
        }
        else{
            predecessor=root;
            inorder(root.right,key);
        }
        return;
    }
}