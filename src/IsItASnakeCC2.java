/**
 * Created by abhinavdas on 5/28/17.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsItASnakeCC2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(br.readLine());

        char[][] grid = null;
        String l1 = null, l2 = null;
        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(br.readLine());
            grid = new char[2][n];
            l1 = br.readLine();
            l2 = br.readLine();
            int length = 0;
            grid[0] = l1.toCharArray();
            for (char ch : grid[0]) {
                if (ch == '#')
                    length++;
            }
            grid[1] = l2.toCharArray();
            for (char ch : grid[1]) {
                if (ch == '#')
                    length++;
            }
            if (length == 0) {
                System.out.println("no");
                continue;
            }
            if (isASnake(grid, length))
                System.out.println("yes");
            else
                System.out.println("no");
        }
        br.close();
    }

    private static boolean isASnake(char[][] grid, int target) {
        boolean[][] visited = new boolean[2][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '#') {
                    boolean res = dfs(i, j, grid, visited, 0, target);
                    if (res)
                        return true;
                }

            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, char[][] grid, boolean[][] visited, int sum, int target) {
        if (sum == target)
            return true;
        if (i < 0 || i >= 2 || j < 0 || j >= grid[0].length)
            return false;
        if (visited[i][j] || grid[i][j] == '.')
            return false;
        visited[i][j] = true;
        boolean result = dfs(i + 1, j, grid, visited, sum + 1, target) || dfs(i - 1, j, grid, visited, sum + 1, target)
                || dfs(i, j - 1, grid, visited, sum + 1, target) || dfs(i, j + 1, grid, visited, sum + 1, target);
        visited[i][j] = false;
        return result;
    }

}