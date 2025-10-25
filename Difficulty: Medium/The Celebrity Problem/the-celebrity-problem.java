class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        boolean possibility=false;
        int target=-1;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j!=i &&mat[i][j]==1){
                    adj.get(i).add(j);
                }
            }
            if(adj.get(i).size()<=0){
                target=i;
                count++;
                if(count>1){
                    return -1;
                }
            }    
        }
        if(count==1){
            for(int i=0;i<n;i++){
                if(i==target){
                    continue;
                }
                if(!adj.get(i).contains(target)){
                    return -1;
                }
            }
        }
        return target;
        
    }
}