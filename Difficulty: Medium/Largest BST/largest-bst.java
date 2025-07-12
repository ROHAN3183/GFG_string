class Solution {
    class info{
        boolean isValid;
        int size;
        int min;
        int max;
        info(boolean isValid,int size,int min,int max){
            this.isValid=isValid;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    static int largestBst(Node root) {
        Solution sol=new Solution();
        return sol.postorder(root).size;
        
    }
    info postorder(Node root){
        if(root==null){
            return new info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        info left=postorder(root.left);
        info right=postorder(root.right);
        
        if(left.isValid && left.max<root.data && right.min>root.data){
            
            int size=left.size+right.size+1;
            
            int min=Math.min(left.min,root.data);
            int max=Math.max(right.max,root.data);
            
            return new info(true,size,min,max);
        }
        else{
            int size=Math.max(left.size,right.size);
            return new info(false,size,0,0);
        }
    }
}