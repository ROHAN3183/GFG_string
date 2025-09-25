class Solution {
    public int longestUniqueSubstr(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        
        int i=0;
        int j=0;
        int n=s.length();
        int max=Integer.MIN_VALUE;
        
        while(j<n){
            
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
        
            
            while(i<j && map.get(ch)>1){
                    
                int freq=map.get(s.charAt(i));
                    if(freq==1){
                        map.remove(s.charAt(i));
                    }
                    else{
                        map.put(s.charAt(i),freq-1);
                    }
                i++;
            }    
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}