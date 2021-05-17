package graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

    private Set<V> vertices;
    private Map<V, Set<V>> edges;

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

    public void addEdge(V v1, V v2) throws GraphException {
        //if the edge already has a connection between both of the elements
        if (hasEdge(v1, v2)) {
            throw new GraphException("Error! connection already established.");
        }
    }


    public boolean hasEdge(V v1, V v2) {

    }

    public boolean connected(V v1, V v2) throws GraphException {

    }
}
