/**
 * Created by abhinavdas on 12/15/16.
 */
import java.math.BigInteger;
public class reduceToOne {
    public static int ans(String n){
        BigInteger num=new BigInteger(n);
        BigInteger zero= new BigInteger("0");
        BigInteger three= new BigInteger("3");
        BigInteger one= new BigInteger("1");
        int count=0;
        while(num.compareTo(BigInteger.valueOf(1)) > 0)
        {
            BigInteger b = num.mod(BigInteger.valueOf(2));
            if(b.equals(zero))
            {
                num=num.divide(BigInteger.valueOf(2));
            }
            else if(num.equals(three) || one.equals(num.mod(BigInteger.valueOf(4))))
            {
                num=num.subtract(BigInteger.valueOf(1));
            }
            else
                num=num.add(BigInteger.valueOf(1));
            count++;
        }
        return count;
    }
}
