                                        Logic of code
1) just think about the monotonic stack(non decreasing) property is that it always have the 
2) The top element is always the smallest in the stack.
3) apply same logic here if the coming element is larger then the peep element then pop out the element also add span value of the
    that element.

#1 
    class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer>list=new ArrayList<>(); 
        Stack<int[]> stack=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int span=1;
            while(!stack.isEmpty() && stack.peek()[0]<=arr[i]){
                span=span+stack.pop()[1];
            }
            stack.push(new int[]{arr[i],span});
            list.add(span);
            
        }
        return list;
    }
}

#2
    class StockSpanner {
    private Stack<Pair<Integer, Integer>> stack; 
    public StockSpanner() {
        stack=new Stack();
    }
    
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty() && stack.peek().getKey()<=price){
            span=span+stack.peek().getValue();
            stack.pop();
        }
        stack.push(new Pair<>(price,span));
        return span;
    }
}

    
    
