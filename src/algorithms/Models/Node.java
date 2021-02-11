package algorithms.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Node {
    public final String name; 
//    Cost of reaching this node from the parent node
    public double cost;
    
//    Nodes that can be reach via this node
    public List<Edge> adjacents = new ArrayList<>();
    
//    The fastest previous Node
    public Node parent;
    
    public Node(String name) {
        this.name = name;
    }
    
    public void addNeighbour(Node neighbour, double cost) {
        Edge edge = new Edge(neighbour, cost);
        adjacents.add(edge);
    }
    
    @Override
    public String toString() {
        return name;
    }
}
