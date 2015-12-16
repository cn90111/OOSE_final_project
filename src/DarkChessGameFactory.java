
public class DarkChessGameFactory implements AbstractGameFactory
{

	@Override
	public Chess createChess() 
	{
		// TODO Auto-generated method stub
		
		return new DarkChess();
	}

	@Override
	public ChessBoard createChessBoard() 
	{
		// TODO Auto-generated method stub

		return new ChessBoard();
	}

}
