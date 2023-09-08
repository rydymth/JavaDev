class queue
{
  int [] queue;
  int front, rear, capacity, size;
  queue(int n)
  {
    front = 0;
    rear = 0;
    capacity = n;
    queue = new int[n];
  }

  void enqueue(int ins)
  {
    if (rear == capacity)
      System.out.println("Queue is full/Overflow");
    else
    {
      queue[rear] = ins;
      rear++;
      size++;
    }
  }

  Integer dequeue()
  {
    if (front == rear)
      return null;
    else
    {
      int a = queue[front];
      front++;
      size--;
      return a;
    }
  }

  Integer size()
  {
    return size;
  }
}

class Node {
  Node Child;
  Integer Data;
  Node ()
  {
    Child = null;
    Data = null;
  }

  // Another constructor for inserting nodes
  Node (Integer Data)
  {
    this.Data = Data;
    this.Child = null;
  }
}


class linklists {
  // Now the Linked List Implementation 
  Node head;
  linklists () { head = null; }

  void addNodetop (Integer data)
  {
    Node newNode = new Node(data);
    if (head == null)
    {
      head = newNode;
      return;
    }
    newNode.Child = head;
    head = newNode;
  }

  void addNode (Integer data)
  {
    Node newNode = new Node(data);
    if (head == null)
    {
      head = newNode;
      return;
    }

    Node temp = head;
    while (temp.Child != null)
    {
      temp = temp.Child;
    }
    temp.Child = newNode;
  }

  int getSize()
  {
    Node temp = head;
    int count = 0;
    while (temp != null)
    { count++; temp = temp.Child; }
    return count;
  }

  void disp()
  {
    Node temp = head;
    while (temp != null)
    {
      System.out.print((temp.Data + 1) + " -> ");
      temp = temp.Child;
    }
  }
}

class graph {
  linklists [] l;
  int [] path;
  int nV;
  int nE;
  int levels;
  linklists nodes;
  graph(int nV, int nE)
  {
    this.nV = nV;
    this.nE = nE;
    l = new linklists[nV];
    path = new int[nV];
    for (int i = 0; i < nV; i++)
    {
      l[i] = new linklists();
    }
  }

  void addEdge (int source, int dest)
  {
    l[source - 1].addNode(dest - 1);
    l[dest - 1].addNode(source - 1);
  }

  void dispConnectedVertices (int v)
  {
    System.out.println("Node " + (v) + " is connected to :");
    l[v - 1].disp();
  }

  int [] adjList (int v)
  {
    int ret [] = new int [l[v].getSize()];
    int i = 0;
    Node tmp = l[v].head;
    while (tmp != null)
    {
      ret[i] = tmp.Data;
      i++;
      tmp = tmp.Child;
    }
    return ret;
  }

  void BFS(int start)
  {
    levels = 0;
    nodes = new linklists();
    boolean visited [] = new boolean[nV];
    queue q = new queue(nV);
    for (int i = 0; i < nV; i++) {
      visited[i] = false;
    }
    visited[start] = true;
    q.enqueue(start);
    nodes.addNode(start);
    while (q.size() != 0)
    {
      int t = q.dequeue();
      int [] tmp = this.adjList(t);
      for (int i = 0; i < tmp.length; i++) {
        if (visited[tmp[i]] == false)
        {
          levels++;
          path[tmp[i]] = t;
          nodes.addNode(tmp[i]);
          visited[tmp[i]] = true;
          q.enqueue(tmp[i]);
        }
      }
    }
  }

  linklists BfsTree (int s) {
    this.BFS(s);
    return nodes;
  }

  int layers (int s) {
    this.BFS(s);
    return levels;
  }

  int [] path (int s)
  {
    this.BFS(s);
    return path;
  }

}

class bfs
{
  public static void main(String [] args)
  {
    graph g = new graph(5, 5);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    g.addEdge(4, 5);
    int [] paths = g.path(0);
    for (int i = 0; i < paths.length; i++)
    {
      System.out.println("Child: " + (i + 1) + " has parent: " + (paths[i] + 1));
    }
    linklists nodes = g.BfsTree(0);
    nodes.disp();
    System.out.println("This has " + g.layers(0) + " layers");
  }
}
