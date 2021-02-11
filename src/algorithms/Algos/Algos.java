package algorithms.Algos;

import algorithms.Models.Edge;
import algorithms.Models.Node;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Joseph Ajibodu
 */
public class Algos {

    public static class Dijkstra {
        private final Node start;
        private final Node destination;

        public Dijkstra(Node start, Node destination) {
            this.start = start;
            this.destination = destination;
        }

        public void search() {
//            Initialize the cost/distance of all nodes to INFINITY
//            Initialize the start Node to ZERO
            this.start.cost = 0;

//            Create a data structure for priortizing Nodes to be visited - Priority Queue
            PriorityQueue<Node> toVisit = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Double.compare(o1.cost, o2.cost);
                }
            });

//            Add the source to the toVisit queue
            toVisit.add(this.start);

//            Loop through the Nodes in toVisit till its empty or the destination is VISITED
            while (!toVisit.isEmpty()) {
//                Get the highest priority Node (It will be the start Node(since it has a cost of 0) for the first step)
                Node current = toVisit.poll();
//                Mark this Node as visited
                current.visited = true;
                System.out.println("Current node: " + current.name);

//                If the current node is the destination. Stop all operation here
                if (current.name.equals(this.destination.name)) {
                    break;
                }

//                Loop through the (unvisited) neighbours, perform RELAXATION -> then add to the queue
                for (Edge edge: current.adjacents) {
                    Node neighbour = edge.target;
                    double edgeCost = edge.cost;
                    
                    System.out.println("Current Edge: " + neighbour.toString());
//                    Skip the neighbouring Node if it has been visited already
                    if (neighbour.visited) continue;
                        
                    double newCost = current.cost + edgeCost;
//                 RELAXATION: 
//                  if current_cost + the edge cost < cost of curent Neighbour : Update the cost
                    if (newCost < neighbour.cost) {
//                        Update the cost
                        neighbour.cost = newCost;
//                        Set the parent Node(i.e the previous Node that leads to this Node)
                        neighbour.parent = current;

//                        This is done to reset the priority queue if necessary
                        if (toVisit.contains(neighbour)) {
                            toVisit.remove(neighbour);
                        }

//                        Add neighbour to the priority queue since it's cost has been updated
                        toVisit.add(neighbour);
                    }
                }
            }
        }
        
        public void printPath() {
            Node p = this.destination;
            System.out.print(p.toString() + " -> ");
            while (p.parent != null) {
                p = p.parent;
                System.out.print(p.toString() + " -> ");
            }
        }
    }
}
