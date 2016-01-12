import javax.swing.JButton;
import javax.swing.JFrame;

abstract class AbstractChessBoard 
{
	
	public JFrame chessGame;
	JFrame winner;
	public JButton[] button;
	
	abstract boolean checkPoint(int[] board, int point);
	abstract void setChess(Chess chess);
	abstract void setFactory(AbstractGameFactory f);
}
