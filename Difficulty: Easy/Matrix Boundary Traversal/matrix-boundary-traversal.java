
class Solution {
    static ArrayList<Integer> boundaryTraversal(int mat[][]) {
        
        ArrayList<Integer>result=new ArrayList<>();
        int left=0;
        int right=mat[0].length-1;
        int top=0;
        int bottom=mat.length-1;
        
        //left->right
        
        for(int i=left;i<=right;i++){
            result.add(mat[top][i]);
        }
        top++;
        //top->bottom
        for(int i=top;i<=bottom;i++){
            result.add(mat[i][right]);
        }
        right--;
        //right->left
        for(int i=right;i>=left;i--){
            result.add(mat[bottom][i]);
        }
        bottom--;
        //bottom->top
        for(int i=bottom;i>=top;i--){
            result.add(mat[i][left]);
        }
        left++;
        return result;
        
    }
}
