import java.util.Scanner;

// Stack implementation
class stack {
  int size;
  int [] arr;
  int ctr = 0;
  
  stack (int n)
  {
    size = 0;
    arr = new int[n];
  }

  void push(int v)
  {
    arr[ctr] = v;
    ctr++;
    size++;
  }

  int pop() {
    int ret = arr[ctr - 1];
    ctr--;
    size--;
    return ret;
  }
  
  void printStack () {
    for (int i = 0; i < this.size; i++)
    {
      System.out.println(arr[i]);
    }
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
  int parents[];
  int nV;
  boolean [] visited;
  int numCycles = 0;

  // Constructor
  graph (int nV) {
    this.nV = nV;
    Nodes = new linkedList[nV];
    visited = new boolean[nV];
    parents = new int[nV];
    for (int i = 0; i < nV; i++)
    {
      Nodes[i] = new linkedList();
      visited[i] = false;
      parents[i] = -1;
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

  // dfs with cycle implementation
  void dfs(int s)
  {
    visited[s] = true;
    int [] adjlist = adjList(s);
    for (int i : adjlist)
    {
      System.out.println("Looking at: " + (i+1) + " node before: " + (s+1));
      if (!visited[i])
        {
          parents[i] = s;
          dfs(i);
        }
      else if(visited[i] && (parents[i] != s))
      {
        numCycles++;
        System.out.println("Looking at " + (i+1) + "where parents are: " + (s + 1));
      }
    }
  }
  
  boolean isParent(int c, int p)
  {
    // System.out.println("Checking if parent of " + c + " is " + p + " which is " + (dispParent(c)==p));
    return dispParent(c) == p;
  }

  int dispParent(int s) {
    return parents[s];
  }
}

public class H {
  public static void main (String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++)
    {
      System.out.println("Test Case: " + (i + 1));
      int n = sc.nextInt();
      int m = sc.nextInt();
      int v = sc.nextInt();
      graph g = new graph(n);
      for (int k = 0; k < n; k++)
      {
        g.addEdge(sc.nextInt(), sc.nextInt());
      }
      g.dfs(0);
      System.out.println();
      for (int u = 0; u < n; u++)
      {
        System.out.println("Parent of " + (u + 1) + ": " + (g.dispParent(u) + 1));
      }
      System.out.println("Number of cycles:\nTheoretical: 1\nResult: " + g.numCycles);
   }
   sc.close();
  }
}
