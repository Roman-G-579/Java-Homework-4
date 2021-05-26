package graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {

    private GraphInterface<V> mazeGraph;

    public ConnectionChecker(GraphInterface<V> g) {
        this.mazeGraph = g;
    }

    //checks whether two vertices can be directly connected
    public boolean check(V v1, V v2) {

        Set<V> visited = new HashSet<>();

        return DFS(v1, v2, visited);
    }

    //checks whether the destination vertex is reachable by traversing through the neighbours of the source vertex
    private boolean DFS(V source, V destination, Set<V> visited) {
        //if the current checked element equals to the destination element, return true
        if (source.equals(destination)) {
            return true;
        }

        //prevents the algorithm from checking vertices which were previously visited
        if (visited.contains(source)) {
            return false;
        }
        //adds the current source element to the visited set
        visited.add(source);

        for (V element : mazeGraph.neighbours(source)) {
            //if the current element's set contains the destination element, return true
            //call the recursion with one of the neighbours
            if (DFS(element, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}