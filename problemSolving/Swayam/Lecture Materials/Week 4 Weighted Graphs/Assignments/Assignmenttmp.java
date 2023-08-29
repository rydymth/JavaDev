public class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    // Function to add a new node to the end of the linked list
    public void append(int data) {
        Node newNode = new Node(data);
        Node current = this;
        
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = newNode;
    }
}

class edges
{
  int weight;
  Node Dest;
  
  edges(Node dest, int weight)
  {
    this.Dest = dest;
    this.weight = weight;
  }

  int getDest()
  { return this.Dest.data; }

  int getWeight()
  { return this.weight; }
}

class graph
{
  edges e;

}

