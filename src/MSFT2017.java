/**
 * Created by abhinavdas on 8/29/17.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MSFT2017 {
    public static void main(String args[])
    {
        File inp = new File("src/input.txt");
        Scanner sc;
        int[][] a;

        try {
            Scanner input = new Scanner (inp);

            int rows = 0;
            int columns = 0;
            while(input.hasNextLine())
            {
                ++rows;
                String col = input.nextLine();
                String[] nums = col.split(" ");

                columns = nums.length;

            }
            a = new int[rows][columns];

            input.close();


            input = new Scanner(inp);
            for(int i = 0; i < rows; ++i)
            {
                for(int j = 0; j < columns; ++j)
                {
                    if(input.hasNextInt())
                    {
                        a[i][j] = input.nextInt();
                    }
                }
            }


            int m = a.length, n = a[0].length;
            int[][] rvalue = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    rvalue[i][j] = a[j][i];

            for(int i = 0; i < rvalue.length; i++)
            {
                for(int j = 0; j < rvalue[0].length; j++)
                {
                    if(j != rvalue[0].length - 1)
                        System.out.print(rvalue[i][j] + " ");
                    else
                        System.out.print(rvalue[i][j]);
                }

                if(i != rvalue.length - 1)
                    System.out.println();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
