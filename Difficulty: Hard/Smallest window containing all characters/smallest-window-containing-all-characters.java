class Solution {
    public static String smallestWindow(String s, String p) {
        HashMap<Character,Integer>mapS=new HashMap<>();
        HashMap<Character,Integer>mapP=new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            mapP.put(p.charAt(i),mapP.getOrDefault(p.charAt(i),0)+1);
            
        }
        
        int [] result = new int [2];
        int n = s.length();
        result[0]=-1;
        result[1]=n+1;
        
        int i=0;
        int j=0;
        int count =0;
        
        while(j<n){
            if(mapP.containsKey(s.charAt(j))){
                mapS.put(s.charAt(j),mapS.getOrDefault(s.charAt(j),0)+1);
                if(mapS.get(s.charAt(j)).equals(mapP.get(s.charAt(j)))){ 
                    count++;
                }
            }
            
            while(count==mapP.size() && i<=j){
                    
                    int size=result[1]-result[0] +1;
                    int newSize =j-i+1;
                    
                    if(result[0] == -1 || size>newSize){
                        result[0]=i;
                        result[1]=j;
                    
                    }
            
                
                if(mapS.containsKey(s.charAt(i))){
                    
                    int freq=mapS.get(s.charAt(i));
                     mapS.put(s.charAt(i),freq-1);
                    
                    if(mapP.containsKey(s.charAt(i))&& freq-1 < mapP.get(s.charAt(i))){
                        count--;
                    }
                }
                
                i++;
            }
            
            j++;
            
        }
        
        if(result[0]==-1 && result[1]==n+1){
            return "";
        }
        return s.substring(result[0],result[1]+1);
    }
}