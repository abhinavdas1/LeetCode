/**
 * Created by abhinavdas on 11/26/17.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.HashMap;

public class SequenceAlignAffineGap {

    enum direction{
        A,
        B,
        M
    }

    class matrix
    {
        int value;
        direction dir;
        boolean flag;
    }

    public static HashMap<Character, Integer> alphabetMap;
    static char[] alphabet;
    static int[][] mat;
    public static void main(String [] args)
    {
        alphabetMap = new HashMap<Character, Integer>();
        getAlphabet("alphabet.txt");
        getMat("scoringmatrix.txt");

        SequenceAlignAffineGap temp = new SequenceAlignAffineGap();

        temp.globalAlign("castg", "cat", -7, -15);

    }

    public void globalAlign(String A, String B, int gapE, int gapS)
    {
        char[] strA = A.toCharArray();
        char[] strB = B.toCharArray();

        matrix[][] match = new matrix[strA.length + 1][strB.length + 1];
        matrix[][] gapA = new matrix[strA.length + 1][strB.length + 1];
        matrix[][] gapB = new matrix[strA.length + 1][strB.length + 1];


        for(int i = 0; i < match.length; i++) {
            for (int j = 0; j < match[0].length; j++) {
                match[i][j] = new matrix();
                gapA[i][j] = new matrix();
                gapB[i][j] = new matrix();
            }
        }

        for(int i = 1; i < match.length; i++)
        {
            match[i][0].value = (gapS + gapE * (i));
        }

        for(int i = 1; i < match[0].length; i++)
        {
            match[0][i].value = (gapS + gapE * (i));
        }

        for(int i = 1; i < match.length; i++)
        {
            gapA[i][0].value = (gapS + gapE * (i));
        }

        for(int i = 1; i < match[0].length; i++)
        {
            gapA[0][i].value = Integer.MIN_VALUE;
        }

        for(int i = 1; i < match.length; i++)
        {
            gapB[i][0].value = Integer.MIN_VALUE;
        }

        for(int i = 1; i < match[0].length; i++)
        {
            gapB[0][i].value = (gapS + gapE * (i));
        }


        for(int i = 1; i < match.length; i++)
        {
            for(int j = 1; j < match[0].length; j++)
            {
                //compute match[i][j]

                int temp = Math.max(gapA[i - 1][j - 1].value, gapB[i - 1][j - 1].value);

                match[i][j].value = mat[alphabetMap.get(strA[i - 1])][alphabetMap.get(strB[j - 1])] + Math.max(temp, match[i -1][j -1].value);

                if(gapA[i - 1][j - 1].value > gapB[i - 1][j - 1].value && gapA[i - 1][j - 1].value > match[i -1][j -1].value)
                {
                    match[i][j].dir = direction.A;
                }
                else if(gapB[i - 1][j - 1].value > gapA[i - 1][j - 1].value && gapB[i - 1][j - 1].value > match[i -1][j -1].value)
                {
                    System.out.println(match[i][j].value + " " + gapB[i - 1][j - 1].value + " " + mat[alphabetMap.get(strA[i - 1])][alphabetMap.get(strB[j - 1])]);
                    match[i][j].dir = direction.B;
                }
                else
                {
                    match[i][j].dir = direction.M;
                }


                //compute gapA[i][j]

                temp = gapS + Math.max(match[i][j - 1].value, gapB[i][j - 1].value);

                gapA[i][j].value = gapE + Math.max(gapA[i][j - 1].value, temp);

                if(gapA[i][j - 1].value > gapB[i][j - 1].value + gapS && gapA[i][j - 1].value > match[i][j -1].value + gapS)
                {
                    gapA[i][j].dir = direction.A;
                }
                else if(gapB[i][j - 1].value + gapS > gapA[i][j - 1].value && gapB[i][j - 1].value > match[i][j -1].value)
                {
                    gapA[i][j].dir = direction.B;
                }
                else
                {
                    gapA[i][j].dir = direction.M;
                }


                //compute gapB[i][j]

                temp = gapS + Math.max(match[i - 1][j].value, gapA[i - 1][j].value);

                gapB[i][j].value = gapE + Math.max(gapB[i - 1][j].value, temp);

                if(gapA[i - 1][j].value + gapS > gapB[i - 1][j].value && gapA[i - 1][j].value > match[i -1][j].value)
                {
                    gapB[i][j].dir = direction.A;
                }
                else if(gapB[i - 1][j].value > gapA[i - 1][j].value  + gapS && gapB[i - 1][j].value > match[i -1][j].value  + gapS)
                {
                    gapB[i][j].dir = direction.B;
                }
                else
                {
                    gapB[i][j].dir = direction.M;
                }

            }
        }

        System.out.println();


    }

    public static void getAlphabet(String file)
    {
        try{
            BufferedReader in     = new BufferedReader( new FileReader( file ) );
            StringBuffer   buffer = new StringBuffer();
            String         line   = in.readLine().toLowerCase();

            alphabet = line.toCharArray();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        alphabetMap = new HashMap<Character, Integer>();

        for(int i = 0; i < alphabet.length; i++)
        {
            alphabetMap.put(alphabet[i], i);
        }
    }

    public static void getMat(String file)
    {
        try{

            mat = new int[alphabet.length][alphabet.length];

            BufferedReader in     = new BufferedReader( new FileReader( file ) );
            StringBuffer   buffer = new StringBuffer();


            for(int i = 0; i < alphabet.length; i++)
            {
                String[] line   = in.readLine().split(" +");
                int count = 0;
                for(int j = 0; j < line.length; j++)
                {
                    mat[i][j] = Integer.parseInt(line[j]);
                }

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
