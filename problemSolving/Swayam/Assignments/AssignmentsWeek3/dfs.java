import java.util.Random;
import java.util.random.*;
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
}

class graph {
  linkedList l [];
  int nV;
  linkedList dfsNodes;
  graph (int v) {
    this.nV = v;
    l = new linkedList[v];
    for (int i = 0; i < v; i++)
    {
      l[i] = new linkedList();
    }
    dfsNodes = new linkedList();
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

  void DFSstack (int s) {
    boolean [] visited = new boolean[nV];
    for (int i = 0; i < nV; i++)
    {
      visited[i] = false;
    }
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
  }

  void getDfsNodes (int s) {
    this.DFSstack(s);
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
    graph g = new graph(5);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    g.addEdge(4, 5);
    g.getDfsNodes(0);
  }
}
