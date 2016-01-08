public class DarkChess extends Chess {
	int[] weight;
	boolean[] isOpen;
	// String name;

	int chessarrays[];

	public static final int EMPTY = -1;

	public static final String[] chessName = new String[] {
			"將","士","士","象","象","車","車","馬","馬","包","包","卒","卒","卒","卒","卒",
			"帥","仕","仕","相","相","俥","俥","傌","傌","炮","炮","兵","兵","兵","兵","兵"
	};

	public DarkChess() {
		createDarkChess();
		randDarkChess();
		printchess();
	}

	public void createDarkChess() {

		chessarrays = new int[32];
		isOpen = new boolean[32];

		for (int i = 0; i < chessarrays.length; i++) {
			chessarrays[i] = i;
			isOpen[i] = false;
		}
		weight = new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7, 1,
				2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 7 };
	}

	public void randDarkChess() {
		for (int i = 0; i < chessarrays.length; i++) {
			int number;
			number = (int) (Math.random() * 32); // 0~32

			int temp2;
			temp2 = chessarrays[i];
			chessarrays[i] = chessarrays[number];
			chessarrays[number] = temp2;

			int temp3;
			temp3 = weight[i];
			weight[i] = weight[number];
			weight[number] = temp3;
		}
	}

	public void printchess() {
		for (int i = 0; i < 32; i++) {
//			System.out.print(chessarrays[i] + " ");
			System.out.print(i + " ");

			if ((i + 1) % 8 == 0) {
				System.out.println("");
			}
		}
	}
}
