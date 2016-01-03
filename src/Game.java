import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class Game implements ActionListener
{
	Chess chess;
	ChessBoard board;
	Rule rule;
	Player[] player;
	AbstractGameFactory f;
	static final int playersCount = 2;
	
	public static final int X = 750;
	public static final int Y = 600;
	
	public static final int NO_SELECT_GAME = 0;
	public static final int FIVE_GAME = 1;
	public static final int DARK_GAME = 2;
	
	int falg = NO_SELECT_GAME; 
	
	JFrame title;
	
	JPanel menu;
	JPanel eastPanel;
	JPanel westPanel;
	
	JPanel tempPanel1;
	JPanel tempPanel2;
	JPanel tempPanel3;
	
	JButton startGameButton;
//	JButton ruleGameButton;
	JButton exitGameButton;
	
	JButton FiveChessButton;
	JButton DarkChessButton;
	
	JLabel background = new JLabel();
	

	ImageIcon fiveChessimg = new ImageIcon("./image/fiveChessBig.jpg");
	ImageIcon darkChessimg = new ImageIcon("./image/darkChessBig.jpg");
	
	public static void main(String[] arg)
	{
		Game game=new Game();
		game.setElement();
		game.addElement();
		game.visibleElement();
		
	}
	

	final void start()
	{
		initializaGame();
//		int i = 0;
//		
//		while(!endOfGame())
//		{
//			makePlay(i);
//			i = ( i+1 ) % playersCount;
//		}
//		
//		printWinner();
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
		rule = f.createRule();
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
	
	public void setElement()
	{
		title = new JFrame("OOSE_final_project");
		title.setSize(X, Y);
		title.setResizable(false);
		title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		title.setLocationRelativeTo(null);
		title.setLayout(new BorderLayout());
		
		menu = new JPanel();
		menu.setBackground(Color.yellow);
		menu.setLayout(new GridLayout(5,1,0,0));
		menu.setOpaque(false);
		
		eastPanel = new JPanel();
		eastPanel.setBackground(Color.red);
		eastPanel.setLayout(new BorderLayout());
		eastPanel.setPreferredSize(new Dimension(X/2,Y));
		eastPanel.setOpaque(false);
		
		westPanel = new JPanel();
		westPanel.setBackground(Color.blue);
		westPanel.setLayout(new BorderLayout());
		westPanel.setPreferredSize(new Dimension(X/2,Y));
		westPanel.setOpaque(false);
		
		tempPanel1 = new JPanel();
		tempPanel1.setOpaque(false);
		tempPanel2 = new JPanel();
		tempPanel2.setOpaque(false);
		tempPanel3 = new JPanel();
		tempPanel3.setOpaque(false);
		
		FiveChessButton = new JButton(new ImageIcon("./image/fiveChess.jpg"));
		FiveChessButton.setText("fiveChess");
		FiveChessButton.setFont(new Font(null, 0, 20));
		FiveChessButton.setVerticalTextPosition(SwingConstants.TOP);
		FiveChessButton.setHorizontalTextPosition(SwingConstants.CENTER);
		FiveChessButton.setActionCommand("FiveChessButton");
		FiveChessButton.addActionListener(this);
		
		DarkChessButton = new JButton(new ImageIcon("./image/darkChess.jpg"));
		DarkChessButton.setText("darkChess");

		DarkChessButton.setFont(new Font(null, 0, 20));
		DarkChessButton.setVerticalTextPosition(SwingConstants.TOP);
		DarkChessButton.setHorizontalTextPosition(SwingConstants.CENTER);
		DarkChessButton.setActionCommand("DarkChessButton");	
		DarkChessButton.addActionListener(this);	
		
		startGameButton = new JButton("game start");
		startGameButton.setFont(new Font(null, 0, 20));
		startGameButton.setActionCommand("startGameButton");	
		startGameButton.addActionListener(this);	
//		ruleGameButton = new JButton("遊戲規則");
//		ruleGameButton.setFont(new Font(null, 0, 20));
//		ruleGameButton.setActionCommand("ruleGameButton");
//		ruleGameButton.addActionListener(this);		
		exitGameButton = new JButton("exit game");
		exitGameButton.setFont(new Font(null, 0, 20));
		exitGameButton.setActionCommand("exitGameButton");
		exitGameButton.addActionListener(this);
	}
	
	public void addElement()
	{
		menu.add(tempPanel1);
		menu.add(startGameButton);
		menu.add(tempPanel2);
//		menu.add(ruleGameButton);
		menu.add(exitGameButton);
		menu.add(tempPanel3);
		
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
				
				falg = FIVE_GAME;

				((JPanel)title.getContentPane()).setOpaque(false);
				
				if(background.getIcon() != null)
				{
					if(background.getIcon().equals(darkChessimg))
					{
						title.getLayeredPane().remove(background);
					}
				}
				
				background.setIcon(fiveChessimg);
				title.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
				background.setBounds(0, 0, fiveChessimg.getIconWidth(), fiveChessimg.getIconHeight());
				
				
				break;
			case "DarkChessButton":
				
				menu.setVisible(true);
				eastPanel.setPreferredSize(new Dimension(X/3,Y));
				westPanel.setPreferredSize(new Dimension(X/3,Y));
				
				DarkChessButton.setVisible(false);
				FiveChessButton.setVisible(false);
				
				falg = DARK_GAME;
				

				((JPanel)title.getContentPane()).setOpaque(false);
				
				if(background.getIcon() != null)
				{
					if(background.getIcon().equals(fiveChessimg))
					{
						title.getLayeredPane().remove(background);
					}
				}
				
				
				background.setIcon(darkChessimg);
				title.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
				background.setBounds(0, 0, darkChessimg.getIconWidth(), darkChessimg.getIconHeight());

				
				break;
			case "startGameButton":
				
				switch(falg)
				{
					case FIVE_GAME:
						f = new FiveChessGameFactory();
						break;
					case DARK_GAME:
						f = new DarkChessGameFactory();
						break;
				}
				
				start();
				title.setVisible(false);
				
				break;
//			case "ruleGameButton":
//				
//				break;
			case "exitGameButton":
				
				menu.setVisible(false);
				eastPanel.setPreferredSize(new Dimension(X/2,Y));
				westPanel.setPreferredSize(new Dimension(X/2,Y));

				DarkChessButton.setVisible(true);
				FiveChessButton.setVisible(true);
				
				falg = NO_SELECT_GAME;
				
				break;
			
		}
	}
}
