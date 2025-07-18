/*LOGIC OF THE CODE 
Smiliar code to the leetcode - 378
2 times Binary Search
first the min and the max range so , on that we can apply the binary search  to get the target.
second for count the number of the smallest element in the matrix.
*/
***********************************************OPTIMIZED CODE*******************************************************************
class Solution {
    int median(int mat[][]) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int N= mat.length * mat[0].length;
        
        for(int i=0 ;i<mat.length;i++){
            min=Math.min(mat[i][0],min);
            max=Math.max(mat[i][mat[0].length-1],max);
        }
        int result=-1;
        int low=min;
        int high=max;
       
        while(low<=high){
            int mid=low+(high-low)/2;
             int length=0;
            for(int i=0 ;i< mat.length ;i++){
                length+=findtheSmallestCount(mat[i],mid);
            }
            if(length<=N/2){
                low=mid+1;
            }
            else{
                result=mid;
                high=mid-1;
            }
        }
        return result;
    
    }
    int  findtheSmallestCount(int mat[],int target){
        int low=0;
        int high=mat.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(mat[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return low;
    }
}
