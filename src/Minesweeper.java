import java.util.Random;

/**
 * Created by abhinavdas on 5/7/17.
 */
/*
public class Minesweeper {
    public void Board(int width, int height, int numMines) {

        // Initialise instance variables.  Note the use of 'this' when parameters
        // have the same name.
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        this.numMarked = 0;
        this.numUnknown = width * height;

        // Allocate storage for game board and mines
        mines = new boolean[width][height];
        board = new int[width][height];

        // Clear the board
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                mines[i][j] = false;
                board[i][j] = UNKNOWN;
            }
        }

        // Randomly allocate mines.  The loop runs until numMines mines have been
        // placed on the board.  The the purposes of this operation we treat the
        // board as a width*height linear array of cells, and simply try again if
        // the chosen cell already contains a mine.
        int cells = width * height;
        int temp = 0;
        Random rand = new Random();

        while (temp < numMines) {
            int cell = rand.nextInt();
            cell = (cell < 0 ? -cell : cell)%cells;
            if (!mines[cell%width][cell/width]) {
                mines[cell%width][cell/width] = true;
                temp++;
            }
        }
    }
}
*/