/**
 * Created by abhinavdas on 1/24/17.
 */
import java.util.Scanner;
public class Chocolate {
    public void countChocolates()
    {
        Scanner sc=new Scanner(System.in);
        int price=(int)sc.nextInt();
        int wrappers=(int)sc.nextInt();
        int numF=(int)sc.nextInt();
        int[] friends=new int[numF];
        for(int i=0; i<numF; i++) {
            friends[i]=(int)sc.nextInt();
        }
        for(int i=0; i<numF; i++)
        {
            int count=0;
            int curr_wrap=0;
            if(friends[i]>=price)
            {
                    int temp = friends[i]/price;
                    friends[i]=friends[i]%price;
                    curr_wrap=curr_wrap+temp;
                    count=count+temp;
            }
            while(curr_wrap>=wrappers) {
                count = count + curr_wrap / wrappers;
                int temp=curr_wrap%wrappers ;
                curr_wrap=curr_wrap/wrappers + temp;
            }
            System.out.println(count);
        }
    }
}
