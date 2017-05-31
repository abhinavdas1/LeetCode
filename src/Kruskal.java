/**
 * Created by abhinavdas on 5/25/17.
 */
public class Kruskal {
    class Edge implements Comparable<Edge>
    {
        int x, y;
        int weight;

        @Override
        public int compareTo(Edge e)
        {
            return this.weight - e.weight;
        }

    }

    Edge edges[];


}
