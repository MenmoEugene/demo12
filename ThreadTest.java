/*
yield: 
作用:暂停当前正在执行的线程对象，并执行其他线程。使其达到多个线程均衡交替执行的效果。

Thread.yield();
*/
class ThreadTest
{
	public static void main(String[] args) 
	{
		new Thread()//匿名内部类调用
		{
			public void run()
			{
				for (int x= 0;x<70;x++)
				{
					System.out.println(Thread.currentThread().getName()+"..."+x);
				}
			}
		}.start();

		for (int x=0;x<100;x++)
		{
			System.out.println(Thread.currentThread().getName()+"..."+x);
		}

		Runnable r = new Runnable()
		{
			public void run()
			{
				for (int x=0;x<100;x++)
				{
					System.out.println(Thread.currentThread().getName()+"..."+x);
				}
			}
		};
		new Thread(r).start();

		//new Test1().start();
	}
}
/*
class Test1 extends Thread
{
	public void run()
	{
		for (int x=0;x<100;x++)
		{
			System.out.println(Thread.currentThread().getName()+"..."+x);
		}
	}
}
*/