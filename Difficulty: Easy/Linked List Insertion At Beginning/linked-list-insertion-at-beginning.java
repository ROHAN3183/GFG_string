//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    public Node insertAtBegining(Node head, int x) {
        // Code here
        Node newnode=new Node(x);
        newnode.next=head;
        head=newnode;
        return head;
        
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            ArrayList<Integer> arr = new ArrayList<>();
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int x = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.insertAtBegining(head, x);
            printList(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends