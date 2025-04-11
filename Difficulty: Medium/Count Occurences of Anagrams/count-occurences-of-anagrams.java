//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(String pat, String txt) {
        int n1=pat.length();
        int n2=txt.length();
        HashMap<Character,Integer>map1=new HashMap<>();//pat
        HashMap<Character,Integer>map2=new HashMap<>();//txt
        
        for(int i=0;i<n1;i++){
            char ch=pat.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        
        int i=0;
        int j=0;
        int count=0;
        
        while(j<n2){
            char ch=txt.charAt(j);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(j-i+1==n1){
                if(map1.equals(map2)){
                    count++;
                }
            
            char removechar=txt.charAt(i);
            map2.put(removechar,map2.getOrDefault(removechar,0)-1);
            if(map2.get(removechar)==0){
                map2.remove(removechar);
            }
            i++;
        }
            j++;
        }
        return count;
    }
}