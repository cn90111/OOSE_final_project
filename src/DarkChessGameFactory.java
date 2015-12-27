
public class DarkChessGameFactory extends AbstractGameFactory
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

		return new DarkChessBoard();
	}

	@Override
	Rule createRule() {
		// TODO Auto-generated method stub
		return new DarkRule();
	}

}
