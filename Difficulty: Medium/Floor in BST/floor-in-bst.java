
class Solution {
    static int floorval;
    public static int floor(Node root, int x) {
        floorval=-1;
        inorder(root,x);
        return floorval;
        
    }
    static void inorder(Node root,int x){
        if(root==null){
            return;
        }
        inorder(root.right,x);
        if(root.data<=x &&floorval==-1){
            floorval=root.data;
            return;
        }
        inorder(root.left,x);
        
    }
}