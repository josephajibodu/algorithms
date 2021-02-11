package algorithms.Models;

/**
 *
 * @author Joseph Ajibodu
 */
public class Edge {
//    The cost of reaching the target Node
    public double cost;
//    The Node that can be reached via this route
    public Node target;
    
    public Edge(Node target, double cost) {
        this.target = target;
        this.cost = cost;
    }
}
