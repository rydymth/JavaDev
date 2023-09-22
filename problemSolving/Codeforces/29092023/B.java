import java.util.Scanner;
 
public class B {
 
    public static int  [] minAddedArray (int [] array) {
        int min = array[0];
        int minI = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
            {
                min = array[i];
                minI = i;
            }
        }
        array[minI] = array[minI] + 1;
        return array;
    }
 
    public static long arrayProd (int [] array) {
        long prod = 1;
        for (int i = 0; i < array.length; i++)
        {
            prod *= array[i];
        }
        return prod;
    }
 
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            int arrLen = sc.nextInt();
            int [] tmpArr = new int[arrLen];
            for (int j = 0; j < arrLen; j++)
            {
                tmpArr[j] = sc.nextInt();
            }
            tmpArr = minAddedArray(tmpArr);
            System.out.println(arrayProd(tmpArr));
        }
        sc.close();
    }
}