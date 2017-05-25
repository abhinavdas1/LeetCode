import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhinavdas on 1/12/17.
 */
public class Graph {
    public String constructSExpression(String s) {
    boolean[][] graph = new boolean[26][26];
    Set<Character> set = new HashSet<Character>();
    boolean E2 = false;
    int numOfEdges = 0;
                for (int i = 1; i < s.length(); i += 6) {
        int x = s.charAt(i) - 'A';
        int y = s.charAt(i + 2) - 'A';
        if (graph[x][y]) {
                E2 = true;
        }
        graph[x][y] = true;
        set.add(s.charAt(i));
        set.add(s.charAt(i + 2));
        numOfEdges++;
    }

    boolean E1 = false;
                for (int i = 0; i < 26; i++) {
        int count = 0;
        for (int j = 0; j < 26; j++) {
            if (graph[i][j]) {
                count++;
            }
        }
        if (count > 2) {
            return "E1";
        }
    }
                if (E2) return "E2";

    int numOfRoots = 0;
    char root = ' ';
                System.out.println(set);
                for (Character c : set) {
        for (int i = 0; i < 26; i++) {
            if (graph[i][c - 'A']) {
                break;
            }
            if (i == 25) {
                numOfRoots++;
                root = c;
                boolean[] visited = new boolean[26];
                if (detectCycle(c, graph, visited)) {
                    return "E3";
                }
            }
        }
    }
                if (numOfRoots == 0) return "E3";
                if (numOfRoots > 1) return "E4";

                return getSexpression(root, graph);

}
private boolean detectCycle(char c, boolean[][] graph, boolean[] visited) {
        if (visited[c - 'A']) return true;

        visited[c - 'A'] = true;
        for (int i = 0; i < 26; i++) {
        if (graph[c -'A'][i]) {
        if (detectCycle((char)('A' + i), graph, visited)) {
        return true;
        }
        }
        }
        return false;
        }

private String getSexpression(char root, boolean[][] graph) {

        String left = "";
        String right = "";
        for (int i = 0; i < 26; i++) {
        if (graph[root - 'A'][i]) {
        left = getSexpression((char)('A' + i), graph);
        for (int j = i + 1; j < 26; j++) {
        if (graph[root - 'A'][j]) {
        right = getSexpression((char)('A' + j), graph);
        break;
        }
        }
        break;
        }
        }
        return "(" + root + left + right + ")";

        }
}
