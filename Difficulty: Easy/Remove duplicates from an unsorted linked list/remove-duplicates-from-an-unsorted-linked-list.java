import java.util.*;
class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        // Your code here
        if(head==null ||head.next==null){
            return head;
        }
        Set<Integer>set=new LinkedHashSet<>();
        Node temp=head;
        while(temp!=null){
            set.add(temp.data);
            temp=temp.next;
        }
        temp=head;
        Node prev=null;
        for(int i:set){
            temp.data=i;
            prev=temp;
            temp=temp.next;
        }
        
   prev.next=null;
        
        return head;
    }
}



          
