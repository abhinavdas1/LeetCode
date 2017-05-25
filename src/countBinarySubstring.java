/**
 * Created by abhinavdas on 1/27/17.
 */
public class countBinarySubstring {
    public void binary(String s)
    {
        int count=0;
        String temp=s;
        while(temp.contains("01"))
        {
            temp=temp.replaceFirst("01","");
            count++;
        }
        temp=s;
        while(temp.contains("10"))
        {
            temp=temp.replaceFirst("10","");
            count++;
        }
        System.out.print( count);
    }
}
