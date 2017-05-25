/**
 * Created by abhinavdas on 2/11/17.
 */
public class buddy_bitmap {

    public static void clearBit(boolean[][] matrix, int offset, int length) {

        int curLevel = matrix.length - 1;
        int left = offset;
        int right = offset + length;
        while(curLevel >= 0) {
            for( int i = left;
                 i <= right;
                 i++){
                matrix[curLevel][i] =  false;
            }
            curLevel--;
            left = left / 2;
            right = right / 2;
        }
    }

    public static void setBit(boolean[][] matrix, int offset, int length) {

        int curLevel = matrix.length - 1;
        int left = offset;
        int right = offset + length;
        while(curLevel >= 0) {
            for( int i = left;
                 i <= right;
                 i++){
                if(curLevel == matrix.length - 1)
                    matrix[curLevel][i] = true;

                else
                if(matrix[curLevel + 1][i * 2] && matrix[curLevel + 1][i * 2 + 1])
                    matrix[curLevel][i] = true;
            }
            curLevel--;
            left = left / 2;
            right = right / 2;
        }
    }


    public static void main(String[] args) {
        boolean[][] m = new boolean[][]{
                {false},
                {false, true},
                {false, true, true, true},
                {false, false, true, true, true, true, true, true},
        };
        setBit(m, 0, 1);
        System.out.println("");
    }
}
