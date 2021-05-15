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

        //       if (edges.get(v1)|| edges.get(v2)) {// FIXME: 15/05/2021 check if the vertices exist
        //           throw new GraphException("Error! An edge was not found");
//        }
        if (edges.get(v1).contains(v2)) {
            throw new GraphException("Vertices already connected");
        }

        if (!edges.get(v1).contains(v2)) {
            for (V element : edges.get(v1)) {
                if (element.equals(v1)) {
                    edges.get(element).add(v2); // :)
                }
            }
        }
    }


    public boolean hasEdge(V v1, V v2) {

    }

    public boolean connected(V v1, V v2) throws GraphException {

    }
}
