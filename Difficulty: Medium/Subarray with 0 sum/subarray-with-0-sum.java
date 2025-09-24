class Solution {
    static boolean findsum(int arr[]) {
        HashMap<Integer,Integer>map=new HashMap<>();
    
        int sum=0;
        map.put(0,1);
        for(int i =0;i<arr.length;i++){
            sum=sum+arr[i];
            if(map.containsKey(sum)){
                return true;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return false;
    }
}