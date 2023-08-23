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

// Implementing the linked list with head data and next
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
  private Node [] list;
  graph (int v)
  {
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
}

public class Assignment2
{
  // Implementing merge sort in such a way that 2 arrays will get sorted,
  // One will be the original array with values to be arranges in ascending order
  // the other will be the original counter. The original counter must retain
  /* Example:
   * 5 3 4 2 1 Original array A1 to be sorted,
   * 0 1 2 3 4 The index array A2 of the array above
   * --------------
   *  After sort
   *  1 2 3 4 5 The original array A1 sorted in ascending order
   *  4 3 1 2 0 THe index array A2 which has not lost the origin counter(mapped)
   * */
  static void merge(int arr[], int arr2[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int L1[] = new int[n1];
        int R[] = new int[n2];
        int R1[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
        {
          L[i] = arr[l + i];
          L1[i] = arr2[l + i];
        }
        for (int j = 0; j < n2; ++j)
        {
          R[j] = arr[m + 1 + j];
          R1[j] = arr2[m + 1 + j];
        }
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                arr2[k] = L1[i];
                i++;
            }
            else {
                arr[k] = R[j];
                arr2[k] = R1[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            arr2[k] = L1[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            arr2[k] = R1[j];
            j++;
            k++;
        }
    }
 
    static void sort(int arr[], int arr2[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
 
            sort(arr, arr2, l, m);
            sort(arr, arr2, m + 1, r);
 
            merge(arr, arr2, l, m, r);
        }
    }
	public static void main (String [] args)
	{
    // If the number of months given to us are more than number disjoint connected components in the graph:
    //  return -1


    /* 
     * We are given N museums and 2 people.
     * First person will choose the city such that it will have max museums
     * Then the second person will chose the city such that it will have min number of museums
     * */
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    graph g = new graph(N);
    for (int i = 0; i < M; i++)
    {
      g.addEdges(sc.nextInt(), sc.nextInt());
    }

    int [] museums = new int[N];
    int [] mctr = new int[N];
    for (int i = 0; i < N; i++)
    {
      museums[i] = sc.nextInt();
      mctr[i] = i;
    }

    // Here we have sorted the 2 arrays,
    // One containing the museums per city
    // the other is its original counter
    // The original counter is for the graph to start bfs from that node
    // If the node is empty we can just use the museum[last element - i]
    sort(museums, mctr, 0, N-1);
    for (int i = 0; i < museums.length; i++)
      System.out.println(mctr[i] + ": " + museums[i]);

    /*
     * We will run the loop till K number of vacation months
     * TODO:
     *  - Better way to debug
     *  - Error: Answer is little less than needed
     *  - Possible reasons:
     *    - counter confusion,
     *    - Incorrect value is most probably being used
     *    - We might be summing a particular value again because of n -- null condition
     *  - Taking too much memory. Optimize
     * */
    if (g.connectedNum() < K)
      System.out.println(-1);
    else
    {
      int sum = 0;
for (int i = 0; i < K; i++)
      {
        if (i % 2 == 0)
        {
          Node n = g.BFS(mctr[N - 1 - i]).head;
          if (n == null)
          {
            sum = sum + museums[N - 1 - i];
          } 
          else
          {
            sum = sum + museums[n.data];
            while (n.next != null)
            {
              n = n.next;
              sum = sum + museums[n.data];
            }
          }
        }
        else
        {
          Node n = g.BFS(mctr[i - 1]).head;
          if (n == null)
          {
            sum = sum + museums[mctr[i - 1]];
          } 
          else
          {
            sum = sum + museums[n.data];
            while (n.next != null)
            {
              n = n.next;
              sum = sum + museums[n.data];
            }
          }
        }
      }
      System.out.println(sum);
    }
    sc.close();
  }
}
