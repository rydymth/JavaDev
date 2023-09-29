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
  int nodeID;
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

  void dispNodeStruct () {
    node tmp = this.head;
    while (tmp != null) 
    {
      if (tmp.next != null)
        System.out.print((tmp.Data + 1) + " -> ");
      else
        System.out.println((tmp.Data + 1) + " ");
      tmp = tmp.next;
    }
  }
}

class graph {
  boolean flagDone = false;
  linkedList l [];
  linkedList [] res;
  int count = 0;
  boolean [] visited;
  boolean doneFlag = false;
  int nV;
  int totalWeight = 0;
  int [] weights;

  graph (int v) {
    this.nV = v;
    l = new linkedList[v];
    weights = new int[this.nV];
    res = new linkedList[v];
    visited = new boolean[v];
    for (int i = 0; i < v; i++)
    {
      visited[i] = false;
      l[i] = new linkedList();
      res[i] = new linkedList();
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
  
  linkedList DFSstack (int s) { 
    linkedList dfsNodes = new linkedList();
    stack st = new stack(nV);
    st.push(s);
    visited[s] = true;
    while (st.getSize() != 0) {
      int t = st.pop();
      totalWeight = totalWeight + weights[t];
      dfsNodes.addNode(t);
      int [] tmp = adjList(t);
      for (int i = 0; i < tmp.length; i++)
        {
          l[tmp[i]].nodeID = s;
          if (visited[tmp[i]] == false) {
            visited[tmp[i]] = true;
            st.push(tmp[i]);
          }
        }
    }
    return dfsNodes;
  }
 
  void DFSstackVoid (int s) { 
    stack st = new stack(nV);
    st.push(s);
    visited[s] = true;
    while (st.getSize() != 0) {
      int t = st.pop();
      totalWeight = totalWeight + weights[t];
      int [] tmp = adjList(t);
        for (int i = 0; i < tmp.length; i++)
          {
            l[tmp[i]].nodeID = s;
            if (visited[tmp[i]] == false) {
              visited[tmp[i]] = true;
              st.push(tmp[i]);
          }
        }
    }
  }
  
  // We should never implicitly call the dfsStack function. Only use this global function to compute dfs globally.
  void dfsNodes () {
    if (flagDone) return;
    flagDone = true;
    for (int i = 0; i < this.nV; i++) {
      if (!visited[i]) {
        this.count++;
        res[i] = this.DFSstack(i);
      }
    }
  }
 
  int numConnected () {
    if (!flagDone)
      this.dfsNodes();
    this.totalWeight = 0;
    for (int i = 0; i < this.nV; i++)
    {
      this.visited[i] = false;
    }
    return this.count;
  }
  
  void getDfsNodes (int s) {
    if (!flagDone)
      this.dfsNodes();
    linkedList dfsNodes = this.res[s];
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

  void setWeights(int i, int x) {
    this.weights[i] = x;
  }
}

public class dfs {
  
  public static int min (int [] arr) {
    int min = arr [0];
    int ind = 0;
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] < min && arr[i] >= 0) {
        min = arr[i];
        ind = i;
      }
    }
    return ind;
  }


  public static int max (int [] arr) {
    int max = arr [0];
    int ind = 0;
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] > max && arr[i] >= 0) {
        max = arr[i];
        ind = i;
      }
    }
    return ind;
  }

  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    graph g = new graph(N);
    
    // get all the edges
    for (int i = 0; i < M; i++) {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }

    // get num of museums
    for (int i = 0; i < g.nV; i++)
    {
      g.setWeights(i, sc.nextInt());
    }

    int components = g.numConnected();
    if (components < K)
      System.out.println(-1);
    else {
      for (int i = 0; i < K; i++)
      {
        if (i % 2 == 0)
        {
          int max = max(g.weights);
          g.DFSstackVoid(max);
          g.weights[max] = -1;
        }
        else {
          int min = min(g.weights);
          g.DFSstackVoid(min);
          g.weights[min] = -1;
        }
      }
      System.out.println(g.totalWeight);
    }
  }
}
