class Solution {
    
    int minSwap(int[] arr, int k) {
        
       int n = arr.length;
       int size = 0;
       
       for(int i=0;i<n;i++){
           if(arr[i]<=k){
               size++;
           }
       }
       
       int i=0;
       int j=0;
       int count=0;
       int min=Integer.MAX_VALUE;
       
       while(j<n){
           
          if(arr[j]<=k){
              count++;
          }
          
          while(j-i+1>size){
              if(arr[i]<k){
                  count--;
              }
              i++;
          }
          if(j-i+1==size){
              min=Math.min(min,j-i+1-count);
          }
          j++;
       }
       return min;
    }
}
