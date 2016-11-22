import java.util.*;

class ValidTime {
    public String checkTime(int A, int B, int C, int D) {
        // write your code in Java SE 8
        String result=new String("");
        ArrayList<Integer> l=new ArrayList<Integer>();
        int max=-1,fd=-1;
        l.add(A);
        l.add(B);
        l.add(C);
        l.add(D);
        for(int i:l)
        {
            if(i>max && i<=2 )
            {
                max=i;
            }
        }
        l.remove(new Integer(max));
        if(max==-1)
            return "NOT POSSIBLE";
        result=result + max;
        fd=max;
        max=-1;
        if(fd==1 || fd==0)
        {
            for(int i:l)
            {
                if(i>max && i<10)
                {
                    max=i;
                }
            }
        }
        else
        {
            for(int i:l)
            {
                if(i>max && i<=3 )
                {
                    max=i;
                }
            }

        }
        if(max==-1)
            return "NOT POSSIBLE";
        result= result + max + ":";
        l.remove(new Integer(max));
        max=-1;
        for(int i:l)
        {
            if(i>max && i<=5 )
            {
                max=i;
            }
        }
        l.remove(new Integer(max));
        if(max==-1)
            return "NOT POSSIBLE";
        result=result + max;
        max=-1;
        if(l.get(0)<10)
        {
            result=result + l.remove(0);
        }
        else
            return "NOT POSSIBLE";
        return result;

    }
}