import java.util.*;

/*
Big fat note --- Java built-iin PriorityQueue does not update values.
 */

public class Graph {
    private List<Node> nodes;
    private Hashtable<Node, List<Edge>> neighbors;


    public Graph(List<Node> nodes, Hashtable<Node, List<Edge>> neighbors) {
        this.nodes = nodes;
        this.neighbors = neighbors;
    }

    public List<Edge> getNeighborsOf(Node n) {
        return this.neighbors.get(n);
    }

    public void clearVisits() {
        for (Node n : nodes) {
            n.setUnvisited();
        }
    }

    /*
    // TODO: Shortest Paths w/ Priority Queue :D
    We set the values of the Nodes to be the cost of the shortest path ^_^
     */
    public void shortestPath(Node s){
        s.setValue(0);

        for (Node n : nodes) {
            for (Edge e : neighbors.get(n)) {
                if (e.getWeight() > e.getDestination().getValue()) {
                    e.getDestination().setValue(e.getWeight());
                }
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(nodes);

        while (!priorityQueue.isEmpty()) {
            List<Edge> edges = neighbors.get(priorityQueue.poll());

            for (Edge e : edges) {
                if (e.getWeight() < (e.getSource().getValue() + e.getDestination().getValue())) {
                    priorityQueue.remove(e.getDestination());
                    e.getDestination().setValue(e.getWeight()+e.getSource().getValue());
                    priorityQueue.add(e.getDestination());
                }
            }
        }
    }

    /*
    // TODO: Prims Algorithm MST w/ Priority Queue :D
    The "tree" contains the edges we included :) ^_^
     */
    public Set<Edge> primsMST(Node s){
        Set<Edge> mst = new HashSet<>();

        s.setValue(0);

        for (Node n : nodes) {
            for (Edge e : neighbors.get(n)) {
                if (e.getWeight() > e.getDestination().getValue()) {
                    e.getDestination().setValue(e.getWeight());
                    e.getDestination().setAssocEdge(e);
                }
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(nodes);

        while (!priorityQueue.isEmpty()) {
            List<Edge> edges = neighbors.get(priorityQueue.poll());

            for (Edge e : edges) {
                if (e.getWeight() < e.getDestination().getValue()) {
                    priorityQueue.remove(e.getDestination());
                    e.getDestination().setValue(e.getWeight());
                    e.getDestination().setAssocEdge(e);
                    priorityQueue.add(e.getDestination());
                }
            }
        }

        for (Node n : nodes) {
            if (n.getAssocEdge() != null) {
                mst.add(n.getAssocEdge());
            }
        }
        return mst;
    }
}