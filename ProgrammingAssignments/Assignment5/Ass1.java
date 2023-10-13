class tables {
	synchronized public void writeTable(int n)
	{
		for(int i = 1; i <= 10; ++i)
		{
		    System.out.printf("%d * %d = %d \n", n, i, n * i);
		}
	}
}

class tableThread extends Thread
{
	int a;
	tables t = new tables();
	tableThread(String s)
	{
		super(s);
		a = Integer.parseInt(s);
	}
	public void run()
	{
		t.writeTable(a);
	}
}

class SyncBlock extends Thread
{
	int a;
	tables t = new tables();
	SyncBlock(String s)
	{
		super(s);
		a = Integer.parseInt(s);
	}
	public void run()
	{
		synchronized(this)
		{
			int n = a;
			for(int i = 1; i <= 10; ++i)
			{
			    System.out.printf("%d * %d = %d \n", n, i, n * i);
			}
		}
	}
}

public class Ex4 {
	public static void main(String [] args)
	{
		// Give input as a String
		// Did janky work here
		tableThread t5 = new tableThread("5");
		tableThread t10 = new tableThread("10");
		tableThread t20 = new tableThread("20");
		t5.start();
		t10.start();
		t20.start();
		// doing via block
		SyncBlock S5 = new SyncBlock("5");
		SyncBlock S10 = new SyncBlock("10");
		SyncBlock S20 = new SyncBlock("20");
		S5.start();
		S10.start();
		S20.start();
	}
}