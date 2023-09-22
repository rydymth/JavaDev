import java.util.Scanner;
public class A {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            String input = sc.next();
            char [] str = input.toCharArray();
            if (str[0] == 'a' || str[1] == 'b' || str[2] == 'c')
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}