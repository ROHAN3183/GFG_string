
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i =0 ;
        int j = 0;
        int n = arr.length;
        int sum = 0;
        while(j<n){
            sum = sum + arr[j];
            while(i<= j && sum>target){
                sum-=arr[i];
                i++;
            }
            if(sum==target){
                return new ArrayList<>(Arrays.asList(i+1,j+1));
            }
            j++;
        }
        return new ArrayList<>(Arrays.asList(-1));
        
    }
}
