
public class Timer extends Thread
{
	int time = 0;
	boolean exit = false;
		
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		while(!exit)
		{
			try 
			{
				Thread.sleep(1000);
				time++;
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getTime()
	{
		return time;
	}
	
	public void resetTime()
	{
		time = 0;
	}
	
	public void quit()
	{
		exit = true;
	}
}
