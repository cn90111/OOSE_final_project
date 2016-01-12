
abstract class Decorator extends AbstractChessBoard
{
	AbstractChessBoard temp;
	
	public Decorator(AbstractChessBoard temp)
	{
		this.temp = temp;
	}
	
	boolean checkPoint(int[] board, int point)
	{
		return temp.checkPoint(board,point);
	}
	
	void setChess(Chess chess)
	{
		temp.setChess(chess);
	}
	
	void setFactory(AbstractGameFactory f)
	{
		temp.setFactory(f);
	}
	
	abstract void addedBehavior();
	
}
