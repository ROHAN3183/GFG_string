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
