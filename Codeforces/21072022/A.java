import java.util.Scanner;
public class A {
  public static void main (String [] args)
{
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++)
  {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      if (a + b >= 10 || a + c >= 10 || b + c >= 10 )
    {
        System.out.print("YES");
      }
      else{
        System.out.print("NO");
      }
      System.out.print("\n");
    }
  }
}
