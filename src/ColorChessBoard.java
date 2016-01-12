import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChessBoard extends Decorator {
	MenuItem menuRed, menuDefault, menuGreen, menuBlue;
	Menu menu, menuColor;

	public ColorChessBoard(AbstractChessBoard temp) {
		super(temp);
		// TODO Auto-generated constructor stub
		addedBehavior();
	}

	void addedBehavior() {
		menuColor = new Menu("Color");
		menuRed = new MenuItem("Red");
		menuDefault = new MenuItem("Default");
		menuGreen = new MenuItem("Green");
		menuBlue = new MenuItem("Blue");

		menu = new Menu("menu");
		// menucolor.addActionListener(this);
		menuRed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < temp.button.length; i++) {
					temp.button[i].setBackground(Color.RED);
					temp.button[i].setForeground(temp.button[i].getBackground());
				}
			}
		});
		menuDefault.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < temp.button.length; i++) {
					temp.button[i].setBackground(Color.WHITE);
					temp.button[i].setForeground(temp.button[i].getBackground());
				}
			}
		});
		menuGreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < temp.button.length; i++) {
					temp.button[i].setBackground(Color.GREEN);
					temp.button[i].setForeground(temp.button[i].getBackground());
				}
			}
		});
		menuBlue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < temp.button.length ; i++) {
					temp.button[i].setBackground(Color.BLUE);
					temp.button[i].setForeground(temp.button[i].getBackground());
				}
			}
		});

		MenuBar menubar = new MenuBar();
		menubar.add(menu);

		menu.add(menuColor);
		menuColor.add(menuDefault);
		menuColor.add(menuRed);
		menuColor.add(menuGreen);
		menuColor.add(menuBlue);
		temp.chessGame.setMenuBar(menubar);
	}
}
