import java.math.BigInteger;

/**
 * Created by abhinavdas on 11/18/16.
 */
public class maxProduct {
    public String getprod(int[] xs)
    {
        if(xs.length==0)
            return null;
        if(xs.length==1) {
            return Integer.toString(xs[0]);
        }
        BigInteger maxp=new BigInteger(Integer.toString(1)),maxn=new BigInteger(Integer.toString(1));
        int min=Integer.MIN_VALUE,flag=0;
        int count=0,count1=0;
        for(int i=0; i<xs.length; i++)
        {
            if(xs[i]>0)
            {
                maxp=maxp.multiply(new BigInteger(Integer.toString(xs[i])));
                flag=1;
            }
            else if(xs[i]<0) {
                count++;
                if (xs[i] > min)
                    min = xs[i];
                maxn=maxn.multiply(new BigInteger(Integer.toString(xs[i]*-1)));
            }
            else if(xs[i]==0)
            {
                count1++;
            }
        }
        if(count1==xs.length)
        {
            return "0";
        }
        if(count%2==0)
            return maxp.multiply(maxn) + "";
        else
        {
            if(flag==0 && count==1)
            {
                return "0";
            }

            return maxp.multiply(maxn).divide(new BigInteger(Integer.toString(-1 * min))) + "";

        }
    }
}
