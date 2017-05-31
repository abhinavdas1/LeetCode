import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ATempleOfSnakes {

    public static void main(String[] args) throws IOException{
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int[] rmax;
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++)
        {
            int numOfinputs = Integer.parseInt(br.readLine());
            String[] inputStr = br.readLine().trim().split(" ");
            int[] input = new int[numOfinputs];
            rmax = new int[input.length];
            int sum = 0;

            for (int j = 0; j < input.length; j++) {
                input[j] = Integer.parseInt(inputStr[j]);
                sum = sum + input[j];
                if(j == 0 || input[j] == 1)
                    rmax[j] = 1;
                else if(input[j] > input[j - 1] || ((input[j] == input[j-1]) && input[j] > rmax[j-1]))
                {
                    rmax[j] = rmax[j-1] + 1;
                }
                else
                {
                    rmax[j] = Math.min(input[j], rmax[j-1] + 1);
                }
            }



            int maxLength = 0, prevLen = 1;

            for (int j = input.length - 2; j >= 0; j--)
            {
                if(input[j] == 1)
                    prevLen = 1;
                else if(input[j+1] < input[j] || ((input[j+1] == input[j]) && input[j] > prevLen))
                {
                    prevLen++;
                }
                else
                {
                    prevLen = Math.min(input[j], prevLen + 1);
                }

                maxLength = Math.max(maxLength, Math.min(prevLen,rmax[j]));
            }
            maxLength = 2 * maxLength - 1;
            int pyramidSum = (maxLength/2 + 1)*(maxLength/2 + 1);
            System.out.println(sum - pyramidSum);

        }
    }

}