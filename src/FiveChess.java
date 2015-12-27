class FiveChess extends Chess {

	int chessarrays[];

	public void createFiveChess() {

		chessarrays = new int[225];

		for (int i = 0; i < 225; i++) {
			chessarrays[i] = -1;
		}

		for (int i = 0; i < 225; i++) {
			System.out.print(chessarrays[i] + "");

			if ((i + 1) % 15 == 0) {
				System.out.println("");
			}
		}
	}

	public void changechess() {
		for (int i = 48; i < 53; i++) {
			this.chessarrays[i] = 0;
		}

	}

	public void CheckLine() {

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

			// 4 check method-1
			for (int k = 1; k <= 4; k++) {
				if (canDoRight1) {
					if (chessarrays[i] == chessarrays[i + k]) {
						if ((i + k) % 15 != 0) {
							count1 = count1 + 1;
						} else {
							canDoRight1 = false;
						}
					} else {
						canDoRight1 = false;
					}
				}

				if (canDoLeft1) {
					if (chessarrays[i] == chessarrays[i - k]) {
						if ((i - k) >= 0) {
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
			for (int k = 15; k <= 60; k = k + 15) {
				if (canDoUp2) {
					if (chessarrays[i] == chessarrays[i - k]) {
						if ((i - k) >= 0) {
							count2 = count2 + 1;
						} else {
							canDoUp2 = false;
						}
					} else {
						canDoUp2 = false;
					}
				}

				if (canDoDown2) {
					if (chessarrays[i] == chessarrays[i + k]) {
						if ((i + k) <= 225) {
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
			for (int k = 14; k <= 56; k = k + 14) {
				if (canDoRU3) {
					if (chessarrays[i] == chessarrays[i - k]) {
						if ((i - k) >= 0) {
							count3 = count3 + 1;
						} else {
							canDoRU3 = false;
						}
					} else {
						canDoRU3 = false;
					}
				}

				if (canDoLD3) {
					if (chessarrays[i] == chessarrays[i + k]) {
						if ((i + k) <= 225) {
							count3 = count3 + 1;
						} else {
							canDoLD3 = false;
						}
					} else {
						canDoLD3 = false;
					}
				}
			}
			// 4 check method-4
			for (int k = 16; k <= 64; k = k + 16) {
				if (canDoRD4) {
					if (chessarrays[i] == chessarrays[i + k]) {
						if ((i + k) <= 225) {
							count4 = count4 + 1;
						} else {
							canDoRD4 = false;
						}
					} else {
						canDoRD4 = false;
					}
				}

				if (canDoLU4) {
					if (chessarrays[i] == chessarrays[i - k]) {
						if ((i - k) >= 0) {
							count4 = count4 + 1;
						} else {
							canDoLU4 = false;
						}
					} else {
						canDoLU4 = false;
					}
				}
			}
			
			//PRINT RESULT
			if(count1==5||count2==5||count3==5||count4==5)
			{
				System.out.println("XX WIN!");
				break;
			}
		}
	}
}
