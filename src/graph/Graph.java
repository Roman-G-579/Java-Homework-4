package graph;

import java.util.*;

public class Graph<V> {

    private Set<V> vertices = new HashSet<>();
    private Map<V, Set<V>> edges = new HashMap<>();

    public void addVertex(V v) throws GraphException {

        if (vertices.contains(v)) {
            throw new GraphException("Element already in the graph");
        }
        vertices.add(v);
        edges.put(v, new HashSet<>(Collections.singletonList(v)));
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
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            throw new GraphException("Error! one or both of the elements not found");
        }

        Set<V> visited = new HashSet<>();

        return DFS(v1, v2, visited);
    }

    private boolean DFS(V source, V destination, Set<V> visited) {
        if (visited.contains(source)) {
            return false;
        }
        //adds the current source element to the visited set
        visited.add(source);

        //if the current checked element equals to the destination element, return true
        if (source.equals(destination)) {
            return true;
        }

        for (V element : edges.get(source)) {
            //if the current element's set contains the destination element, return true
            if (!edges.get(element).contains(destination)) {
                //call the recursion with one of the neighbours
                DFS(element, destination, visited);
            } else {
                return true;
            }
        }
        return false;
    }
}