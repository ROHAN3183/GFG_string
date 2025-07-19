class Solution {
    int minRow(int mat[][]) {
        int row=mat.length;
        int col=mat[0].length;
        int minIndex=-1;
        int countOfOnes=Integer.MAX_VALUE;
        
        for(int i=0;i<row;i++){
            int maxCountOnes=0;
            for(int j=0;j<col;j++){
                
                if(mat[i][j]==1){
                    maxCountOnes++;
                }
                
            }
            
            if(maxCountOnes < countOfOnes){
                countOfOnes=maxCountOnes;
                minIndex=i;
            }
            
        }
        
        return minIndex+1;
        
    }
}