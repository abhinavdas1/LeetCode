/**
 * Created by abhinavdas on 1/13/17.
 */
public class subStrRecurs {
    public int getNum(String s,String t)
    {
        int count=0;
        while(s.contains(t))
        {
            int start=s.indexOf(t);
            int end=start+t.length()-1;
            if(t.length()>1)
            {
                if (end + 1 < s.length())
                    s = s.substring(0, start) + s.substring(end + 1);
                else
                    s = s.substring(0, start);
            }
            else
                s=s.replaceFirst(t,"");
            count++;
        }

        return count;
    }
}
