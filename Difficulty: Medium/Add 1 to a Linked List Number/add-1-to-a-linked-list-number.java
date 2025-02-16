//{ Driver Code Starts
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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        if(head==null){
            return head;
        }
        Node reversed_linklist=reverse(head);
        Node dummy =new Node(-1);
        Node prev=dummy;
        boolean flag=true;
        int carry=1;
        int sum=0;
        while(reversed_linklist!=null||carry>0){
            
         sum=carry;
         if(reversed_linklist!=null){
            sum=sum+reversed_linklist.data;
            reversed_linklist=reversed_linklist.next;
         }
         prev.next=new Node(sum%10);
         prev=prev.next;
         carry=sum/10;
        }
        Node result_head=reverse(dummy.next);
        return result_head;
    }
    private Node reverse(Node head){
        Node current=head;
        Node prev=null;
        while(current!=null){
          Node x=current.next;
            current.next=prev;
            prev=current;
            current=x;
        }
        return prev;
    }
}
