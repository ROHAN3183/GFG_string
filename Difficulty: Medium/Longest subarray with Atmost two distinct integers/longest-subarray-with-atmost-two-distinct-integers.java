class Solution {
    public int totalElements(int[] arr) {
        return Atmost(arr , 2 );
        
    }
    
        int Atmost(int[] arr,int k) {
            HashMap<Integer,Integer>map=new HashMap<>();
            int n = arr.length;
            int i=0;
            int j=0;
            int max =Integer.MIN_VALUE;
            while(j<n){
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
                
                    while(map.size()>k){
                        int freq= map.get(arr[i]);
                            if(freq==1){
                                map.remove(arr[i]);
                            }
                            else{
                                map.put(arr[i],freq-1);
                            }
                        i++;
                    }
                    
                if(map.size()<=k){
                    max=Math.max(max,j-i+1);
                }
                
                j++;
            
            }
        return max;
        
    }
}