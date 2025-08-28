class Solution {
   static class Pair{
    char ch ;
    int freq;
    Pair(char ch , int freq){
        this.ch=ch;
        this.freq=freq;
    }
}

    public static String reduced_String(int k, String s) {
        Stack<Pair>stack=new Stack<>();
        int n =s.length();
        int i=0;
        while(i<n){
        if(stack.isEmpty()){
            stack.push(new Pair(s.charAt(i),1));
            if(k==1){
            stack.pop();

            }
            i++;
            continue;
        }
        if(!stack.isEmpty() && stack.peek().ch!=s.charAt(i)){
            stack.push(new Pair(s.charAt(i),1));
        }
        else if(!stack.isEmpty() && stack.peek().ch==s.charAt(i)){
            int count = stack.peek().freq;
            if(count==k){
                stack.pop();
                stack.push(new Pair(s.charAt(i),1));
            }
            else if((count+1)==k){
                stack.pop();
            }
            else{
               Pair pair= stack.pop();
               int newCount=pair.freq;
               stack.push(new Pair(s.charAt(i),newCount+1));
            }
        }
        i++;
        
    }
    StringBuilder str =new StringBuilder();
    while(!stack.isEmpty()){
        for(int j=0;j<stack.peek().freq;j++){
            str.append(stack.peek().ch);
        }
        stack.pop();
    }
    return str.reverse().toString();
        
    }
}