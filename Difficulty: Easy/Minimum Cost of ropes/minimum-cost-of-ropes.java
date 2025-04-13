//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int[] a = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        int n=arr.length;
        int min_cost=0;
        
        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
        }
        
        while(minHeap.size()>1){
            
            int peek_1=minHeap.poll();
            int peek_2=minHeap.poll();
            int peek_result=peek_1+peek_2;
            
            minHeap.add(peek_result);
            min_cost=min_cost+peek_result;
        }
        
        return min_cost;
        
    }
}