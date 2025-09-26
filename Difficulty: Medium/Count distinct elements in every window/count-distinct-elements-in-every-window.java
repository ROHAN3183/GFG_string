class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        ArrayList<Integer>list=new ArrayList<>();
        int i =0 ;
        int j=0;
        int n = arr.length;
        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(j-i+1>k){
                int freq=map.get(arr[i]);
                if(freq==1){
                    map.remove(arr[i]);
                }
                else{
                    map.put(arr[i],freq-1);
                }
                i++;
                
            }
            if(j-i+1==k){
                list.add(map.size());
            }
            j++;
        }
        return list;
        
    }
}