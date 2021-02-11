package algorithms;

import algorithms.Algos.Algos;
import algorithms.Models.Node;

/**
 *
 * @author Joseph Ajibodu
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node e = new Node("E");
        Node f = new Node("F");
        
        a.addNeighbour(b, 4);
        a.addNeighbour(c, 6);
        
        b.addNeighbour(a, 4);
        b.addNeighbour(c, 3);
        b.addNeighbour(e, 5);
        
        c.addNeighbour(a, 6);
        c.addNeighbour(b, 3);
        c.addNeighbour(e, 2);
        c.addNeighbour(f, 1);
        
        e.addNeighbour(b, 5);
        e.addNeighbour(c, 2);
        
        f.addNeighbour(c, 1);
        
        Algos.Dijkstra dijkstra = new Algos.Dijkstra(a, f);
        dijkstra.search();
        
        dijkstra.printPath();
    }
}
