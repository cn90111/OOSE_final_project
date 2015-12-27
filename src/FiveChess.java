class FiveChess extends Chess {

	int chessarrays[] = null;

	public void CheckLine() {

		for (int i = 0; i < 144; i++) {
			this.chessarrays[i] = -1;
		}

		for (int i = 0; i < 144; i++) {
			System.out.print(this.chessarrays[i]);

			if (i == 12) {
				System.out.println("");
			}
		}
	}
}
