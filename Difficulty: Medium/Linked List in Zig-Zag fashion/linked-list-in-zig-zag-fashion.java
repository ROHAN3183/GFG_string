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
        ArrayList<Integer>list=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        Collections.sort(list);
        temp=head;
        int i=0;
        int j=list.size()-1;
       boolean flag=false;
        while(temp!=null && i<j){
            if(!flag){
                temp.data=list.get(i);
                i++;
            }
            else{
                temp.data=list.get(j);
                j--;
            }
            flag=!flag;
            temp=temp.next;
        }
        
         if (temp != null && i==j) {
            temp.data = list.get(i);
        }
        
        return head;
    }
}