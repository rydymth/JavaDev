/*
 *
 * TODO:
 *  - Write the NODE
 *  - Implement the graph and edges
 */

class Node {
  private int data;
  private Edge edges;
  private Node next;
  
  public Node (int data)
  {
    this.data = data;
    this.edges = null;
    this.next = null;
  }

  public void addEdge (int source, int dest)
  {
    Edge edge = new Edge(source, dest);
    edge.setNext(this.edges);
    this.edges = edge;
  }

  public int getData() { return this.data; }
  
  public Node getNext() { return this.next; }

  public Edge getEdges() { return this.edges; }

  public void setNext(Node next)
  {
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

  public int getDestination () {
    return this.destination;
  }
}
