import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
	
	public FiveChessBoard() {
		fc.createFiveChess();
		JFrame demo = new JFrame();
		demo.setSize(750, 750);
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel all = new JLabel();

		JPanel labelc = new JPanel();
		JPanel panele = new JPanel();
		JPanel panelw = new JPanel();
		JLabel labele = new JLabel(new ImageIcon("white.jpg"));
		JLabel labelw = new JLabel(new ImageIcon("black.jpg"));
		panele.add(labele);
		panelw.add(labelw);
		labelc.setLayout(new GridLayout(15, 15));
//		 demo.add(panelw, BorderLayout.WEST);
//		 demo.add(panele, BorderLayout.EAST);
		demo.add(labelc, BorderLayout.CENTER);

		for (int i = 0; i < 225; i++) {
			b[i] = new JButton("" + (i + 1));
			b[i].setForeground(b[i].getBackground());
			b[i].setActionCommand(""+(i+1));
			labelc.add(b[i]);
			b[i].addActionListener(this);
		}
		demo.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		int a = Integer.parseInt(e.getActionCommand());
		System.out.println(a);

		for (int i = 0; i < 225; i++) {
			if (a==((i+1))) {// 下過惹
				 if( fc.chessarrays[i] == 0 || fc.chessarrays[i] == 1){
					 System.out.println("下過惹");
				 }
				 if( fc.chessarrays[i] == 2){
						switch (whoplayer) {
						case 0:
							fc.changechess(i, whoplayer);
							b[i].setIcon(new ImageIcon("BACK.png"));
							b[i].setForeground(b[i].getBackground());
							whoplayer = 1;
							break;
						case 1:
							fc.changechess(i, whoplayer);
							b[i].setIcon(new ImageIcon("WHITE.png"));
							b[i].setForeground(b[i].getBackground());
							whoplayer = 0;
							break;
						}
						fc.CheckLine();
				}

			}

		}
	}
}
