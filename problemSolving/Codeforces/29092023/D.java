import java.util.Scanner;

public class D {
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int t = sc.nextInt();
            int k = sc.nextInt();
            String inp = sc.next();
            int count = 0;
            int j = 0;
            while (j < t) {
                if (inp.charAt(j) == 'B')
                {
                    count++;
                    j += k;
                }
                else
                    j++;
                    continue;
            }
            System.out.println(count);
        }
        sc.close();
    }
}