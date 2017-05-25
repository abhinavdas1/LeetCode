/**
 * Created by abhinavdas on 1/30/17.
 */
public class maxElement {
    public void getMax(int a, int b)
    {
        int sa=sign(a);
        int sb=sign(b);
        int k=sign(a-b);
        int same=sa^sb;
        int signtouse=sa*same + k*flip(same);
        int j=flip(signtouse);
        System.out.println(a*signtouse+b*j);
    }
    public int sign(int a)
    {
        return flip(a>>31 & 0x1);
    }
    public int flip(int a)
    {
        return a^1;
    }
}
