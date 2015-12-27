<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.control.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

=======
>>>>>>> origin/master

class Game implements ActionListener
{
	Chess chess;
	ChessBoard board;
	Player[] player;
	AbstractGameFactory f;
	static final int playersCount = 2;
	
	public static final int X = 750;
	public static final int Y = 600;
	
	public static final int FiveGame = 1;
	public static final int DarkGame = 2;
	
	int falg; 
	
	JFrame title;
	
	JPanel menu;
	JPanel eastPanel;
	JPanel westPanel;
//	JPanel northPanel;
//	JPanel southtPanel;
	
	JButton startGameButton;
	JButton ruleGameButton;
	JButton exitGameButton;
	
	JButton FiveChessButton;
	JButton DarkChessButton;
	
	
	public static void main(String[] arg)
	{
<<<<<<< HEAD
		Game game=new Game();
		
		game.setElement();
		game.addElement();
		game.visibleElement();
	}
	
	public void setElement()
	{
		title = new JFrame("物件導向期末專題");
		title.setSize(X, Y);
		title.setResizable(false);
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setLocationRelativeTo(null);
		title.setLayout(new BorderLayout());
		
		menu = new JPanel();
		menu.setBackground(Color.yellow);
		menu.setLayout(new GridLayout(3,1,0,Y/6));
		
		eastPanel = new JPanel();
		eastPanel.setBackground(Color.red);
		eastPanel.setLayout(new BorderLayout());
		eastPanel.setPreferredSize(new Dimension(X/2,Y));
		
		westPanel = new JPanel();
		westPanel.setBackground(Color.blue);
		westPanel.setLayout(new BorderLayout());
		westPanel.setPreferredSize(new Dimension(X/2,Y));
		
		FiveChessButton = new JButton(new ImageIcon("./image/五子棋.jpg"));
		FiveChessButton.setText("五子棋");
		FiveChessButton.setFont(new Font(null, 0, 20));
		FiveChessButton.setVerticalTextPosition(SwingConstants.TOP);
		FiveChessButton.setHorizontalTextPosition(SwingConstants.CENTER);
		FiveChessButton.setActionCommand("FiveChessButton");
		FiveChessButton.addActionListener(this);
		
		DarkChessButton = new JButton(new ImageIcon("./image/暗棋.jpg"));
		DarkChessButton.setText("暗棋");
		DarkChessButton.setFont(new Font(null, 0, 20));
		DarkChessButton.setVerticalTextPosition(SwingConstants.TOP);
		DarkChessButton.setHorizontalTextPosition(SwingConstants.CENTER);
		DarkChessButton.setActionCommand("DarkChessButton");	
		DarkChessButton.addActionListener(this);	
		
		startGameButton = new JButton("遊戲開始");
		startGameButton.setFont(new Font(null, 0, 20));
		startGameButton.setActionCommand("startGameButton");	
		startGameButton.addActionListener(this);	
		ruleGameButton = new JButton("遊戲規則");
		ruleGameButton.setFont(new Font(null, 0, 20));
		ruleGameButton.setActionCommand("ruleGameButton");
		startGameButton.addActionListener(this);		
		exitGameButton = new JButton("離開遊戲");
		exitGameButton.setFont(new Font(null, 0, 20));
		exitGameButton.setActionCommand("exitGameButton");
	}
	
	public void addElement()
	{
		menu.add(startGameButton);
		menu.add(ruleGameButton);
		menu.add(exitGameButton);
		
		eastPanel.add(FiveChessButton,BorderLayout.CENTER);
		westPanel.add(DarkChessButton,BorderLayout.CENTER);
		
		title.add(eastPanel,BorderLayout.EAST);
		title.add(westPanel,BorderLayout.WEST);
		title.add(menu,BorderLayout.CENTER);
	}
	
	public void visibleElement()
	{
		menu.setVisible(false);
		title.setVisible(true);
=======
		
		FiveChess ff=new FiveChess();
		ff.createFiveChess();
		ff.changechess();
		ff.printchess();
		ff.CheckLine();

>>>>>>> origin/master
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

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String cmd = arg0.getActionCommand();
		
		switch(cmd)
		{
			case "FiveChessButton":
				
				menu.setVisible(true);
				eastPanel.setPreferredSize(new Dimension(X/3,Y));
				westPanel.setPreferredSize(new Dimension(X/3,Y));
				
				DarkChessButton.setVisible(false);
				FiveChessButton.setVisible(false);
				
				falg = FiveGame;
				
				break;
			case "DarkChessButton":
				
				menu.setVisible(true);
				eastPanel.setPreferredSize(new Dimension(X/3,Y));
				westPanel.setPreferredSize(new Dimension(X/3,Y));
				
				DarkChessButton.setVisible(false);
				FiveChessButton.setVisible(false);
				
				falg = DarkGame;
				
				break;
			case "startGameButton":
				
				switch(falg)
				{
					case FiveGame:
						f = new FiveChessGameFactory();
						break;
					case DarkGame:
						f = new DarkChessGameFactory();
						break;
				}
				
//				start();
				
				break;
			case "ruleGameButton":
				
				break;
			case "exitGameButton":
				
				break;
			
		}
	}
}
