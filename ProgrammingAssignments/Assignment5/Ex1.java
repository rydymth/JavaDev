public class Ex1 {
	static int ctr = 0;
	
	static class A extends Thread {
		A (String s) {
			super(s);
		}
		public void run () {
			for (int i = 0; i < 3; i++)
			{
				ctr++;
				System.out.println("Thread: " + super.getName() + "\nUpdating ctr: " + ctr);
			}
		}
	}
	
	static class B extends Thread {
		B (String s) {
			super(s);
		}
		public void run () {
			for (int i = 0; i < 3; i++)
			{
				ctr++;
				System.out.println("Thread: " + super.getName() + "\nUpdating ctr: " + ctr);
			}
		}
	}
	
	static class C extends Thread {
		C (String s) {
			super(s);
		}
		public void run () {
			for (int i = 0; i < 4; i++)
			{
				ctr++;
				System.out.println("Thread: " + super.getName() + "\nUpdating ctr: " + ctr);
			}
		}
	}
	
	public static void main(String args [])
	{
		System.out.println("Updating the value of " + ctr + " parallely");
		A a = new A("Thread001");
		B b = new B("Thread002");
		C c = new C("Thread003");
		a.start();
		b.start();
		c.start();
	}
}