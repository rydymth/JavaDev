import java.util.Scanner;
 
public class C {
    public static int marks (int i, int j) {
        if (i == 0 || j == 0 || i == 9 || j == 9)
            return 1;
        else if (i == 1 || j == 1 || i == 8 || j == 8)
            return 2;
        else if (i == 2 || j == 2 || i == 7 || j == 7)
            return 3;
        else if (i == 3 || j == 3 || i == 6 || j == 6)
            return 4;
        else
            return 5;
    }
    
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int marks = 0;
                for (int k = 0; k < 10; k++) {
                    String inp = sc.next();
                    for (int j = 0; j < 10; j++) {
                        char x = inp.charAt(j);
                        if (x == 'X')
                        {
                            marks += marks(k, j);
                        }
                        else
                            continue;
                    }
            }
            System.out.println(marks);
        }
        sc.close();
    }
    
}