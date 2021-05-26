package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

    private Set<V> vertices = new HashSet<>();
    private Map<V, Set<V>> edges = new HashMap<>();

    //adds a new vertex to the vertices set
    public void addVertex(V v) throws GraphException {

        if (vertices.contains(v)) {
            throw new GraphException("Element already in the graph");
        }
        vertices.add(v);
        edges.put(v, new HashSet<>());
    }

    //connects two vertices if a connection is possible
    public void addEdge(V v1, V v2) throws GraphException {
        //if the edge already has a connection between both elements
        if (hasEdge(v1, v2)) {
            throw new GraphException("Error! connection already established.");
        }
        if (connected(v1, v2)) {
            throw new GraphException("Error! cannot connect v1 and v2.");
        }

        edges.get(v1).add(v2);
        edges.get(v2).add(v1);
    }

    //checks whether two vertices are connected (directly or indirectly)
    public boolean hasEdge(V v1, V v2) {
        return edges.get(v1).contains(v2);
    }

    //checks whether two vertices can be directly connected
    public boolean connected(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            throw new GraphException("Error! one or both of the elements not found");
        }
        Set<V> visited = new HashSet<>();

        return DFS(v1, v2, visited);
    }

    //checks whether the destination vertex is reachable by traversing through the neighbours of the source vertex
    private boolean DFS(V source, V destination, Set<V> visited) {
        //if the current checked element is equal to the destination element, return true
        if (source.equals(destination)) {
            return true;
        }

        //prevents the algorithm from checking vertices which were previously visited
        if (visited.contains(source)) {
            return false;
        }
        //adds the current source element to the visited set
        visited.add(source);

        for (V element : edges.get(source)) {
            //if the current element's set contains the destination element, return true
            //call the recursion with one of the neighbours
            if (DFS(element, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}