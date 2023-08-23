/*
 * TODO
 *  Implement node
 *  Linked list and graph for the vertices
 *  arrays for weighted edges (think of something)
 * */

import sun.font.TrueTypeGlyphMapper;

class Edges {
  int source;
  int dest;
  int weight;
  Edges (int source, int dest, int weight)
  {
    this.source = source;
    this.dest = dest;
    this.weight = weight;
  }
}

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
 *  Number of connected components
 * */
class graph {
  private int v;
  int [] color;
  int distance [];
  boolean visited [];
  private Node [] list;
  graph (int v)
  {
    distance = new int[n];
    visited = new boolean[n];
    for (int i = 0; i < n; i++)
    {
      distance[i] = -1;
      visited[i] = false;
    }
    this.v = v;
    list = new Node[this.v];
    color = new int[this.v];
    for (int i = 0; i < v; i++)
    {
      list[i] = new Node();
    }
    color = new int[this.v];
  }

  //Since it a undirected graph,
  //Everytime we add u,v we must also add v,u
  void addEdges(int u, int v, int weights) {
    Edges e = new Edges(u, v, weights);
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
   * - Keep track of the color array for differentiating how many distinct components are present.
   *    - Implemented this in a different function
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
        if (color[e] == -1)
        { color[e] = 0;
        }
        tmp = tmp.next;
      }
      layerCtr++;
    }
    return bfs;
  }

  /* Find a way to calculate number of connected components in a connected components
   * we use the color array. In a loop call the bfs for 0 and append the color array as and when 
   * the connected components of that particular node are discovered. If already discovered, increment
   * the counter, else run bfs on that node.
   * */
  int connectedNum () {
    for (int i = 0; i < color.length ; i++)
    {
      color[i] = -1;
    }
    int i = 0;
    int sum = 0;
    while (i < this.v)
    {
      if (color[i] == -1)
      {
        this.BFS(i);
        sum++;
        i++;
      }
      else i++;
    }
    return sum;
  }
  int shortestPath(int s)
  {
    visited[s -1] = true;

  }
}
