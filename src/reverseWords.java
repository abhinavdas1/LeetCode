/**
 * Created by abhinavdas on 1/7/17.
 */
import java.util.*;
public class reverseWords {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words=s.split(" ");
        Stack<String> stk=new Stack<String>();
        for(String n: words)
        {
            if(!n.equals(""))
            stk.push(n);
        }
        StringBuilder sb=new StringBuilder();
        while(stk.size()>1)
        {
            sb.append(stk.pop() + " ");
        }
        if(stk.size()>0)
            sb.append(stk.pop());
        return sb.toString();
    }
}
