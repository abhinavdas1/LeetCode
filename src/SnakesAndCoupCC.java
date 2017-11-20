import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhinavdas on 5/31/17.
 */
public class SnakesAndCoupCC {
    public static void main (String[] args) throws IOException
    {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {

            int n = Integer.parseInt(br.readLine());

            int[][] mat = new int[2][n];
            int[] flag = new int[2];

            for(int k  = 0; k < 2; k++)
            {
                char[] inputStr = br.readLine().toCharArray();
                for (int j = 0; j < inputStr.length; j++) {
                    mat[k][j] = inputStr[j]=='*' ? 1 : 0;
                    if(flag[k] == 0 && mat[k][j] == 1)
                    {
                        flag[k] = 1;
                    }
                }
            }

            int[] walls = new int[n-1];
            int count = 0, horWall= mat[0][0] == mat[1][0] && mat[0][0]== 1 ? 1 : 0 ;

            if(flag[0] == 1 && flag[1] == 1)
                horWall = 1;

            for(int j  = 1; j < n; j++)
            {
                if((mat[0][j] == 1 && mat[0][j-1] ==1) || (mat[1][j] == 1 && mat[1][j-1] ==1))
                {
                    walls[j-1] = 1;
                    count++;
                }

                if(mat[0][j] == mat[1][j] && mat[0][j] == 1 && horWall!= 1)
                {
                    horWall = 1;
                }
            }

            if(horWall != 1)
            {
                for (int j = 1; j < n - 1; j++) {
                    if (mat[0][j] == 1) {
                        if (mat[1][j - 1] == 1 && walls[j - 1] != 1) {
                            horWall = 1;
                            break;
                        }
                        if (mat[1][j + 1] == 1 && walls[j] != 1) {
                            horWall = 1;
                            break;
                        }
                    }

                    if (mat[1][j] == 1) {
                        if (mat[0][j - 1] == 1 && walls[j - 1] != 1) {
                            horWall = 1;
                            break;
                        }
                        if (mat[0][j + 1] == 1 && walls[j] != 1) {
                            horWall = 1;
                            break;
                        }
                    }
                }
            }
            if(n == 2 && walls[0] == 0 && horWall == 0)
            {
                if((mat[0][0] == 1 && mat[1][1] == 1) ||(mat[0][1] == 1 && mat[1][0] == 1)) {
                    walls[0]++;
                    count++;
                }
            }

            int hissT = mat[0][0], hissB = mat[1][0];

            for(int j = 1; j < n; j++)
            {
                if(walls[j - 1] == 1)
                {
                    hissB = hissT = 0;
                }
                if((hissT == 1 && mat[0][j] == 1) || (hissB == 1 && mat[1][j] == 1))
                {
                    count++;
                    hissT = hissB = 0;
                }
                hissT = mat[0][j] == 1 ? 1 : hissT;
                hissB = mat[1][j] == 1 ? 1 : hissB;

            }

            System.out.println(count + horWall);

        }


    }
}
