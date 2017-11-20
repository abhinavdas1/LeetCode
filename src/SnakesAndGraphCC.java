import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhinavdas on 5/31/17.
 */
public class SnakesAndGraphCC {
    public static void main (String[] args) throws IOException
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            String[] entry = br.readLine().split(" ");
            int num = Integer.parseInt(entry[0]);
            int inputs = Integer.parseInt(entry[1]);

            int[] degree = new int[num];


            for (int j = 0; j < inputs; j++) {
                String[] inputStr = br.readLine().trim().split(" ");
                degree[Integer.parseInt(inputStr[0])]++;
                degree[Integer.parseInt(inputStr[0])]++;
            }
        }


    }
}
