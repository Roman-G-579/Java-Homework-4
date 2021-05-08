package graph;

import java.util.Map;
import java.util.Set;

public class Graph<V> {

    private Set<V> vertices;
    private Map<V, Set<V>> edges;

    public void addVertex(V v) throws GraphException {
        if (edges.containsKey(v)) {
            throw new GraphException("Edge already exists");
        }
        edges.put(v, vertices);
    }

    public void addEdge(V v1, V v2) throws GraphException {

    }

    public boolean hasEdge(V v1, V v2) {

    }

    public boolean connected(V v1, V v2) throws GraphException {

    }
}
