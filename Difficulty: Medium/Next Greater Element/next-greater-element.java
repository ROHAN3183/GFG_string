                                
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> list =new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                list.add(-1);
                stack.push(arr[i]);
            }
            else{
                if(!stack.isEmpty()&& stack.peek()<=arr[i]){
                    while(!stack.isEmpty() &&stack.peek()<=arr[i] ){
                        stack.pop();
                    }
                    if(!stack.isEmpty()){
                        list.add(stack.peek());
                    }
                    else{
                        list.add(-1);
                    }
                    stack.push(arr[i]);
                }
                else{
                    list.add(stack.peek());
                    stack.push(arr[i]);
                }
            }
        }
        Collections.reverse(list);
        return list;
    }
}
