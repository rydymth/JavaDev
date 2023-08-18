import java.util.Scanner;
public class A {
  public int dist (int a, int b, int c, int d)
{
    int res = Math.abs(c - a) + Math.abs(d - b);
    return res;
  }
  public static void main (String [] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; t < n; i++)
  {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      for (int j = 0; j < k; j++)
    {
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        if (res(x + 1, y, x1 + 1, x2) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x, y + 1, x1, x2 + 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y + 1, x1 + 1, x2 + 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x - 1, y - 1, x1 - 1, x2 - 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x - 1, y, x1 - 1, x2) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x, y - 1, x1, x2 - 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y - 1, x1 + 1, x2 - 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x - 1, y + 1, x1 - 1, x2 + 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else {
          System.out.print("NO");
        }
      }
    }
  }
}
