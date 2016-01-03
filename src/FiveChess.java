import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class FiveChess extends Chess {
	int chessarrays[];
	boolean win=false;
	public static final int BLACK = 0;
	public static final int WHITE = 1;
	public static final int EMPTY = 2;
	public void createFiveChess() {

		chessarrays = new int[225];

		for (int i = 0; i < 225; i++) {
			chessarrays[i] = EMPTY;
		}
	}

	public void printchess() {
		for (int i = 0; i < 225; i++) {
			System.out.print(chessarrays[i] + " ");

			if ((i + 1) % 15 == 0) {
				System.out.println("");
			}
		}
	}

	public void changechess() {

		chessarrays[0] = 0;
		chessarrays[1] = 0;
		chessarrays[2] = 0;
		chessarrays[3] = 0;
		chessarrays[4] = 0;

	}
	

	public void changechess(int i, int whoplayer) {
		chessarrays[i] = whoplayer;
		System.out.println("位置:" + (i + 1) + "玩家:" + whoplayer);
		// printchess();
	}

	public void CheckLine(int whoplayer) {

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		boolean canDoLeft1 = true;
		boolean canDoRight1 = true;
		boolean canDoUp2 = true;
		boolean canDoDown2 = true;
		boolean canDoRU3 = true;
		boolean canDoLD3 = true;
		boolean canDoRD4 = true;
		boolean canDoLU4 = true;

		// each chess
		for (int i = 0; i < 225; i++) {

			count1 = 0;
			count2 = 0;
			count3 = 0;
			count4 = 0;
			canDoLeft1 = true;
			canDoRight1 = true;
			canDoUp2 = true;
			canDoDown2 = true;
			canDoRU3 = true;
			canDoLD3 = true;
			canDoRD4 = true;
			canDoLU4 = true;

			// 4 check method-1
			for (int k = 1; k <= 6; k++) {
				if (canDoRight1) {
					if ((i + k) % 15 != 0) {
						if (chessarrays[i] == chessarrays[i + k]
								&& chessarrays[i] != 2) {
							count1 = count1 + 1;
						} else {
							canDoRight1 = false;
						}
					} else {
						canDoRight1 = false;
					}
				}
				if (canDoLeft1) {
					if ((i + 1 - k) % 15 != 0) {
						if (chessarrays[i] == chessarrays[i - k]
								&& chessarrays[i] != 2) {
							count1 = count1 + 1;
						} else {
							canDoLeft1 = false;
						}
					} else {
						canDoLeft1 = false;
					}
				}
			}

			// 4 check method-2
			for (int k = 15; k <= 90; k = k + 15) {
				if (canDoUp2) {
					if ((i - k) >= 0) {
						if (chessarrays[i] == chessarrays[i - k]
								&& chessarrays[i] != 2) {
							count2 = count2 + 1;
						} else {
							canDoUp2 = false;
						}
					} else {
						canDoUp2 = false;
					}
				}

				if (canDoDown2) {
					if ((i + k) <= 224) {
						if (chessarrays[i] == chessarrays[i + k]
								&& chessarrays[i] != 2) {
							count2 = count2 + 1;
						} else {
							canDoDown2 = false;
						}
					} else {
						canDoDown2 = false;
					}
				}
			}
			// 4 check method-3
			for (int k = 14; k <= 84; k = k + 14) {

				if (canDoRU3) {

					if (((i - k) > 0) && (((i - 14) % 15) != 0)) {
						if (chessarrays[i] == chessarrays[i - k]
								&& chessarrays[i] != 2) {
							if ((i - k) % 15 != 0) {
								count3 = count3 + 1;
							} else {
								canDoRU3 = false;
							}

						} else {
							canDoRU3 = false;
						}
					} else {
						canDoRU3 = false;
					}
				}

				if (canDoLD3) {
					if ((((i + k) < 224) && ((i % 15) != 0))) {
						if (chessarrays[i] == chessarrays[i + k]
								&& chessarrays[i] != 2) {
							if ((i + k) % 15 != 0) {
								count3 = count3 + 1;
							} else {
								canDoLD3 = false;
							}

						} else {
							canDoLD3 = false;
						}
					} else {
						canDoLD3 = false;
					}
				}
			}
			// 4 check method-4
			for (int k = 16; k <= 96; k = k + 16) {

				if (canDoRD4) {
					if (((i + k) <= 224) && (((i - 14) % 15) != 0)) {
						if (chessarrays[i] == chessarrays[i + k]
								&& chessarrays[i] != 2) {
							if (((i + k) % 15) != 0) {
								count4 = count4 + 1;
							} else {
								canDoRD4 = false;
							}

						} else {
							canDoRD4 = false;
						}
					} else {
						canDoRD4 = false;
					}
				}

				if (canDoLU4) {
					if (((i - k) >= 0) && ((i % 15) != 0)) {
						if (chessarrays[i] == chessarrays[i - k]
								&& chessarrays[i] != 2) {
							if (((i - k - 14) % 15) != 0) {
								count4 = count4 + 1;
							} else {
								canDoLU4 = false;
							}

						} else {
							canDoLU4 = false;
						}
					} else {
						canDoLU4 = false;
					}
				}
			}

			// PRINT RESULT
			if (count1 == 4 || count2 == 4 || count3 == 4 || count4 == 4) {

				if (whoplayer == 0) {
//					printwinner(whoplayer);
					win=true;
					System.out.println("player1 (white) WIN!");
					
				}

				if (whoplayer == 1) {
					win=true;
					System.out.println("player2 (black) WIN!");
//					printwinner(whoplayer);
				}
				break;
			}
		}

		// System.out.println(count1);
		// System.out.println(count2);
		// System.out.println(count3);
		// System.out.println(count4);
	}
}
