import java.util.Scanner;

// Implementing queue for BFS
class queue {
  int arr [];
  int front;
  int rear;
  int maxSize;
  int count;

  queue(int size)
  {
    this.maxSize = size;
    this.arr = new int[size];
    this.front = 0;
    this.rear = -1;
    this.count = 0;
  }

  int size()
    { return count; }

  boolean isFull()
    { return size() == maxSize; }

  boolean isEmpty()
    { return size() == 0; }

  void enqueue (int x)
  {
    if (isFull())
    {
      System.out.print("Overflow\n");
    }
    rear = (rear + 1) % maxSize;
    arr[rear] = x;
    count++;
  }

  int dequeue ()
  {
    if (isEmpty()) { System.out.print("Queue is empty"); return -999; }
    int x = arr[front];
    front = (front + 1) % maxSize;
    count--;
    return x;
  }

  int peek(){
    if (!isEmpty())
    {
      return arr[front];
    }
    else
      return -999;
  }
}

// Implementing the linked list with head next and data
class Node {
	Node head;
	int data;
	Node next;	

	Node ()
	{
		this.head = null;
		this.data = -1;
		this.next = null;
	}	
  

	Node (int data)
	{
		this.head = null;
		this.data = data;
		this.next = null;
	}

	Node add (int add)
	{
		Node newNode = new Node(add);
		if (head == null)
		{
			this.head = newNode;
			this.data = add;
			this.next = newNode;
		}	
		else{
			this.next.next = newNode;
			next = newNode;
		}
		return this;
	}

  // This function will be the normal linked list traversal
	void display()
	{
		Node current = this.head;
		if (current == null)
		{
			System.out.print("EMPTY");
		}
		while(current != null)
		{
			System.out.print((current.data + 1) + "->");
			current = current.next;
		}
	}
}

/*
    // We are better off without the Node class as parent. Serving no functionality
 *  Implementing the graph with functions to do the following:
 *  BFS returning a tree,
 *  Displaying the adjacency list
 *  adding the edge
 * */
class graph {
  private int v;
  private Node [] list;
  graph (int v)
  {
    this.v = v;
    list = new Node[this.v];
    for (int i = 0; i < v; i++)
    {
      list[i] = new Node();
    }
  }

  //Since it a undirected graph,
  //Everytime we add u,v we must alsoo add v,u
  void addEdges(int u, int v) {
    list[u - 1].add(v - 1);
    list[v - 1].add(u - 1);
  }

  // To return the size of the connected graph
  // that is the number of nodes connected to a particular node
  int sizeConnectedGraph(int v) {
    int count = 0;
    Node n = list[v].head;
		if (n == null)
		{
      return -1;
		}
		while(n != null)
		{
      count++;
			n = n.next;
		}
    return count;
  }

  /* This will show only the adjacency list of the graph w.r.t. the inputs.
   * This wll NOT show the bidirectional connection or additional connections.
   * I.E. if 1 -> 3 and 3 -> 5 it wont show 1 -> 3 5. */
  void dispAdjList() {
    for (int i = 0; i < this.v; i++) {
      System.out.print("\n" + (i + 1) + ": ");
      list[i].display();
      System.out.println();
    }
  }

  /* For bfs we need the following:
   * - Discovered array of the size of number of vertices
   * - Queue of the same size as above
   * - Layer counter to keep the track of the layers in the graph
   * - Node to retuurn the tree*/
  Node BFS(int s) {  
    // initializing all the local vars till first loop
    boolean [] discovered = new boolean[this.v];
    discovered[s] = true;
    for (int i = 0; i < this.v; i++)
    {
      if (i == (s)) continue;
      else discovered[i] = false;
    }
    int layerCtr = 0;
    Node bfs = new Node();
    queue L = new queue(this.v);
    L.enqueue(s);
    while (L.size() != 0)
    {
      s = L.dequeue();
      Node tmp = list[s].head;
      while (tmp != null) {
        int e = tmp.data;
        if (discovered[e] == false)
        {
          discovered[e] = true;
          bfs.add(e);
          L.enqueue(e);
        }
        tmp = tmp.next;
      }
      layerCtr++;
    }
    return bfs;
  }
}

public class Assignment2
{
	public static void main (String [] args)
	{
    graph g = new graph(10);
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 10; i++)
    {
      g.addEdges(sc.nextInt(), sc.nextInt());
    }
    g.dispAdjList();
    for (int i = 0; i < 10; i++)
    {
      System.out.println((i + 1) + ": ");
      g.BFS(i).display();
      System.out.println();
    }
    sc.close();
  }
}
