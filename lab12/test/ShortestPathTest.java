import java.sql.Array;
import java.util.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class ShortestPathTest {
     @Test
     public void sampleGraph(){
         // nodes
         Node a = new Node("a");
         Node b = new Node("b");
         Node c = new Node("c");
         List<Node> nodes = List.of(a,b,c);

         // edges
         Edge ab = new Edge(a, b);
         Edge bc = new Edge(b, c);
         Hashtable<Node, List<Edge>> neighbors = new Hashtable<>();
         neighbors.put(a, new ArrayList<>(Arrays.asList(ab)));
         neighbors.put(b, new ArrayList<>(Arrays.asList(bc)));

         // put together for a graph voila
         Graph g = new Graph(nodes, neighbors);
         // a -> b -> c : u will need to set weights yada yada
     }

     @Test
     public void shortestPath(){
         Node a = new Node("a");
         Node b = new Node("b");
         Node c = new Node("c");
         Node d = new Node("d");
         List<Node> nodes = List.of(a, b, c, d);

         Edge ab = new Edge(a, b, 5);
         Edge ac = new Edge(a, c, 8);
         Edge bc = new Edge(b, c, 2);
         Edge bd = new Edge(b, d, 3);
         Edge cd = new Edge(c, d, 1);
         Hashtable<Node, List<Edge>> neighbors = new Hashtable<>();
         neighbors.put(a, new ArrayList<>(Arrays.asList(ab, ac)));
         neighbors.put(b, new ArrayList<>(Arrays.asList(bc, bd)));
         neighbors.put(c, new ArrayList<>(Arrays.asList(cd)));
         neighbors.put(d, new ArrayList<>());

         Graph g = new Graph(nodes, neighbors);
         g.shortestPath(a);
         System.out.println(nodes);
         for (Node n : nodes) {
             System.out.println(n.getValue());
         }
         System.out.println();
     }

     @Test
     public void primsMST(){
         Node a = new Node("a");
         Node b = new Node("b");
         Node c = new Node("c");
         Node d = new Node("d");
         List<Node> nodes = List.of(a, b, c, d);

         Edge ab = new Edge(a, b, 5);
         Edge ac = new Edge(a, c, 8);
         Edge bc = new Edge(b, c, 2);
         Edge bd = new Edge(b, d, 3);
         Edge cd = new Edge(c, d, 1);
         Hashtable<Node, List<Edge>> neighbors = new Hashtable<>();
         neighbors.put(a, new ArrayList<>(Arrays.asList(ab, ac)));
         neighbors.put(b, new ArrayList<>(Arrays.asList(bc, bd)));
         neighbors.put(c, new ArrayList<>(Arrays.asList(cd)));
         neighbors.put(d, new ArrayList<>());

         Graph g = new Graph(nodes, neighbors);
         System.out.println(nodes);
         System.out.println(g.primsMST(a));
     }

}
