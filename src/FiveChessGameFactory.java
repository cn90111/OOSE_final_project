
class FiveChessGameFactory extends AbstractGameFactory {

	@Override
	Chess createChess() {
		// TODO Auto-generated method stub
		return new FiveChess();
	}

	@Override
	ChessBoard createChessBoard() {
		// TODO Auto-generated method stub
		return new FiveChessBoard();
	}
}
