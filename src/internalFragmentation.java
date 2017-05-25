import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by abhinavdas on 1/24/17.
 */
public class internalFragmentation {
    public void numFragments()
    {
        Scanner sc=new Scanner(System.in);
        int numFiles=(int)sc.nextInt();
        BigInteger num=new BigInteger("0");
        int[] sizes=new int[numFiles];
        for(int i=0; i<numFiles; i++)
        {
            sizes[i]=(int)sc.nextInt();
        }
        int segment=(int)sc.nextInt();
        BigInteger seg= new BigInteger(Integer.toString(segment));
        BigInteger result= new BigInteger("0");
        BigInteger one= new BigInteger("0");
        for(int i=0; i<numFiles; i++)
        {
            int count= sizes[i]/segment;
            sizes[i]=sizes[i]%segment;
            if(sizes[i]>0)
                count++;
            one=seg.multiply(new BigInteger(Integer.toString(count)));
            result=result.add(one);
        }
        System.out.println(result);
    }
}
