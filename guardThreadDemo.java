class StopThread implements Runnable
{
	private boolean flag = true;
	public synchronized void run()
	{
		while (flag)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().getName()+"...Exception");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName()+"...run");
		}
	}
	public void changeFlag()
	{
		flag = false;
	}
}

class  guardThreadDemo
{
	public static void main(String[] args) 
	{
		StopThread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		
		t1.setDaemon(true);//标记成后台线程
		t2.setDaemon(true);
		t1.start();
		t2.start();

		int num = 0;

		while (true)
		{
			if (num++ == 60)
			{
				//st.changeFlag();
				t1.interrupt();
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"...num");
		}
		System.out.println("over");
	}
}
