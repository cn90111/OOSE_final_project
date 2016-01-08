import java.awt.BorderLayout;
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
	JFrame DarkBoard;

	JPanel centerBoard;
	JPanel playerPanel;
	JPanel centerPanel;

	JLabel player1Label;
	JLabel player2Label;
	JLabel nowIsWhoLabel;

	DarkChess darkChess;

	JButton[] button = new JButton[32];

	public static final int X = 600;
	public static final int Y = 400;

	public static final int BLACK = 0;
	public static final int RED = 1;

	public static final int PLAYER1 = 0;
	public static final int PLAYER2 = 1;
	public static final int PLAYER_TOTAL = 2;

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
	int[] playerColor = new int[PLAYER_TOTAL];

	boolean changePlayer = false;

	public DarkChessBoard() {
		setElement();
		addElement();
		visibleElement();

		darkChess = new DarkChess();
	}

	void showEatenChess() {

	}

	void checkCanEat() {

	}

	private void printChess() {
		// for (int i = 0; i < 32; i++) {
		// System.out.print(darkChess.weight[i] + " ");
		//
		// if ((i + 1) % 8 == 0) {
		// System.out.println("");
		// }
		// }
		//
		for (int i = 0; i < 32; i++) {

			if (darkChess.chessarrays[i] == DarkChess.EMPTY) {
				button[i].setIcon(null);
			} else {
				if (darkChess.isOpen[i] == true) {
					switch (darkChess.chessarrays[i]) {
					case 0:
						button[i]
								.setIcon(new ImageIcon("./image/Black_01.png"));
						break;
					case 1:
					case 2:
						button[i]
								.setIcon(new ImageIcon("./image/Black_02.png"));
						break;
					case 3:
					case 4:
						button[i]
								.setIcon(new ImageIcon("./image/Black_03.png"));
						break;
					case 5:
					case 6:
						button[i]
								.setIcon(new ImageIcon("./image/Black_04.png"));
						break;
					case 7:
					case 8:
						button[i]
								.setIcon(new ImageIcon("./image/Black_05.png"));
						break;
					case 9:
					case 10:
						button[i]
								.setIcon(new ImageIcon("./image/Black_06.png"));
						break;
					case 11:
					case 12:
					case 13:
					case 14:
					case 15:
						button[i]
								.setIcon(new ImageIcon("./image/Black_07.png"));
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

	public void setElement() {
		DarkBoard = new JFrame("DarkChess");
		DarkBoard.setSize(new Dimension(X, Y));
		DarkBoard.setLayout(new BorderLayout());
		DarkBoard.setResizable(false);
		DarkBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DarkBoard.setLocationRelativeTo(null);

		centerBoard = new JPanel();
		centerBoard.setLayout(new GridLayout(4, 8, 0, 0));

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].setIcon(new ImageIcon("./image/backChess.jpg"));
			button[i].setActionCommand("" + i);
			button[i].addActionListener(this);
		}

		playerPanel = new JPanel();
		playerPanel.setLayout(new BorderLayout());
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,6,0,0));
		
		player1Label = new JLabel("Player1");
		player1Label.setFont(new Font(null, Font.PLAIN, 23));

		player2Label = new JLabel("Player2");
		player2Label.setFont(new Font(null, Font.PLAIN, 23));

		nowIsWhoLabel = new JLabel("←");
		nowIsWhoLabel.setFont(new Font(null, Font.PLAIN, 23));

	}

	public void addElement() {
		for (int i = 0; i < button.length; i++) {
			centerBoard.add(button[i]);
		}

		//排版
		centerPanel.add(new JPanel());
		centerPanel.add(new JPanel());
		centerPanel.add(new JPanel());
		centerPanel.add(nowIsWhoLabel);
		centerPanel.add(new JPanel());
		centerPanel.add(new JPanel());
		
		playerPanel.add(player1Label, BorderLayout.WEST);
		playerPanel.add(centerPanel, BorderLayout.CENTER);
		playerPanel.add(player2Label, BorderLayout.EAST);

		DarkBoard.add(playerPanel, BorderLayout.NORTH);
		DarkBoard.add(centerBoard, BorderLayout.CENTER);
	}

	public void visibleElement() {
		DarkBoard.setVisible(true);
	}

	public int getColor(int temp) {
		// System.out.println(darkChess.chessarrays[temp]/16);
		if (darkChess.chessarrays[temp] == DarkChess.EMPTY) {
			return DarkChess.EMPTY;
		} else {
			return darkChess.chessarrays[temp] / 16 == 0 ? BLACK : RED;
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
						if (darkChess.chessarrays[i] != DarkChess.EMPTY) {
							count++;
						}
					}
				} else if (distance < 0) {
					for (int i = firstPosition + 1; i < secondPosition; i++) {
						if (darkChess.chessarrays[i] != DarkChess.EMPTY) {
							count++;
						}
					}
				} else {
					System.out.println("出現bug");
				}
				break;
			case "直線":
				if (distance > 0) {

				} else if (distance < 0) {

				} else {
					System.out.println("出現bug");
				}
				break;
			default:
				System.out.println("出現bug");
			}

			if (count == 1) {
				return true;
			}
		}

		return false;
	}

	private void normalRule() {
		// System.out.println("firstTemp:" + firstTemp);
		if (checkBeside(beforeClickButton, clickBoutton)) {
			if (darkChess.weight[beforeClickButton] <= darkChess.weight[clickBoutton])// 越小越大
			{
				darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];
				darkChess.weight[clickBoutton] = darkChess.weight[beforeClickButton];
				darkChess.chessarrays[beforeClickButton] = DarkChess.EMPTY;
				darkChess.weight[beforeClickButton] = DarkChess.EMPTY;
				changePlayer = true;
				System.out.println("可以吃");
			} else {
				System.out.println("敵人的階級比你高");
			}
		} else {
			System.out.println("請點擊周遭的棋子");
		}
	}

	private void cannonRule() {
		if (checkCannonCanFire(beforeClickButton, clickBoutton) == true) {
			darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];
			darkChess.weight[clickBoutton] = darkChess.weight[beforeClickButton];
			darkChess.chessarrays[beforeClickButton] = DarkChess.EMPTY;
			darkChess.weight[beforeClickButton] = DarkChess.EMPTY;
			changePlayer = true;
			System.out.println("可以吃");
		} else {
			System.out.println("無法攻擊");
		}
	}

	private void soldierRule() {
		normalRule();

		if (darkChess.weight[clickBoutton] == 1) {
			darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];
			darkChess.weight[clickBoutton] = darkChess.weight[beforeClickButton];
			darkChess.chessarrays[beforeClickButton] = DarkChess.EMPTY;
			darkChess.weight[beforeClickButton] = DarkChess.EMPTY;
			changePlayer = true;
			System.out.println("可以吃");
		}
	}

	private void kingRule() {
		if (darkChess.weight[clickBoutton] == 7) {
			changePlayer = false;
			System.out.println("王不能吃兵");
		} else {
			normalRule();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		clickBoutton = Integer.parseInt(arg0.getActionCommand());

		// 設定玩家的顏色
		if (firstOpen == false) {
			if (getColor(clickBoutton) == BLACK) {
				playerColor[NowPlayer] = BLACK;
				playerColor[NextPlayer] = RED;

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
				playerColor[NowPlayer] = RED;
				playerColor[NextPlayer] = BLACK;

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

		// System.out.println(playerColor[NowPlayer]);

		switch (clickConut) {
		case 0:
			if (darkChess.isOpen[clickBoutton] == false) // 翻棋
			{
				darkChess.isOpen[clickBoutton] = true;
				changePlayer = true;
				System.out.println("翻棋");
			} else // 點別的棋子
			{
				if (getColor(clickBoutton) == playerColor[NowPlayer])// 自己的棋子，判斷有後續動作
				{
					System.out.println("自己的棋子，有後續動作");
					beforeClickButton = clickBoutton; // 儲存哪個棋子被點

					switch (DarkChess.chessName[darkChess.chessarrays[clickBoutton]]) {
					// 得到自己的棋子是甚麼棋
					case "將":
					case "帥":
						System.out.println("啟動王的特殊規則");
						specialRuleFlag = KING_RULE;
						break;
					case "包":
					case "炮":
						System.out.println("啟動炮的特殊規則");
						specialRuleFlag = CANNON_RULE;
						break;
					case "卒":
					case "兵":
						System.out.println("啟動兵的特殊規則");
						specialRuleFlag = SOLDIER_RULE;
						break;
					default:
						System.out.println("使用普通規則");
						specialRuleFlag = NORMAL_RULE;
						break;
					}

					clickConut++;
				} else if (getColor(clickBoutton) == playerColor[NextPlayer])// 別人的棋子
				{

				} else if (getColor(clickBoutton) == DarkChess.EMPTY)// 空白格子
				{

				} else {
					System.out.println("Bug出現");
				}
			}
			break;
		case 1:
			if (darkChess.isOpen[clickBoutton] == false) // 如果還沒翻開
			{
				System.out.println("未翻開，取消動作");
			} else // 點別的棋子
			{

				if (getColor(clickBoutton) == playerColor[NowPlayer])// 自己的棋子
				{
					System.out.println("不能吃自己的棋，取消動作");
				} else if (getColor(clickBoutton) == playerColor[NextPlayer])// 別人的棋子
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

				} else if (getColor(clickBoutton) == DarkChess.EMPTY) {
					darkChess.chessarrays[clickBoutton] = darkChess.chessarrays[beforeClickButton];
					darkChess.weight[clickBoutton] = darkChess.weight[beforeClickButton];
					darkChess.chessarrays[beforeClickButton] = DarkChess.EMPTY;
					darkChess.weight[beforeClickButton] = DarkChess.EMPTY;
					changePlayer = true;
					System.out.println("往空地移動");
				} else {
					System.out.println("Bug出現");
				}

			}

			clickConut = 0;

			break;
		}

		// 更新畫面
		printChess();

		// 換人
		if (changePlayer == true) {
			switch (NowPlayer) {
			case PLAYER1:
				NowPlayer = PLAYER2;
				NextPlayer = PLAYER1;
				changePlayer = false;
				System.out.println("現在輪到玩家2");
				nowIsWhoLabel.setText("→");
				break;
			case PLAYER2:
				NowPlayer = PLAYER1;
				NextPlayer = PLAYER2;
				changePlayer = false;
				System.out.println("現在輪到玩家1");
				nowIsWhoLabel.setText("←");
				break;
			}
		}
	}
}
