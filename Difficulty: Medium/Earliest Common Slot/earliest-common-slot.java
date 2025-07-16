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
