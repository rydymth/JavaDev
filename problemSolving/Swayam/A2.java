import java.io.*;
import java.util.*;

public class A2 {
    static void merge(int arr[], int arr2[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int L2[] = new int[n1];
        int R[] = new int[n2];
        int R2[] = new int[n2];
        for (int i = 0; i < n1; ++i)
			{
				L[i] = arr[l + i];
				L2[i] = arr2[l + i];
			}
        for (int j = 0; j < n2; ++j)
			{
				R[j] = arr[m + 1 + j];
				R2[j] = arr2[m + 1 + j];
			}
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
				arr2[k] = L2[i];
                i++;
            }
            else {
                arr[k] = R[j];
				arr2[k] = R2[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
			arr2[k] = L2[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            arr2[k] = R2[j];
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
            merge(arr, arr2,l, m, r);
        }
    }	
	
	public static Scanner sc = new Scanner(System.in);
    private static int V;
    private static LinkedList<Integer> adj[];
	private static int count = 0;
	private static int connectedCount = 0;	
	private static int [] mus;
	private static int [] ctr;
	private static int sum = 0;


    A2 (int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    static void addEdge(int v, int w) { adj[v].add(w); }

    static void BFS (int s)
    {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
 
        while (queue.size() != 0) {
            s = queue.poll();
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
					System.out.println(mus[ctr[n]]);
					sum = sum + mus[ctr[n]];
                }
            }
        }
    }

	public static void main (String [] args)
	{
		int cities = sc.nextInt();
		int roads = sc.nextInt();
		int months = sc.nextInt();
		mus = new int[cities];
		ctr = new int[cities];
		A2 a = new A2(cities);
		for (int i = 0; i < roads; i++)
		{
			a.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
		}

		for (int i = 0; i < cities; i++)
		{
			mus[i] = sc.nextInt();
			ctr[i] = i;
		}
		sort(mus, ctr, 0, cities - 1);
		for (int i = 0; i < months; i++)
		{
			if (i % 2 == 0)
			{
				a.BFS(ctr[months - 1 - i]);
			}
			else
			{
				a.BFS(ctr[i]);
			}
		}
		System.out.print(sum);
	}
}
