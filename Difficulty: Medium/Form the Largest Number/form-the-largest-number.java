//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] numbers = input.split(" ");
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }

            Solution ob = new Solution();
            String ans = ob.findLargest(arr);
            System.out.println(ans);
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends




class Solution {
    String findLargest(int[] arr) {
       
        int n=arr.length;
        String []strArray=new String[n];
        
        for(int i=0;i<n;i++){
            strArray[i]=Integer.toString(arr[i]);
        }
        
        Arrays.sort(strArray,(a,b)->(b+a).compareTo(a+b));
        
        StringBuilder result=new StringBuilder();
        
        if (strArray[0].equals("0")) {
            return "0";
        }
        
        for(int i=0;i<n;i++){
            

            result.append(strArray[i]);
        }
        return result.toString();
        
    }
}