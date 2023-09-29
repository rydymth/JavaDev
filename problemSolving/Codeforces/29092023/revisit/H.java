// Stack implementation
class stack {
  int [] arr;
  int ctr = 0;
  
  stack (int n)
  {
    arr = new int[n];
  }

  void push(int v)
  {
    arr[ctr] = v;
    ctr++;
  }

  int pop() {
    int ret = arr[ctr - 1];
    ctr--;
    return ret;
  }
}

class node {
  Integer data;
  node next;
  node () {
    this.next = null;
    this.data = null;
  }

  node (int c)
  {
    this.data = c;
  }
}

class linkedList {
  node head;
  int size;
  void addNode (Integer data)
  {
    size++;
    node newNode = new node(data);
    if (head == null)
      head = newNode;
    else
    {
      node tmp = head;
      while(tmp.next != null)
        tmp = tmp.next;
      tmp.next = newNode;
    }
  }

  void dispNode() {
    node tmp = this.head;
    while (tmp != null)
    {
      if (tmp.next != null)
        System.out.println(tmp.data + " -> ");
      else 
        System.out.println(tmp.data);
    }
  }

  int getSize() {
    return size;
  }
}

class graph {
  linkedList [] Nodes;
  int nV;
  stack s;
  boolean [] visited;

  // Constructor
  graph (int nV) {
    this.nV = nV;
    Nodes = new linkedList[nV];
    visited = new boolean[nV];
    s = new stack(nV);
    for (int i = 0; i < nV; i++)
    {
      Nodes[i] = new linkedList();
      visited[i] = false;
    }
  }

  // Adding Nodes
  void addEdge(int u, int v)
  {
    this.Nodes[u - 1].addNode(v - 1);
    this.Nodes[v - 1].addNode(u - 1);
  }

  int [] adjList (int s)
  {
    node n = Nodes[s].head;
    int [] adj = new int[Nodes[s].size];
    for (int i = 0; n != null; i++, n = n.next)
    {
      adj[i] = n.data;
    }
    return adj;
  }

  // dfs
  void dfs(int s)
  {
    this.s.push(s);

  }
}

public class H {

}
