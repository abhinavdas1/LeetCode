/**
 * Created by abhinavdas on 5/23/17.
 */

import java.util.*;

public class SameSnakeCC {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int cases = Integer.parseInt(sc.nextLine());

        while(cases > 0)
        {
            cases --;

            String[] points = sc.nextLine().split(" ");

            Point first = new Point(), second = new Point();
            first.x = Integer.parseInt(points[0]);
            first.y = Integer.parseInt(points[1]);
            second.x = Integer.parseInt(points[2]);
            second.y = Integer.parseInt(points[3]);

        }


    }

    static class Graph
    {
        Point[] vertices;
        Point[][] edges;


    }

    static class Point
    {
        int x, y;

        Point[] neightbours;

        Point()
        {
            x = 0;
            y = 0;

        }

    }
}
