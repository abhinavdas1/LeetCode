import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by abhinavdas on 8/29/17.
 */
public class MSFT2017two {
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
                String[] nums = col.split("");

                columns = nums.length;

            }
            a = new int[rows][columns];

            input.close();


            input = new Scanner(inp);
            for(int i = 0; i < rows; ++i)
            {
                String n = input.nextLine();
                String[] nums = n.split("");
                for(int j = 0; j < columns; ++j)
                {
                    a[i][j] = Integer.parseInt(nums[j]);
                }
            }


            for(int i = 0; i < a.length; i++)
            {
                for(int j = 0; j < a[0].length; j++)
                {
                    if(a[i][j] == 0)
                    {
                        if(countNeighbours(a, i, j) > 1)
                        {
                            a[i][j] = 1;

                            if(i >= 1 && a[i-1][j] ==0)
                            {
                                checkAndUpdate(a, i -1, j);
                            }
                            if(j >= 1 && a[i][j-1] ==0)
                            {
                                checkAndUpdate(a, i, j-1);
                            }
                            if(i < a.length - 1 && a[i+1][j] ==0)
                            {
                                checkAndUpdate(a, i+1, j);
                            }
                            if(j < a[0].length - 1 && a[i][j+1] == 0)
                            {
                                checkAndUpdate(a, i, j+1);
                            }

                        }

                    }

                }
            }

            for(int i = 0; i < a.length; i++)
            {
                for(int j = 0; j < a[0].length; j++)
                {
                        System.out.print(a[i][j]);
                }

                if(i != a.length - 1)
                    System.out.println();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void checkAndUpdate(int[][] mat, int i, int j)
    {
        if(countNeighbours(mat, i, j) > 1)
        {
            mat[i][j] = 1;

            if(i >= 1 && mat[i-1][j] ==0)
            {
                checkAndUpdate(mat, i -1, j);
            }
            if(j >= 1 && mat[i][j-1] ==0)
            {
                checkAndUpdate(mat, i, j-1);
            }
            if(i < mat.length - 1 && mat[i+1][j] ==0)
            {
                checkAndUpdate(mat, i+1, j);
            }
            if(j < mat[0].length - 1 && mat[i][j+1] == 0)
            {
                checkAndUpdate(mat, i, j+1);
            }

        }

    }

    public static int countNeighbours(int[][] mat, int i , int j)
    {
        int sum = 0;

        if(i >= 1)
        {
            sum = sum + mat[i-1][j];
        }
        if(j >= 1)
        {
            sum = sum + mat[i][j-1];
        }
        if(i < mat.length - 1)
        {
            sum = sum + mat[i+1][j];
        }
        if(j < mat[0].length - 1)
        {
            sum = sum + mat[i][j + 1];
        }
        return sum;
    }
}
