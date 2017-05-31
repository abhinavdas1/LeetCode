/**
 * Created by abhinavdas on 5/27/17.
 */
import java.util.*;
public class IsItASnakeCC {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int cases = Integer.parseInt(sc.nextLine());

        while(cases > 0)
        {
            int cols = Integer.parseInt(sc.nextLine());

            int[][] maze = new int[2][cols];

            char[] row = sc.nextLine().toCharArray();

            int count = 0, startx = 600, starty = 600;

            for(int i = 0; i < cols; i++ )
            {
                if(row[i] == '#')
                {
                    if(i < starty) {
                        starty = i;
                        startx = 0;
                    }
                    maze[0][i] = 1;
                    count++;
                }
            }

            row = sc.nextLine().toCharArray();

            for(int i = 0; i < cols; i++ )
            {
                if(row[i] == '#')
                {
                    if(i < starty) {
                        starty = i;
                        startx = 1;
                    }
                    maze[1][i] = 1;
                    count++;
                }
            }

            int found = goRight(maze, startx, starty);

            if(maze[(startx + 1)%2][starty] == 1)
            {
                found = found + goRight(maze,(startx + 1)%2, starty);
            }

            if(found == count)
                System.out.println("yes");
            else
                System.out.println("no");

            cases --;

        }

    }



    public static int goRight(int[][] maze, int x, int y)
    {
        int count = 1;
        maze[x][y] = 0;
        int flag = 1;
        while(y < maze[0].length - 1 )
        {
            if(flag == 1) {
                if (maze[x][y + 1] == 1) {
                    count++;
                    y++;
                    maze[x][y] = 0;
                } else if (maze[(x + 1) % 2][y] == 1) {
                    x = (x + 1) % 2;
                    count++;
                    maze[x][y] = 0;
                }
                else
                    break;
            }
            else
            {
                if (maze[(x + 1) % 2][y] == 1) {
                    x = (x + 1) % 2;
                    count++;
                    maze[x][y] = 0;
                }
                else if (maze[x][y + 1] == 1) {
                    count++;
                    y++;
                    maze[x][y] = 0;
                }
                else
                    break;
            }
            flag = (flag + 1) % 2;

        }
        count = count + goLeft(maze, x, y);

        return count;
    }

    public static int goLeft(int[][] maze, int x, int y)
    {
        int count = 0;
        while(y >= 1 )
        {
            if(maze[x][y-1] == 1)
            {
                count++;
                y--;
                maze[x][y] = 0;
            }
            else if(maze[(x+1)%2][y] == 1)
            {
                x = (x + 1) % 2;
                count++;
                maze[x][y] = 0;
            }
            else
                break;
        }
        return count;
    }
}
