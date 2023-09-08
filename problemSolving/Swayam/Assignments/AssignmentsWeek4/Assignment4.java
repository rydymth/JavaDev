import java.util.Scanner;
class Node {
    private int value;
    private Edge edges;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.edges = null;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Edge getEdges() {
        return edges;
    }

    public void addEdge(int destination, int weight) {
        Edge newEdge = new Edge(destination, weight);
        newEdge.setNext(edges);
        edges = newEdge;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class Edge {
    private int destination;
    private int weight;
    private Edge next;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.next = null;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }
}

class Graph {
  private Node nodes;

  public void addEdge(int source, int weight, int destination) {
      Node sourceNode = getNodeOrCreate(source);
      sourceNode.addEdge(destination, weight);

      Node destNode = getNodeOrCreate(destination);
      destNode.addEdge(source, weight);  // If it's an undirected graph
  }

  private Node getNodeOrCreate(int value) {
      Node current = nodes;
      while (current != null) {
          if (current.getValue() == value) {
              return current;
          }
          current = current.getNext();
      }

      Node newNode = new Node(value);
      newNode.setNext(nodes);
      nodes = newNode;
      return newNode;
  }

  public void display() {
      Node current = nodes;
      while (current != null) {
          System.out.print("Node " + current.getValue() + " is connected to: ");
          Edge currentEdge = current.getEdges();
          while (currentEdge != null) {
              System.out.print("(" + currentEdge.getDestination() + ", " + currentEdge.getWeight() + ") ");
              currentEdge = currentEdge.getNext();
          }
          System.out.println();
          current = current.getNext();
      }
  }

  public int shortestPath(int source, int destination) {
    // Create arrays for distances and visited nodes
    int[] distance = new int[2000]; // Assuming a maximum of 100 nodes
    boolean[] visited = new boolean[2000];
    for (int i = 0; i < 2000; i++) {
        distance[i] = Integer.MAX_VALUE;
        visited[i] = false;
    }

    distance[source] = 0; // Distance from source to itself is 0

    for (int i = 0; i < 2000; i++) {
        // Find the node with the minimum distance
        int minDistance = Integer.MAX_VALUE;
        int minNode = -1;
        for (int j = 0; j < 2000; j++) {
            if (!visited[j] && distance[j] < minDistance) {
                minDistance = distance[j];
                minNode = j;
            }
        }

        if (minNode == -1) {
            break; // No more reachable nodes
        }

        visited[minNode] = true;

        // Update distances for neighboring nodes
        Node currentNode = nodes;
        while (currentNode != null) {
            if (currentNode.getValue() == minNode) {
                Edge currentEdge = currentNode.getEdges();
                while (currentEdge != null) {
                    int neighbor = currentEdge.getDestination();
                    int weight = currentEdge.getWeight();
                    if (distance[minNode] + weight < distance[neighbor]) {
                        distance[neighbor] = distance[minNode] + weight;
                    }
                    currentEdge = currentEdge.getNext();
                }
                break;
            }
            currentNode = currentNode.getNext();
        }
    }
    if (distance[destination] == Integer.MAX_VALUE)
      return -1;

    return distance[destination];
  }
}

public class Assignment4
{
  public static void main(String[] args) {
    Graph graph = new Graph();
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    for (int i = 0; i < M; i++)
    {
      graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }
    int res = graph.shortestPath(A, B);
    if (res == -1)
      System.out.println("NO");
    else
      System.out.println("YES\n" + res);
  }
}
