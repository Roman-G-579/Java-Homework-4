package graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

    private Set<V> vertices;
    private Map<V, Set<V>> edges;

    public void addVertex(V v) throws GraphException {
        if (edges.containsKey(v)) {
            throw new GraphException("Edge already exists");
        }
        edges.put(v, new HashSet<>(Collections.singletonList(v)));
    }

    public void addEdge(V v1, V v2) throws GraphException {
        int v1Found = -1;
        int v2Found = -1;

            for (Set<V> set : edges.values()) {
                if (set.contains(v1) && set.contains(v2)) {
                    throw new GraphException("Connection already established!");
                }
                if (set.contains(v1) && !set.contains(v2)) {
                    v1Found = set;
                }
                if (!set.contains(v1) && set.contains(v2)) {
                    v2Found = i;
                }
            }
        }

    public boolean hasEdge(V v1, V v2) {

    }

    public boolean connected(V v1, V v2) throws GraphException {

    }
}
