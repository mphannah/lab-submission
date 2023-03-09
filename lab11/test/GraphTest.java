import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class GraphTest {

    List<Node> nodes = Arrays.asList(new Node("A"), new Node("B"), new Node("C"),
            new Node("D"), new Node("E"), new Node("F"));
    Hashtable<Node, List<Node>> neighbors = new Hashtable<>();

    // TODO: BFS Test
    @Test
    public void BFS(){
        neighbors.put(nodes.get(0), Arrays.asList(nodes.get(1), nodes.get(2)));
        neighbors.put(nodes.get(1), Arrays.asList(nodes.get(3), nodes.get(4)));
        neighbors.put(nodes.get(2), Arrays.asList(nodes.get(5)));
        neighbors.put(nodes.get(3), new ArrayList<>());
        neighbors.put(nodes.get(4), new ArrayList<>());
        neighbors.put(nodes.get(5), new ArrayList<>());
        Graph graph = new Graph(nodes, neighbors);

        System.out.println("BFS");
        List<Node> order = graph.BFS(nodes.get(0));
        for (Node n : order) {
            System.out.println(n.getName());
        }

        System.out.println("\n");
    }

    // TODO: DFS Test
    @Test
    public void DFS(){
        neighbors.put(nodes.get(0), Arrays.asList(nodes.get(1), nodes.get(2)));
        neighbors.put(nodes.get(1), Arrays.asList(nodes.get(3), nodes.get(4)));
        neighbors.put(nodes.get(2), Arrays.asList(nodes.get(5)));
        neighbors.put(nodes.get(3), new ArrayList<>());
        neighbors.put(nodes.get(4), new ArrayList<>());
        neighbors.put(nodes.get(5), new ArrayList<>());
        Graph graph = new Graph(nodes, neighbors);

        System.out.println("DFS");
        List<Node> order = graph.DFS(nodes.get(0));
        for (Node n : order) {
            System.out.println(n.getName());
        }

        System.out.println("\n");
    }

}