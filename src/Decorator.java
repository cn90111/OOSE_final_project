
abstract class Decorator extends AbstractChessBoard
{
	AbstractChessBoard temp;
	
	public Decorator(AbstractChessBoard temp)
	{
		this.temp = temp;
	}
	
	void checkPoint()
	{
		temp.checkPoint();
	}
	
	abstract void addedBehavior();
}
