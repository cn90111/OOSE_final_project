import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

abstract class ChessBoard extends AbstractChessBoard{

	public static final boolean HAVE_CHESS = true;
	public static final boolean NO_HAVE_CHESS = false;
	
	Player[] player;
	AbstractGameFactory f;
	
	@Override
	boolean checkPoint(int[] board, int point) {
		// TODO Auto-generated method stub

		if (board[point] == Chess.EMPTY) {
			//System.out.println("沒棋子");
			return NO_HAVE_CHESS;
		}
		//System.out.println("有棋子");
		return HAVE_CHESS;
	}
	
	public void stopgame()
	{
		for (int i = 0; i < button.length; i++) {
			button[i].setEnabled(false);
			button[i].setText("");
		}
	}
	
	public void continueGame()
	{
		for (int i = 0; i < button.length; i++) {
			button[i].setEnabled(true);
			button[i].setText("");
		}
	}
	
	public void printWarning(String message){
		
		stopgame();
		
		winner=new JFrame();
		winner.setSize(300, 100);
		winner.setVisible(true);
		winner.setLocationRelativeTo(null);
		
		winner.addWindowListener(new WindowAdapter()
		{
            public void windowClosing(WindowEvent e)
            {
            	continueGame();
            }
        });
		
		winner.setResizable(false);
		
		JPanel winnerPanel=new JPanel();
		
		JLabel winnerLabel=new JLabel();
		winnerLabel.setText(message);
		
		JButton c = new JButton("ok");
		
		winner.setLayout(new GridLayout(2, 1));
		winnerPanel.add(winnerLabel);
		winner.add(winnerPanel);
		
		winner.add(c);
		
		c.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				winner.dispose();
				continueGame();
			}
		});
	}
	
	public void setFactory(AbstractGameFactory f)
	{
		this.f = f;
	}
	
	public void printwinner(int whoplayer){
		winner=new JFrame();
		winner.setSize(300, 100);
		winner.setVisible(true);
		winner.setLocationRelativeTo(null);
		winner.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		winner.setResizable(false);
		
		JPanel winnerPanel=new JPanel();
		JLabel winnerLabel=new JLabel();
		JLabel winnerLabel2= new JLabel();
		
		JButton c = new JButton("Restart");
		JButton d = new JButton("MainView");
		JButton e = new JButton("EndGame");
		
		winner.setLayout(new GridLayout(2, 1));
		winnerPanel.add(winnerLabel);
		winner.add(winnerPanel);
		winnerLabel2.setLayout(new GridLayout(1, 3));
		winnerLabel2.add(c);
		winnerLabel2.add(d);
		winnerLabel2.add(e);
		winner.add(winnerLabel2);
		
		c.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				chessGame.dispose();
		 		winner.dispose();
		 		Game game = new Game();
		 		game.f = f;
		 		game.start();
			}
		});
		d.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				chessGame.dispose();
		 		winner.dispose();
		 		Game game = new Game();
				game.setElement();
				game.addElement();
				game.visibleElement();
			}
		});
		e.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		if (whoplayer == Chess.White) 
		{
			 winnerLabel.setText("white WIN!");
		}
		else if (whoplayer == Chess.BLACK) 
		{
			 winnerLabel.setText("black WIN!");
		}
		else if (whoplayer == Chess.RED) 
		{
			 winnerLabel.setText("red WIN!");
		}
		
	}
}
