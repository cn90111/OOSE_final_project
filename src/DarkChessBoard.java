import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
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

public class DarkChessBoard extends ChessBoard implements ActionListener {

	JPanel centerBoard;
	JPanel playerPanel;
	JPanel centerPanel;

	JLabel player1Label;
	JLabel player2Label;
	JLabel nowIsWhoLabel;

	DarkChess darkChess;
	DarkChess deadDarkChess;

	int[] colorArray;
	int[] chessIDArray;
	

	public static final int X = 600;
	public static final int Y = 450;

	public static final int PLAYER1 = 0;
	public static final int PLAYER2 = 1;
	public static final int PLAYER_TOTAL = 2;

	public static final int NO_PEOPLE_WIN = 0;
	public static final int BLACK_WIN = 1;
	public static final int RED_WIN = 2;

	public final int NORMAL_RULE = 0;
	public final int CANNON_RULE = 1;
	public final int SOLDIER_RULE = 2;
	public final int KING_RULE = 3;

	boolean firstOpen = false;

	int clickConut = 0;

	int beforeClickButton = 0;
	int clickBoutton;

	int specialRuleFlag = NORMAL_RULE;

	int NowPlayer = PLAYER1;
	int NextPlayer = PLAYER2;

	boolean changePlayer = false;

	public DarkChessBoard() {

		button = new JButton[32];
		colorArray = new int[32];
		chessIDArray = new int[32];

		player = new Player[PLAYER_TOTAL];
		player[0] = new Player();
		player[1] = new Player();
		
		setElement();
		addElement();
		visibleElement();
	}

	public void setChess(Chess chess) {
		this.darkChess = (DarkChess) chess;
		createDarkChess();
		randDarkChess();
	}

	public void createDarkChess() {

		darkChess.chessarrays = new DarkChess[darkChess.chessName.length];

		for (int i = 0; i < darkChess.chessName.length; i++) {
			darkChess.chessarrays[i] = new DarkChess();

			darkChess.chessarrays[i].chess_ID = i;
			darkChess.chessarrays[i].isOpen = false;
			darkChess.chessarrays[i].name = darkChess.chessName[i];
			darkChess.chessarrays[i].weight = darkChess.chessWeight[i];

			if (i >= 0 && i <= 15) {
				darkChess.chessarrays[i].color = Chess.BLACK;
			}
			if (i >= 16 && i <= 31) {
				darkChess.chessarrays[i].color = Chess.RED;
			}
		}
		deadDarkChess = new DarkChess();
		deadDarkChess.chess_ID = Chess.EMPTY;
		deadDarkChess.isOpen = true; //被打開了才有死的可能
		deadDarkChess.name = "死";
		deadDarkChess.weight = Chess.EMPTY;
		deadDarkChess.color = Chess.EMPTY;

		
		// weight = new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7,
		// 1,
		// 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7 };
	}

	public void randDarkChess() {
		for (int i = 0; i < 32; i++) {
			int number;
			number = (int) (Math.random() * 32); // 0~32

			DarkChess temp2;
			temp2 = darkChess.chessarrays[i];
			darkChess.chessarrays[i] = darkChess.chessarrays[number];
			darkChess.chessarrays[number] = temp2;
		}
	}

	private void printChess() {
		for (int i = 0; i < 32; i++) {
			if (darkChess.chessarrays[i].isOpen == true) {
				switch (darkChess.chessarrays[i].name) {
				case "將":
					button[i].setIcon(new ImageIcon("./Black_01.png"));
					break;
				case "士":
					button[i].setIcon(new ImageIcon("./Black_02.png"));
					break;
				case "象":
					button[i].setIcon(new ImageIcon("./Black_03.png"));
					break;
				case "車":
					button[i].setIcon(new ImageIcon("./Black_04.png"));
					break;
				case "馬":
					button[i].setIcon(new ImageIcon("./Black_05.png"));
					break;
				case "包":
					button[i].setIcon(new ImageIcon("./Black_06.png"));
					break;
				case "卒":
					button[i].setIcon(new ImageIcon("./Black_07.png"));
					break;
				case "帥":
					button[i].setIcon(new ImageIcon("./Red_01.png"));
					break;
				case "仕":
					button[i].setIcon(new ImageIcon("./Red_02.png"));
					break;
				case "相":
					button[i].setIcon(new ImageIcon("./Red_03.png"));
					break;
				case "俥":
					button[i].setIcon(new ImageIcon("./Red_04.png"));
					break;
				case "傌":
					button[i].setIcon(new ImageIcon("./Red_05.png"));
					break;
				case "炮":
					button[i].setIcon(new ImageIcon("./Red_06.png"));
					break;
				case "兵":
					button[i].setIcon(new ImageIcon("./Red_07.png"));
					break;
				case "死":
					button[i].setIcon(null);
					break;
				}
			}
		}
	}

	public void setElement() {
		chessGame = new JFrame("DarkChess");
		chessGame.setSize(new Dimension(X, Y));
		chessGame.setLayout(new BorderLayout());
		chessGame.setResizable(false);
		chessGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chessGame.setLocationRelativeTo(null);

		centerBoard = new JPanel();
		centerBoard.setLayout(new GridLayout(4, 8, 0, 0));

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].setIcon(new ImageIcon("./backChess.jpg"));
			button[i].setBackground(Color.white);
			button[i].setActionCommand("" + i);
			button[i].addActionListener(this);
		}

		playerPanel = new JPanel();
		playerPanel.setLayout(new BorderLayout());

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 6, 0, 0));

		player1Label = new JLabel("Player1");
		player1Label.setFont(new Font(null, Font.PLAIN, 23));

		player2Label = new JLabel("Player2");
		player2Label.setFont(new Font(null, Font.PLAIN, 23));

		nowIsWhoLabel = new JLabel("←");
		nowIsWhoLabel.setFont(new Font(null, Font.PLAIN, 50));
	}

	public void addElement() {
		for (int i = 0; i < button.length; i++) {
			centerBoard.add(button[i]);
		}

		// 排版
		centerPanel.add(new JPanel());
		centerPanel.add(new JPanel());
		centerPanel.add(new JPanel());
		centerPanel.add(nowIsWhoLabel);
		centerPanel.add(new JPanel());
		centerPanel.add(new JPanel());

		playerPanel.add(player1Label, BorderLayout.WEST);
		playerPanel.add(centerPanel, BorderLayout.CENTER);
		playerPanel.add(player2Label, BorderLayout.EAST);

		chessGame.add(playerPanel, BorderLayout.NORTH);
		chessGame.add(centerBoard, BorderLayout.CENTER);
	}

	public void visibleElement() {
		chessGame.setVisible(true);
	}

	public void getInformationArray() {
		for (int i = 0; i < darkChess.chessarrays.length; i++) 
		{
			colorArray[i] = darkChess.chessarrays[i].color;
			chessIDArray[i] = darkChess.chessarrays[i].chess_ID;
		}
	}

	public boolean checkBeside(int firstPosition, int secondPosition) {
		int distance = firstPosition - secondPosition;// 算出格數差距

		switch (firstPosition % 8) // 8是棋盤寬
		{
		case 0: // 在棋盤最左邊
			if (distance == 1) // 最左的更左邊是上一行的最尾端，不能算在內
			{
				return false;
			}
			break;
		case 7: // 在棋盤最右邊
			if (distance == -1) {
				return false;
			}
			break;
		}
		// 濾掉最左與最右的情況，剩下的直接判斷即可

		distance = Math.abs(distance);

		switch (distance) {
		case 1: // 左右相鄰
		case 8: // 上下相鄰
			return true;
		}

		return false;
	}

	public boolean checkCannonCanFire(int firstPosition, int secondPosition) {
		boolean bothInSameLine;
		String lineType;
		int count;

		bothInSameLine = false;
		lineType = "";
		count = 0;

		// 確定有無在同一直線上
		if ((Math.abs(firstPosition - secondPosition)) % 8 == 0) {
			bothInSameLine = true;
			lineType = "直線";
		}

		// 確定有無在同一橫線上
		if (firstPosition / 8 == secondPosition / 8) {
			bothInSameLine = true;
			lineType = "橫線";
		}

		if (bothInSameLine = true) {
			int distance = firstPosition - secondPosition;

			switch (lineType) {
			case "橫線":
				if (distance > 0) {
					for (int i = firstPosition - 1; i > secondPosition; i--) {
						if (darkChess.chessarrays[i].chess_ID != Chess.EMPTY) {
							count++;
						}
					}
				} else if (distance < 0) {
					for (int i = firstPosition + 1; i < secondPosition; i++) {
						if (darkChess.chessarrays[i].chess_ID != Chess.EMPTY) {
							count++;
						}
					}
				} else {
//					System.out.println("出現bug");

					printWarning("出現Bug!");
				}
				break;
			case "直線":
				if (distance > 0) {
					for (int i = firstPosition - 8; i > secondPosition; i = i - 8) {
						if (darkChess.chessarrays[i].chess_ID != Chess.EMPTY) {
							count++;
						}
					}
				} else if (distance < 0) {
					for (int i = firstPosition + 8; i < secondPosition; i = i + 8) {
						if (darkChess.chessarrays[i].chess_ID != Chess.EMPTY) {
							count++;
						}
					}
				} else {
//					System.out.println("出現bug");

					printWarning("出現Bug!");
				}
				break;
			default:
//				System.out.println("出現bug");

				printWarning("出現Bug!");
			}

			if (count == 1) {
				return true;
			}
		}

		return false;
	}

	private void normalRule() {
		if (checkBeside(beforeClickButton, clickBoutton)) {
			if (darkChess.chessarrays[beforeClickButton].weight <= darkChess.chessarrays[clickBoutton].weight) 
			{
				darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];

				darkChess.chessarrays[beforeClickButton] = deadDarkChess;
				
				changePlayer = true;
//				System.out.println("可以吃");
			}
			else
			{
//				System.out.println("無法吃階級比你大的人");

				printWarning("無法吃階級比你大的人");
			}
		} 
		else 
		{
//			System.out.println("請點擊周遭的棋子");
			printWarning("請點擊周遭的旗子");
		}
	}

	private void cannonRule() {
		if (checkCannonCanFire(beforeClickButton, clickBoutton) == true) {
			
			darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];

			darkChess.chessarrays[beforeClickButton] = deadDarkChess;

			changePlayer = true;
//			System.out.println("可以吃");
		} else {
//			System.out.println("無法攻擊");
			printWarning("無法攻擊");
		}
	}

	private void soldierRule() {
		if (darkChess.chessarrays[clickBoutton].weight == 1) {
			darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];

			darkChess.chessarrays[beforeClickButton] = deadDarkChess;

			changePlayer = true;
//			System.out.println("可以吃");
		}
		else
		{
			normalRule();
		}
	}

	private void kingRule() {
		if (darkChess.chessarrays[clickBoutton].weight == 7) {
			changePlayer = false;
//			System.out.println("王不能吃兵");
			printWarning("王不能吃兵");
		} else {
			normalRule();
		}
	}

	private int checkEndGame() {
		boolean haveRed, haveBlack, haveDark;

		haveRed = false;
		haveBlack = false;
		haveDark = false;

		for (int i = 0; i < darkChess.chessarrays.length; i++) {
			if (darkChess.chessarrays[i].chess_ID >= 16
					&& darkChess.chessarrays[i].chess_ID <= 31) // 16~31
			{
				haveRed = true;
			}
			if (darkChess.chessarrays[i].chess_ID <= 15
					&& darkChess.chessarrays[i].chess_ID >= 0) // 0~15
			{
				haveBlack = true;
			}
			if (darkChess.chessarrays[i].isOpen == false) {
				haveDark = true;
			}
		}

		if (haveRed == false && haveDark == false) {
			return BLACK_WIN;
		}
		if (haveBlack == false && haveDark == false) {
			return RED_WIN;
		}
		return NO_PEOPLE_WIN;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
	
		clickBoutton = Integer.parseInt(arg0.getActionCommand());
	
		// 更新陣列資訊
		getInformationArray();

		// 設定玩家的顏色
		if (firstOpen == false) {
			if (colorArray[clickBoutton] == Chess.BLACK) {
				player[NowPlayer].color = Chess.BLACK;
				player[NextPlayer].color = Chess.RED;

				switch (NowPlayer) {
				case PLAYER1:
					player1Label.setText(player1Label.getText() + " 黑方");
					player2Label.setText(player2Label.getText() + " 紅方");
					break;
				case PLAYER2:
					player1Label.setText(player1Label.getText() + " 紅方");
					player2Label.setText(player2Label.getText() + " 黑方");
					break;
				}
			} else {
				player[NowPlayer].color = Chess.RED;
				player[NextPlayer].color = Chess.BLACK;

				switch (NowPlayer) {

				case PLAYER1:
					player1Label.setText(player1Label.getText() + " 紅方");
					player2Label.setText(player2Label.getText() + " 黑方");
					break;
				case PLAYER2:
					player1Label.setText(player1Label.getText() + " 黑方");
					player2Label.setText(player2Label.getText() + " 紅方");
					break;
				}
			}

			firstOpen = true;
		}

		switch (clickConut) {
		case 0:
			if (darkChess.chessarrays[clickBoutton].isOpen == false) 
			{
				darkChess.chessarrays[clickBoutton].isOpen = true;
				changePlayer = true;
//				System.out.println("翻棋");
			} 
			else // 點別的棋子
			{
				if (colorArray[clickBoutton] == player[NowPlayer].color)// 自己的棋子，判斷有後續動作
				{
//					System.out.println("自己的棋子，有後續動作");
					beforeClickButton = clickBoutton; // 儲存哪個棋子被點
					// DarkChess.chessName[darkChess.chessarrays[clickBoutton]]
					switch (darkChess.chessarrays[clickBoutton].name) {
					// 得到自己的棋子是甚麼棋
					case "將":
					case "帥":
//						System.out.println("啟動王的特殊規則");
						specialRuleFlag = KING_RULE;
						break;
					case "包":
					case "炮":
//						System.out.println("啟動炮的特殊規則");
						specialRuleFlag = CANNON_RULE;
						break;
					case "卒":
					case "兵":
//						System.out.println("啟動兵的特殊規則");
						specialRuleFlag = SOLDIER_RULE;
						break;
					default:
//						System.out.println("使用普通規則");
						specialRuleFlag = NORMAL_RULE;
						break;
					}

					clickConut++;
				} 
				else if (colorArray[clickBoutton] == player[NextPlayer].color)// 別人的棋子
				{
					printWarning("不是你的回合");
				} 
				else if (colorArray[clickBoutton] == DarkChess.EMPTY)// 空白格子
				{

				} 
				else 
				{
//					System.out.println("Bug出現");
				}
			}
			break;
		case 1:
			// darkChess.isOpen[clickBoutton]
			if (darkChess.chessarrays[clickBoutton].isOpen == false) // 如果還沒翻開
			{
//				System.out.println("未翻開，取消動作");
				printWarning("未翻開，取消動作");
			} else // 點別的棋子
			{

				if (colorArray[clickBoutton] == player[NowPlayer].color)// 自己的棋子
				{
//					System.out.println("不能吃自己的棋，取消動作");
					printWarning("不能吃自己的棋，取消動作");
				} 
				else if (colorArray[clickBoutton] == player[NextPlayer].color)// 別人的棋子
				{
					switch (specialRuleFlag) {
					case NORMAL_RULE:
						normalRule();
						break;
					case CANNON_RULE:
						cannonRule();
						break;
					case SOLDIER_RULE:
						soldierRule();
						break;
					case KING_RULE:
						kingRule();
						break;
					}

				} else if (colorArray[clickBoutton] == DarkChess.EMPTY) {
					darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];

					darkChess.chessarrays[beforeClickButton] = deadDarkChess;

					changePlayer = true;
//					System.out.println("往空地移動");
				} else {
//					System.out.println("Bug出現");
					printWarning("Bug出現");
				}

			}

			clickConut = 0;

			break;
		}

		// 更新畫面
		printChess();

		// 換人
		if (changePlayer == true) {

			if (checkEndGame() == RED_WIN) 
			{
//				System.out.println("紅方勝利");
				printwinner(Chess.RED);
			} 
			else if (checkEndGame() == BLACK_WIN) 
			{
//				System.out.println("黑方勝利");
				printwinner(Chess.BLACK);
			} 
			else if (checkEndGame() == NO_PEOPLE_WIN) 
			{
				switch (NowPlayer) {
				case PLAYER1:
					NowPlayer = PLAYER2;
					NextPlayer = PLAYER1;
					changePlayer = false;
//					System.out.println("現在輪到玩家2");
					nowIsWhoLabel.setText("→");
					break;
				case PLAYER2:
					NowPlayer = PLAYER1;
					NextPlayer = PLAYER2;
					changePlayer = false;
//					System.out.println("現在輪到玩家1");
					nowIsWhoLabel.setText("←");
					break;
				}
			} else {
//				System.out.println("程式出現bug");
				printWarning("出現bug");
			}
		}
	}
}
