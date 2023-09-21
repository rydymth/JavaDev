import java.util.Scanner;
class stack
{
  Integer [] stack;
  Integer size;
  Integer maxCapacity;
  Integer itr = 0;
  stack (Integer n) {
    this.stack = new Integer[n];
    maxCapacity = n;
    size = 0;
  }

  void push (Integer n) {
    if (size == maxCapacity)
      { System.out.println("Stack is full"); }
    else
    {
      stack[itr] = n;
      itr++;
      size++;
    }
  }

  Integer pop () {
    if (size == 0)
      { System.out.println("Stack is empty"); return null;}
    else
    {
      int ret = stack[itr - 1];
      itr--;
      size--;
      return ret;
    }
  }

  Integer getSize() { return this.size; }
  Integer getMaxSize() { return this.maxCapacity; }
}

class node {
  Integer Data;
  node next;
  node () {
    this.Data = null;
    this.next = null;
  }
  
  node (Integer Data)
  {
    this.Data = Data;
    this.next = null;
  }
}

class linkedList {
  node head;
  int size;
  linkedList ()
  {
    size = 0;
    head = null;
  }

  void addNode (Integer Data)
  {
    size++;
    node newNode = new node(Data);
    if (head == null) head = newNode;
    else {
      node tmp = head;
      while (tmp.next != null) {
        tmp = tmp.next;
      }
      tmp.next = newNode;
    }
  }

  int getSize() {
    return this.size;
  }
  
  int getLast() {
    node n = this.head;
    while (n.next != null) { n = n.next; }
    return n.Data;
  }
}

class graph {
  int numOfComponents = 0;
  boolean dfsDone = false;
  linkedList l [];
  int nV;
  boolean [] visited;
  graph (int v) {
    this.nV = v;
    l = new linkedList[v];
    visited = new boolean[nV];
    for (int i = 0; i < v; i++)
    {
      visited[i] = false;
      l[i] = new linkedList();
    }
  }

  void addEdge (int source, int dest)
  {
    l[source - 1].addNode(dest - 1);
    l[dest - 1].addNode(source - 1);
  }

  int [] adjList (int s) {
    int n = l[s].getSize();
    int [] ret = new int[n];
    node tmp = l[s].head;
    for (int i = 0; tmp != null; tmp = tmp.next, i++)
    {
      ret[i] = tmp.Data;
    }
    return ret;
  }

  int connectedComponents () {
    int count = 0;
    for (int i = 0; i < this.nV; i++) {
      linkedList tmp = DFSstack(i);
      count++; 
      i = tmp.getLast();
    }
    return count;
  }

  linkedList DFSstack (int s) {
    linkedList dfsNodes = new linkedList();
    stack st = new stack(nV);
    st.push(s);
    visited[s] = true;
    while (st.getSize() != 0) {
      int t = st.pop();
      dfsNodes.addNode(t);
      int [] tmp = adjList(t);
      for (int i = 0; i < tmp.length; i++)
      {
        if (visited[tmp[i]] == false) {
          visited[tmp[i]] = true;
          st.push(tmp[i]);
        }
      }
    }
    return dfsNodes;
  }

  void getDfsNodes (int s) {
    linkedList dfsNodes = this.DFSstack(s);
    node tmp = dfsNodes.head;
    while (tmp != null) {
      if (tmp.next == null) {
        System.out.print((tmp.Data + 1));
        return;
      }
      else { System.out.print((tmp.Data + 1)+ " -> "); }
      tmp = tmp.next;
    }
  }
}

public class dfs {
  public static void main( String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    graph g = new graph(N + 2);
    for (int i = 0; i < M; i++) {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    g.addEdge(11, 12);
    System.out.println(g.connectedComponents());
  }
}
