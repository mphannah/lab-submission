import java.util.*;

public class Graph {
    private List<Node> nodes;
    private Hashtable<Node, List<Node>> neighbors;

    public Graph(List<Node> nodes, Hashtable<Node, List<Node>> neighbors){
        this.nodes = nodes;
        this.neighbors = neighbors;
    }

    public void clearVisits(){
        for(Node n: nodes){
            n.setUnvisited();
        }
    }


    // TODO
    // queue - peek, remove, size, add
    public List<Node> BFS(Node start){
        List<Node> order = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            if (!queue.peek().isVisited()) {
                order.add(queue.peek());
                queue.peek().setVisited();
                queue.addAll(neighbors.get(queue.peek()));
            }

            queue.remove();
        }

        return order;
    }


    // TODO
    // stack - pop, push, poll ?
    public List<Node> DFS(Node start){
        List<Node> order = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Node topOfStack = stack.pop();
            if (!topOfStack.isVisited()) {
                topOfStack.setVisited();
                order.add(topOfStack);
            }

            for (Node n : neighbors.get(topOfStack)) {
                stack.push(n);
            }
        }

        return order;
    }


}