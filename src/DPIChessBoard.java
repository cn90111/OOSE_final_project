
public class DPIChessBoard extends Decorator
{

	public DPIChessBoard(AbstractChessBoard temp) 
	{
		super(temp);
		// TODO Auto-generated constructor stub
	}

	void checkPoint()
	{
		super.checkPoint();
		addedBehavior();
	}
	
	@Override
	void addedBehavior() 
	{
		// TODO Auto-generated method stub
		
	}

}
