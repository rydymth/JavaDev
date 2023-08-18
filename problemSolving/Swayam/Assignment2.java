import system.util.Scanner;

public class mergesort 
{
    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }	
}

public class node
{
	public int data;
	public node next;
	public node head;
	public node(int data) {
		this.head = null;
		this.data = data;
		this.next = null;
	}
}

public class nodeImpl
{
	public static node addNode (node list, int data) {
		node newNode = new node(data);
		if (list.head == null) {
			list.head = newNode;
		}
		else
		{
			Node last = list.head;
			while (last.next != null)
			{
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}

	public static int getCount(node list)
	    {
	        Node temp = head;
	        int count = 0;
	        while (temp != null) {
	            count++;
	            temp = temp.next;
	        }
	        return count;
	    }
}

public class graph
{
	private int v;
	private nodeImpl [] ll;
	graph (int n)
	{
		this.v = n;
		ll = new nodeImpl[n];
		for (int i = 0; i < n; i++)
		{
			ll[i] = new nodeImpl();
		}
	}

	public static void addEdge(int u, int v)
	{
		ll[u].addNode(ll[u],v);
	}

	public static BFS(int s)
	{
		boolean [] visited = new boolean[this.v];
		

		visited[s] = true;
		queue.addNode(queue, s);
		while (queue.getCount(queue) !=  0)
		{
			
		}
	}
}

public class Assignment2
{

	Scanner sc = new Scanner(System.in);
	static int n = 0;
	static int [] nodes;
	Assignment2(){
	}


	static int [][] adjList (int n, int edgesNum)
	{
		int [] listCount = new int [n];
		int count = 0;
		for (int i = 0; i < edgesNum; i++)
		{
			list[sc.nextInt() - 1] = ++count;
		}
		

	}
	static int [] bfs ()
	{
		boolean [] disc = new boolean[n];
		
	}
}
