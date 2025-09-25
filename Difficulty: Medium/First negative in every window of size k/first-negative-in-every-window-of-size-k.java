class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer>list=new ArrayList<>();
        Deque<Integer>dq=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                dq.offerLast(i);
            }
        }
        if(!dq.isEmpty()){
            list.add(arr[dq.peekFirst()]);
        }
        else if(dq.isEmpty()){
            list.add(0);
        }
        for(int i = k;i<arr.length;i++){
            if(arr[i]<0){
                dq.offerLast(i);
            }
            
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            
            if(dq.isEmpty()){
                list.add(0);
            }
            else if(!dq.isEmpty()){
                list.add(arr[dq.peekFirst()]);
            }
            
        }
        return list;
        
    }
}