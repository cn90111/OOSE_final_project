import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

class FiveChessBoard extends ChessBoard implements ActionListener 
{
	FiveChess fc;
	int nowPlayer;
	
	public FiveChessBoard() {
		button = new JButton[225];
		
		player = new Player[2];
		player[0] = new Player();
		player[0].color = Chess.White;
		player[1] = new Player();
		player[1].color = Chess.BLACK;
		nowPlayer = 0;
		
		chessGame= new JFrame();
		chessGame.setSize(750, 750);
		chessGame.setResizable(false);
		chessGame.setLocationRelativeTo(null);
		
		chessGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel labelc = new JPanel();
		JPanel panele = new JPanel();
		JPanel panelw = new JPanel();
		JLabel labele = new JLabel(new ImageIcon("white.jpg"));
		JLabel labelw = new JLabel(new ImageIcon("black.jpg"));
		panele.add(labele);
		panelw.add(labelw);
		labelc.setLayout(new GridLayout(15, 15));
		
		chessGame.add(labelc, BorderLayout.CENTER);
		
		for (int i = 0; i < 225; i++) {
			button[i] = new JButton("" + (i + 1));
			button[i].setBackground(Color.white);
			button[i].setForeground(button[i].getBackground());
			button[i].setActionCommand(""+(i+1));
			labelc.add(button[i]);
			button[i].addActionListener(this);
		}
		chessGame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		int a=-1;
		try{
		a = Integer.parseInt(e.getActionCommand());
		} catch (Exception ex) {
            //System.out.println("something wrong");
        }
		System.out.println(123);
		
		if(a >= 1 && a <= 255)
		{
			if(checkPoint(fc.chessarrays, a-1) == false)
			{
				switch (player[nowPlayer].color) {
				case Chess.White:
					fc.changechess(a-1, player[nowPlayer].color);
					button[a-1].setIcon(new ImageIcon("BACK.png"));
					button[a-1].setForeground(button[a-1].getBackground());
					nowPlayer = 1;
					break;
				case Chess.BLACK:
					fc.changechess(a-1, player[nowPlayer].color);
					button[a-1].setIcon(new ImageIcon("WHITE.png"));
					button[a-1].setForeground(button[a-1].getBackground());
					nowPlayer = 0;
					break;
				}
				fc.CheckLine(player[nowPlayer].color);
				if(fc.win==true){
					printwinner(player[nowPlayer].color);
					stopgame();
				}
			}
		}	        
	}
	@Override
	void setChess(Chess chess) 
	{
		// TODO Auto-generated method stub
		fc = (FiveChess)chess;
		fc.createFiveChess();
	}
}
