import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abhinavdas on 1/24/17.
 */
public class BinaryOuroboros {
    public void nthkth()
    {
        Scanner sc=new Scanner(System.in);
        int n=(int)sc.nextInt();
        int k=(int)sc.nextInt();
        if(n==1)
        {
            if(k==0)
                System.out.println("0");
            else
                System.out.println("1");
        }
        if(n==0)
        {
            System.out.println("0");
        }
        StringBuilder sb=new StringBuilder("01");
        for(int i=2 ;i<=n; i++)
        {
            StringBuilder temp = new StringBuilder(sb);
            temp.append(sb.substring((sb.length()/2)));
            temp.append(sb.substring(0,sb.length()/2));
            sb=temp;
        }
        System.out.println(sb.toString().charAt(k-1));
    }
}
