//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends
class Solution{
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
        ArrayList<Integer>list=new ArrayList<>();
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
               minHeap.add(arr[i][j]); 
            }
        }
        
        while(!minHeap.isEmpty()){
            list.add(minHeap.poll());
        }
    
    return list;
        
    }
}