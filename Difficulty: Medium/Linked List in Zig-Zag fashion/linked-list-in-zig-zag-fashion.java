//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {

    static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static boolean checkZigZag(Node head) {
        if (head == null || head.next == null)
            return true; // Empty list or single node is considered zigzag

        boolean flag = true; // True indicates "<" relation is expected, false indicates
                             // ">" relation
        Node curr = head;

        while (curr.next != null) {
            if (flag) {
                // Check for a < b
                if (curr.data > curr.next.data) {
                    return false;
                }
            } else {
                // Check for a > b
                if (curr.data < curr.next.data) {
                    return false;
                }
            }
            // Toggle flag for next relation
            flag = !flag;
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline character after reading t

        while (t-- > 0) {
            String input = sc.nextLine();
            Scanner s = new Scanner(input);
            Node head = null, tail = null;
            boolean isFirst = true;

            while (s.hasNext()) {
                int x = s.nextInt();
                if (isFirst) {
                    head = new Node(x);
                    tail = head;
                    isFirst = false;
                } else {
                    tail.next = new Node(x);
                    tail = tail.next;
                }
            }
            s.close();

            Solution ob = new Solution();
            Node ans = ob.zigZag(head);
            if (checkZigZag(ans)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            // print(ans);
            // System.out.println();
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends


/*Node is as follows:

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    Node zigZag(Node head) {
        // add code here.
        Node current =head.next;
        Node prev=head;
        boolean flag=true;
        while(current!=null){
            if(flag){
                if(prev.data>=current.data){
                    int x=prev.data;
                    prev.data=current.data;
                    current.data=x;
                }
            }
            else{
                if(prev.data<=current.data){
                    int x=prev.data;
                    prev.data=current.data;
                    current.data=x;
                }
            }
            flag=!flag;
            prev=prev.next;
            current=current.next;
        }
        return head;
        
    }
}