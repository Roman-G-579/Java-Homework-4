package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

    private Set<V> vertices = new HashSet<>();
    private Map<V, Set<V>> edges = new HashMap<>();

    public void addVertex(V v) throws GraphException {

        if (vertices.contains(v)) {
            throw new GraphException("Element already in set");
        }
        vertices.add(v);

//        if (edges.containsKey(v)) {
//            throw new GraphException("Edge already exists");
//        }
//        edges.put(v, new HashSet<>(Collections.singletonList(v)));
    }

    //
    public void addEdge(V v1, V v2) throws GraphException {
        //if the edge already has a connection between both elements
        if (hasEdge(v1, v2)) {
            throw new GraphException("Error! connection already established.");
        }
        if (connected(v1,v2)) {
            throw new GraphException("Error! cannot connect v1 and v2.");
        }

        edges.put(v1, vertices);
    }

    //checks whether two vertices are connected (directly or indirectly)
    public boolean hasEdge(V v1, V v2) {
        for (Set<V> set : edges.values()) {
            if (set.contains(v1) && set.contains(v2)) {
                return true;
            }
        }
        return false;
    }

    //checks whether two vertices can be directly connected
    public boolean connected(V v1, V v2) throws GraphException {
        boolean[] visited = new boolean[];

        if (v1.equals(v2)) {
            return true;
        }
        return DFS(v1, visited);

    }

    private boolean DFS(V element, boolean[] visited) {
        return true;
    }
}
