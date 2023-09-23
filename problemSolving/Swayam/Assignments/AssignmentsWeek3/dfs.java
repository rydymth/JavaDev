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
}

class mima {
  int ret;
  int [] arr;
}

public class dfs {
  
  public static mima min (int [] arr) {
    mima m = new mima();
    int min = arr [0];
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    int [] retArr = new int[arr.length - 1];
    int i = 0;
    while (i < arr.length)
    {
      if (arr[i] == min)
        continue;
      retArr[i] = arr[i];
      i++;
    }
    m.arr = retArr;
    m.ret = min;
    return m;
  }


  public static mima max (int [] arr) {
    mima m = new mima();
    int max = arr [0];
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    int [] retArr = new int[arr.length - 1];
    int i = 0;
    while (i < arr.length)
    {
      if (arr[i] == max)
        continue;
      retArr[i] = arr[i];
      i++;
    }
    m.arr = retArr;
    m.ret = max;
    return m;
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
      g.weights[i] = sc.nextInt();
    }
    int components = g.numConnected();
    if (components < K)
      System.out.println(-1);
    else {
      int sum = 0;
      for (int i = 0; i < K; i++)
      {

      }
    }
 
  }
}
