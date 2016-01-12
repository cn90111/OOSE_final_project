public class DarkChess extends Chess {
//	int[] weight;
//	boolean[] isOpen;
	
	int weight;
	int chess_ID;
	boolean isOpen;
	String name;
	int color;

	DarkChess[] chessarrays;

	//查表法
	public static final String[] chessName = new String[] {
			"將","士","士","象","象","車","車","馬","馬","包","包","卒","卒","卒","卒","卒",
			"帥","仕","仕","相","相","俥","俥","傌","傌","炮","炮","兵","兵","兵","兵","兵"
	};
	
	public static final int[] chessWeight = new int[] { 
		1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7, 
		1,2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7
		};

	public DarkChess() 
	{
		
	}
}
