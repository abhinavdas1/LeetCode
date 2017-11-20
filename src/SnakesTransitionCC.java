import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhinavdas on 5/31/17.
 */
public class SnakesTransitionCC {
    public static void main(String[] args) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++)
        {
            String[] dim = br.readLine().trim().split(" ");
            int row = Integer.parseInt(dim[0]);
            int col = Integer.parseInt(dim[1]);
            int[][] m = new int[row][col];
            int[][] flag = new int[row][col];

            int hours = 0;
            int max = 0;
            Queue<Integer[]> q = new LinkedList<Integer[]>();

            for (int j = 0; j < row; j++)
            {
                String[] temp = br.readLine().trim().split(" ");
                for (int k = 0; k < col; k++)
                {
                    m[j][k] = Integer.parseInt(temp[k]);
                    if(m[j][k] >= max)
                    {
                        if(m[j][k] > max)
                        {
                            q.clear();
                            max = m[j][k];
                            flag = new int[row][col];
                        }
                        q.add(new Integer[]{j,k});
                        flag[j][k] = -1;
                    }
                }
            }

            if(q.size() == m.length * m[0].length)
            {
                System.out.println(hours);
                continue;
            }

            while(!q.isEmpty())
            {

                    Integer[] arr = q.poll();
                    increaseNeighbors(arr[0], arr[1], max, m, flag, 0);

            }


            hours = -1;

            for (int j = 0; j < row; j++)
            {
                for (int k = 0; k < col; k++) {
                    if(flag[j][k] > hours)
                        hours = flag[j][k];
                }
            }

            System.out.println(hours);

        }
    }


    public static void increaseNeighbors(int j, int k, int max, int[][] m, int[][] flag, int step)
    {

        if(j > 0 && flag[j-1][k] != -1)
        {
            if(flag[j-1][k] > step + 1 || flag[j-1][k] == 0)
            {
                flag[j-1][k] = step + 1;
                increaseNeighbors(j-1, k, max, m, flag, step + 1);
            }
        }
        if(k > 0 && flag[j][k-1] != -1)
        {
            if(flag[j][k-1] > step + 1 || flag[j][k-1] == 0)
            {
                flag[j][k-1] = step + 1;
                increaseNeighbors(j, k-1, max, m, flag, step + 1);
            }
        }
        if(j < m.length - 1 && flag[j+1][k] != -1)
        {
            if(flag[j+1][k] > step + 1 || flag[j + 1][k] == 0)
            {
                flag[j + 1][k] = step + 1;
                increaseNeighbors(j + 1, k, max, m, flag, step + 1);
            }
        }
        if(k < m[0].length - 1 && flag[j][k+1] != -1)
        {
            if(flag[j][k + 1] > step + 1 || flag[j][k + 1] == 0)
            {
                flag[j][k + 1] = step + 1;
                increaseNeighbors(j, k + 1, max, m, flag, step + 1);
            }
        }

        if(j > 0 && k > 0 && flag[j - 1][k - 1] != -1)
        {
            if(flag[j - 1][k - 1] > step + 1 || flag[j - 1][k - 1] == 0)
            {
                flag[j - 1][k - 1] = step + 1;
                increaseNeighbors(j - 1, k - 1, max, m, flag, step + 1);
            }
        }
        if(j > 0 && k < m[0].length - 1 && flag[j-1][k+1] != -1)
        {
            if(flag[j-1][k+1] > step + 1 || flag[j-1][k+1] == 0)
            {
                flag[j-1][k+1] = step + 1;
                increaseNeighbors(j - 1, k + 1, max, m, flag, step + 1);
            }
        }
        if(j < m.length - 1 && k > 0 && flag[j+1][k-1] != -1)
        {
            if(flag[j+1][k-1] > step + 1 || flag[j+1][k-1] == 0)
            {
                flag[j+1][k-1] = step + 1;
                increaseNeighbors(j + 1, k - 1, max, m, flag, step + 1);
            }
        }
        if(j < m.length - 1 && k  < m[0].length - 1 && flag[j+1][k+1] != -1)
        {
            if(flag[j+1][k+1] > step + 1 || flag[j+1][k+1] == 0)
            {
                flag[j+1][k+1] = step + 1;
                increaseNeighbors(j + 1, k + 1, max, m, flag, step + 1);
            }
        }

    }


}

