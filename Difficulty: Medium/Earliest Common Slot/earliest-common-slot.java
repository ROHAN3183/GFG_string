*******************************************************BRUTE FORCE***************************************************************
class Solution {
    public int[] commonSlot(List<int[]> a, List<int[]> b, int d) {
        
        int n2 = b.size();
        int n1 = a.size();
        
        for (int i = 0; i < n2; i++) {
            
            int keyStart = b.get(i)[0];
            int keyEnd = b.get(i)[1];
            
            for (int j = 0; j < n1; j++) {
                int start = Math.max(keyStart, a.get(j)[0]);
                int end = Math.min(keyEnd, a.get(j)[1]);
                
                if(end-start>=d){
                    return new int[]{start,start+d};
                }    
                
                
            }
        }
        return new int[] {};
    }
}
/* LOGIC of the code -> if the ending is small it means that it never come into the future use  so move that pointer*/
********************************************************OPTIMIZED CODE**********************************************************
class Solution {
    public int[] commonSlot(List<int[]> a, List<int[]> b, int d) {
        
        a.sort((x,y)->Integer.compare(x[0],y[0]));
        b.sort((x,y)->Integer.compare(x[0],y[0]));
        
        int n2 = b.size();
        int n1 = a.size();
        int i=0;
        int j=0;
        while(i<n1 && j<n2){
            
            int start=Math.max(a.get(i)[0],b.get(j)[0]);
            int end=Math.min(a.get(i)[1],b.get(j)[1]);
            
            if(end-start>=d){
                return new int[]{start,start+d};
            }
            else{
                if(a.get(i)[1] >b.get(j)[1]){
                    j++;
                }
                else{
                    i++;
                }
            }
        }
        return new int[] {};
    }
}
