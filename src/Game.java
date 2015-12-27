
class Game 
{
	Chess chess;
	ChessBoard board;
	Player[] player;
	AbstractGameFactory f;
	static final int playersCount = 2;
	
	public static void main(String[] arg)
	{
		
		FiveChess ff=new FiveChess();
		ff.CheckLine();

	}
	
	final void start()
	{
		initializaGame();
		int i = 0;
		
		while(!endOfGame())
		{
			makePlay(i);
			i = ( i+1 ) % playersCount;
		}
		
		printWinner();
	}
	
	final void timeCount()
	{
		Timer timer = new Timer();
		timer.start();
	}
	
	void initializaGame()
	{
		chess = f.createChess();
		board = f.createChessBoard();
	}
	void makePlay(int player)
	{
		
	}
	boolean endOfGame()
	{
		return false;
		
	}
	void printWinner()
	{
		
	}
}
