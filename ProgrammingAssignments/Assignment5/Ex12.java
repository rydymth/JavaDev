public class Ex12 {
	static int ctr = 0;
	static class A implements Runnable {
		public void run ()
		{
			for (int i = 0; i < 5; i++)
			{
				ctr++;
				System.out.println("Thread " + Thread.currentThread().getName() + " Incrementing ctr to value: " + ctr);
			}
		}
	}
	
		public static void main (String [] args)
		{
			Thread t1 = new Thread(new A(), "Thread001");
			Thread t2 = new Thread(new A(), "Thread002");
			System.out.println("2 threads created using runnable interface. Now the threads run parallely");
			t1.start();
			t2.start();
		}
}