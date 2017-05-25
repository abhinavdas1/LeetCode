import java.util.*;

public class TempleLandCC {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int numStrips = Integer.parseInt(sc.nextLine());

        while(numStrips > 0)
        {
            numStrips--;
            int count = Integer.parseInt(sc.nextLine());

            String[] heights = sc.nextLine().split(" ");

            if(count % 2 == 0)
                System.out.println("no");
            else if(checkStrips(count, heights))
            {
                System.out.println("yes");
            }
            else
                System.out.println("no");

        }
    }

    public static boolean checkStrips(int count, String[] heights)
    {

        int mid = (int) Math.ceil((double)count / 2);

        for(int i = 1; i <= mid; i++)
        {
            if(i != Integer.parseInt(heights[i-1]))
                return false;
        }

        for(int i = mid; i>=1; i--)
        {
            if(i != Integer.parseInt(heights[count - i]))
                return false;
        }

        return true;
    }
}
