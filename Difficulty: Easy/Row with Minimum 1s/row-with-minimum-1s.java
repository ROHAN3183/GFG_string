/* Logic of the code :
Apply the binary Search on the each row and find the count of the 1's
*/
********************************************OPTIMIZED CODE**********************************************************************
class Solution {
    int minRow(int mat[][]) {
        int row=mat.length;
        int col=mat[0].length;
        int index=-1;
        int minCount=Integer.MAX_VALUE;
        
        for(int i=0;i<row;i++){
            Arrays.sort(mat[i]);
        }
        //binary Search
        for(int i=0;i<row;i++){
            int count=countOnes(mat[i]);
            if(count<minCount){
                minCount=count;
                index=i;
            }
        }
        return index+1;
        
    }
    int countOnes(int[]mat){
        int low=0;
        int high=mat.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mat[mid]>=1){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if (ans == -1) return 0; 
        return mat.length - ans;
    }
}
