//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer>stack=new Stack<>();
        ArrayList<Integer>list=new ArrayList<>();
        int m=arr.length;
        int j=m-1;
        while(j>=0){
            if(!stack.isEmpty()){
                if(stack.peek()>arr[j]){
                    list.add(stack.peek());
                    stack.push(arr[j]);
                }
                else{
                    while(!stack.isEmpty()&&stack.peek()<=arr[j]){
                        stack.pop();
                    }
                    if(!stack.isEmpty()&&stack.peek()>arr[j]){
                        list.add(stack.peek());
                        stack.push(arr[j]);
                        
                    }
                    else{
                        stack.push(arr[j]);
                        list.add(-1);
                    }
                }
            }
            else{
                list.add(-1);
                stack.push(arr[j]); 
            }
            
            j--;
        }
        Collections.reverse(list);
        return list;
    }
}