import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DarkChessBoard extends ChessBoard implements ActionListener
{
	JFrame DarkBoard;
	JPanel CenterBoard;
	DarkChess darkChess;
	
	JButton[] button = new JButton[32];
	
	public static final int X = 600;
	public static final int Y = 400;
	
	public static final int BLACK = 0;
	public static final int RED = 1;
	
	public static final int PLAYER1 = 0;
	public static final int PLAYER2 = 1;
	public static final int PLAYER_TOTAL = 2;
	
	boolean firstOpen = false;
	
	int clickConut = 0;
	
	int flag;
	
	int NowPlayer = PLAYER1;
	int NextPlayer = PLAYER2;
	int[] playerColor = new int[PLAYER_TOTAL];
	
	boolean changePlayer = false;
	
	public DarkChessBoard()
	{
		setElement();
		addElement();
		visibleElement();
		
		darkChess=new DarkChess();
	}
	
	void showEatenChess()
	{
		
	}
	
	void checkCanEat()
	{
		
	}
	
	private void printChess()
	{
		for(int i=0 ; i<32 ; i++)
		{
			
			if(darkChess.chessarrays[i] == -1)
			{
				button[i].setIcon(null);
			}
			else
			{
				if(darkChess.isOpen[i] == true)
				{
					switch(darkChess.chessarrays[i])
					{
						case 0:
							button[i].setIcon(new ImageIcon("./image/Black_01.png"));
							break;
						case 1:
						case 2:
							button[i].setIcon(new ImageIcon("./image/Black_02.png"));
							break;
						case 3:
						case 4:
							button[i].setIcon(new ImageIcon("./image/Black_03.png"));
							break;
						case 5:
						case 6:
							button[i].setIcon(new ImageIcon("./image/Black_04.png"));
							break;
						case 7:
						case 8:
							button[i].setIcon(new ImageIcon("./image/Black_05.png"));
							break;
						case 9:
						case 10:
							button[i].setIcon(new ImageIcon("./image/Black_06.png"));
							break;
						case 11:
						case 12:
						case 13:
						case 14:
						case 15:
							button[i].setIcon(new ImageIcon("./image/Black_07.png"));
							break;
						case 16:
							button[i].setIcon(new ImageIcon("./image/Red_01.png"));
							break;
						case 17:
						case 18:
							button[i].setIcon(new ImageIcon("./image/Red_02.png"));
							break;
						case 19:
						case 20:
							button[i].setIcon(new ImageIcon("./image/Red_03.png"));
							break;
						case 21:
						case 22:
							button[i].setIcon(new ImageIcon("./image/Red_04.png"));
							break;
						case 23:
						case 24:
							button[i].setIcon(new ImageIcon("./image/Red_05.png"));
							break;
						case 25:
						case 26:
							button[i].setIcon(new ImageIcon("./image/Red_06.png"));
							break;
						case 27:
						case 28:
						case 29:
						case 30:
						case 31:
							button[i].setIcon(new ImageIcon("./image/Red_07.png"));
							break;
					}
				}
			}
		}
	}
	
	public void setElement()
	{
		DarkBoard = new JFrame("DarkChess");
		DarkBoard.setSize(new Dimension(X,Y));
		DarkBoard.setLayout(new BorderLayout());
		DarkBoard.setResizable(false);
		DarkBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DarkBoard.setLocationRelativeTo(null);
		
		CenterBoard = new JPanel();
		CenterBoard.setLayout(new GridLayout(4,8,0,0));
		
		for(int i = 0 ; i<button.length ; i++)
		{
			button[i] = new JButton();
			button[i].setIcon(new ImageIcon("./image/backChess.jpg"));
			button[i].setActionCommand("" + i);
			button[i].addActionListener(this);
		}
	}
	
	public void addElement()
	{
		for(int i = 0 ; i<button.length ; i++)
		{
			CenterBoard.add(button[i]);
		}
		
		DarkBoard.add(CenterBoard,BorderLayout.CENTER);
	}
	
	public void visibleElement()
	{
		DarkBoard.setVisible(true);
	}
	
	public int getColor(int temp)
	{
		return darkChess.chessarrays[temp]/16 == 0?BLACK:RED;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		int temp;
		temp = Integer.parseInt(arg0.getActionCommand());
		int firstTemp = 0;
		
		//設定玩家的顏色
		if(firstOpen == false)
		{
			if(getColor(temp) == BLACK)
			{
				playerColor[NowPlayer] = BLACK;
				playerColor[NextPlayer] = RED;
			}
			else
			{
				playerColor[NowPlayer] = RED;
				playerColor[NextPlayer] = BLACK;
			}
			
			firstOpen = true;
		}
		
		switch(clickConut)
		{
			case 0:
				if(darkChess.isOpen[temp] == false) // 翻棋
				{
					darkChess.isOpen[temp] = true;
					changePlayer = true;
				}
				else //點別的棋子
				{
					if(getColor(temp) == playerColor[NowPlayer])//自己的棋子，判斷有後續動作
					{
						firstTemp = temp;
						clickConut++;
					}
					else //別人的棋子
					{
						
					}
				}
				break;
			case 1:
				if(darkChess.isOpen[temp] == false) // 如果還沒翻開
				{
					clickConut = 0;
				}
				else //點別的棋子
				{
					if(getColor(temp) == playerColor[NowPlayer])//自己的棋子
					{
						clickConut = 0;
					}
					else //別人的棋子
					{
						if(darkChess.weight[firstTemp] < darkChess.weight[temp])
						{
							System.out.println("可以吃");
						}
					}
				}
				break;
		}
		
		//更新畫面
		printChess();
		
		//換人
		if(changePlayer == true)
		{
			switch(NowPlayer)
			{
				case PLAYER1:
					NowPlayer = PLAYER2;
					NextPlayer = PLAYER1;
					break;
				case PLAYER2:
					NowPlayer = PLAYER1;
					NextPlayer = PLAYER2;
					break;	
			}
		}
	}
}
