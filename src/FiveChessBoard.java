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

class FiveChessBoard extends ChessBoard implements ActionListener {
	int whoplayer = 0;
	FiveChess fc = new FiveChess();
	JButton[] b = new JButton[225];
	MenuItem menured, menuDefault, menuGreen, menuBlue, Restart, MainView, EndGame;
	Menu game, menu, menucolor;
	JFrame demo;
	JFrame winner;

	public FiveChessBoard() {
		fc.createFiveChess();
		demo = new JFrame();
		demo.setSize(750, 750);
		demo.setResizable(false);
		demo.setLocationRelativeTo(null);

		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Restart = new MenuItem("Restart");
		MainView = new MenuItem("MainView");
		EndGame = new MenuItem("EndGame");
		menucolor = new Menu("Color");
		menured = new MenuItem("Red");
		menuDefault = new MenuItem("Default");
		menuGreen = new MenuItem("Green");
		menuBlue = new MenuItem("Blue");
		JPanel labelc = new JPanel();
		JPanel panele = new JPanel();
		JPanel panelw = new JPanel();
		JLabel labele = new JLabel(new ImageIcon("white.jpg"));
		JLabel labelw = new JLabel(new ImageIcon("black.jpg"));
		panele.add(labele);
		panelw.add(labelw);
		labelc.setLayout(new GridLayout(15, 15));
		// demo.add(panelw, BorderLayout.WEST);
		// demo.add(panele, BorderLayout.EAST);

		demo.add(labelc, BorderLayout.CENTER);
		//
		menu = new Menu("set");
		game = new Menu("game");
		menucolor.addActionListener(this);
		menured.addActionListener(this);
		menuDefault.addActionListener(this);
		menuGreen.addActionListener(this);
		menuBlue.addActionListener(this);
		Restart.addActionListener(this);
		MainView.addActionListener(this);
		EndGame.addActionListener(this);
		MenuBar menubar = new MenuBar();
		menubar.add(menu);
		// menu.addSeparator();
		menubar.add(game);
		menu.add(menucolor);
		menucolor.add(menuDefault);
		menucolor.add(menured);
		menucolor.add(menuGreen);
		menucolor.add(menuBlue);
		game.add(Restart);
		game.add(MainView);
		game.add(EndGame);
		demo.setMenuBar(menubar);
		//
		for (int i = 0; i < 225; i++) {
			b[i] = new JButton("" + (i + 1));
			b[i].setBackground(Color.white);
			b[i].setForeground(b[i].getBackground());
			b[i].setActionCommand("" + (i + 1));
			labelc.add(b[i]);
			b[i].addActionListener(this);
		}
		demo.setVisible(true);
	}

	public void stopgame() {
		for (int i = 0; i < 225; i++) {
			b[i].setEnabled(false);
			b[i].setText(" ");
		}
	}

	public void printwinner(int whoplayer) {
		fc.win = true;
		winner = new JFrame();
		winner.setSize(300, 100);
		winner.setVisible(true);
		winner.setLocationRelativeTo(null);
		winner.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		winner.setResizable(false);
		JPanel winnerPanel = new JPanel();
		JLabel winnerLabel = new JLabel();
		JLabel winnerLabel2 = new JLabel();
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
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);

		if (whoplayer == 0) {
			winnerLabel.setText("player1 (white) WIN!");
		}

		else if (whoplayer == 1) {
			winnerLabel.setText("player2 (black) WIN!");
		}

	}

	public void actionPerformed(ActionEvent e) {
		int a = -1;
		try {
			a = Integer.parseInt(e.getActionCommand());
		} catch (Exception ex) {
			// System.out.println("something wrong");
		}
		// System.out.println(a);

		for (int i = 0; i < 225; i++) {
			if (a == ((i + 1))) {// 下過惹
				if (fc.chessarrays[i] == 0 || fc.chessarrays[i] == 1) {
					System.out.println("DONE");
				}
				if (fc.chessarrays[i] == 2) {
					switch (whoplayer) {
					case 0:
						demo.setTitle("now is White");
						fc.changechess(i, whoplayer);
						b[i].setIcon(new ImageIcon("BACK.png"));
						b[i].setForeground(b[i].getBackground());
						whoplayer = 1;
						break;
					case 1:
						demo.setTitle("now is Black");
						fc.changechess(i, whoplayer);
						b[i].setIcon(new ImageIcon("WHITE.png"));
						b[i].setForeground(b[i].getBackground());
						whoplayer = 0;
						break;
					}
					fc.CheckLine(whoplayer);
					if (fc.win == true) {
						printwinner(whoplayer);
						stopgame();
					}
				}

			}

		}

		String m = e.getActionCommand();
		// System.out.println(m);
		if (m.equals("Restart")) {
			demo.dispose();
			try {
				winner.dispose();
			} catch (Exception ex) {
			}
			Game game = new Game();
			game.f = new FiveChessGameFactory();
			game.start();
		}
		if (m.equals("MainView")) {
			demo.dispose();
			try {
				winner.dispose();
			} catch (Exception ex) {
			}
			Game game = new Game();
			game.setElement();
			game.addElement();
			game.visibleElement();
		}
		if (m.equals("EndGame")) {
			demo.dispose();
			try {
				winner.dispose();
			} catch (Exception ex) {
			}
		}

		if (m.equals("Red")) {
			for (int i = 0; i < 225; i++) {
				b[i].setBackground(Color.RED);
				b[i].setForeground(b[i].getBackground());
			}
		}
		if (m.equals("Default")) {
			for (int i = 0; i < 225; i++) {
				b[i].setBackground(Color.WHITE);
				b[i].setForeground(b[i].getBackground());
			}
		}
		if (m.equals("Green")) {
			for (int i = 0; i < 225; i++) {
				b[i].setBackground(Color.GREEN);
				b[i].setForeground(b[i].getBackground());
			}
		}
		if (m.equals("Blue")) {
			for (int i = 0; i < 225; i++) {
				b[i].setBackground(Color.BLUE);
				b[i].setForeground(b[i].getBackground());
			}
		}
	}
}
