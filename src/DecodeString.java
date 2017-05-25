/**
 * Created by abhinavdas on 11/3/16.
 */
import java.util.*;
public class DecodeString {
    public String decodeString(String s) {
        int n=s.length();
        Stack<String> st= new Stack<String>();
        Stack<Integer> sn= new Stack<Integer>();
        String len=new String("");
        String snum=new String("");
        for(int i=0; i<n; i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                snum= snum + s.charAt(i);
                if(Character.isDigit(s.charAt(i+1)))
                    continue;
                else
                {
                    sn.push(Integer.parseInt(snum));
                    snum="";
                    continue;
                }
            }
            else if(s.charAt(i)=='[')
                st.push(Character.toString(s.charAt(i)));
            else if(s.charAt(i)!=']' && s.charAt(i)!='[')
            {
                len = len + s.charAt(i);
                if(s.charAt(i+1)==']' || s.charAt(i+1)=='[' || Character.isDigit(s.charAt(i+1)))
                {
                    st.push(len);
                    len="";
                }
                continue;
            }
            else if(s.charAt(i)==']')
            {
                int count=sn.pop();
                String temp=new String("");
                while(!st.peek().equals("["))
                {
                    temp=st.pop() + temp;
                }
                String temp1=new String("");
                for(int j=0; j<count; j++)
                    temp1=temp1 + temp;
                st.pop();
                st.push(temp1);
            }


        }
        String a=new String();
        while(!st.isEmpty())
        {
            a=st.pop() + a;
        }
        return a;
    }
}
