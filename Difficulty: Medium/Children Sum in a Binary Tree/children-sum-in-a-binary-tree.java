
class Solution {
    public static int isSumProperty(Node root) {
        return postorder(root);
    }
   static int postorder(Node root){

        if(root==null||(root.left==null && root.right==null)){
            return 1;
        }
        
        int left=postorder(root.left);
        int right=postorder(root.right);
        
        int leftData;
        if(root.left!=null){
            leftData=root.left.data;
        }
        else{
            leftData=0;
        }
        
        int rightData;
        if(root.right!=null){
            rightData=root.right.data;
        }
        else{
            rightData=0;
        }
        
        
        if(root.data==(leftData+rightData)&&left==1 &&right==1){
            return 1;
        }
        return 0;
    }
}