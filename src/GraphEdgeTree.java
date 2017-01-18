import java.util.*;

/**
 * Created by abhinavdas on 1/12/17.
 */
public class GraphEdgeTree {

    public static class Link {
        char start, end;
        public Link(String s) {
            String[] nodes = s.replaceAll("[\\(\\)\\s]", "").split(",");
            start = nodes[0].charAt(0);
            end = nodes[1].charAt(0);
        }
    }

    private Map<Character, Character> map = new HashMap<>();
    private Map<Character, Set<Character>> child = new HashMap<>();
    private List<Link> edgeList = new ArrayList<>();

    public GraphEdgeTree(String s) {
        String[] arr = s.split("\\s");
        for(String str:arr) {
            Link edge = new Link(str);
            edgeList.add(edge);
            map.put(edge.start, edge.start);
            map.put(edge.end, edge.end);

            Set<Character> children = child.get(edge.start);
            if(children == null) {
                children = new HashSet<Character>();
            }
            children.add(edge.end);
            child.put(edge.start, children);
        }
    }

    public Character find(char x) {
        Character parent = map.get(x);
        if(parent == null || parent == x) {
            return parent;
        }
        return find(parent);
    }

    public void union(char x, char y) {
        Character xp = find(x);
        Character yp = find(y);
        map.put(xp, yp);
    }

    public boolean exists(Link edge) {
        Character p = map.get(edge.end);
        return p != null && p == edge.start;
    }

    public String build() {
        for(Character key:child.keySet()) {
            Set<Character> set = child.get(key);
            if(set != null && set.size()>2) {
                return "E1";
            }
        }
        for(Link edge:edgeList) {
            if(exists(edge)) {
                return "E2";
            }
            char x = find(edge.start);
            char y = find(edge.end);
            if(x == y) {
                return "E3";
            }
            union(edge.end, edge.start);
        }
        if(rootNum() > 1) {
            return "E4";
        }
        return null;
    }

    private int rootNum() {
        int cnt = 0;
        for(char key:map.keySet()) {
            if(find(key) == key) {
                cnt++;
            }
        }
        return cnt;
    }

    public String treeString(char root) {
        Set<Character> children = child.get(root);
        if(children == null || children.size() == 0) {
            return "("+root+")";
        }
        StringBuilder result = new StringBuilder("("+root);
        for(char child:children) {
            result.append(",").append(treeString(child));
        }
        result.append(")");
        return result.toString();
    }

    public char getRoot() {
        return find(edgeList.get(0).start);
    }


}
