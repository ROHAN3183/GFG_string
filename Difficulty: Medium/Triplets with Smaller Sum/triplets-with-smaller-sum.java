// User function Template for Java

class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        long count=0;
        Arrays.sort(arr);
        for(int i=n-1;i>=2;i--){
            int low =0;
            int high=i-1;
            while(low<high){
                if((arr[low]+arr[high]+arr[i])>=sum){
                    high--;
                }
                else{
                    count+=high-low;
                    low++;
                }
            }
        }
        return count;
    }
}
