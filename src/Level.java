public class Level {

    private static Board makeBoard() {
        return new Board(8,4);
    }

    public static Board level01() {
        Board board = makeBoard();
        board.addCondition(0,1, Color.BLUE);
        board.addCondition(1,2,Color.BLUE);
        board.addCondition(2,0, Color.GREEN);
        board.addCondition(2,1, Color.GREEN);
        board.addCondition(3,0, Color.GREEN);
        board.addCondition(3,2, Color.YELLOW);
        board.addCondition(4,1, Color.YELLOW);
        board.addCondition(5,2, Color.RED);

        return board;
    }

    public static Board level105() {
        Board board = makeBoard();
        board.addCondition(3,1,Color.GREEN);
        board.addCondition(4, 2, Color.BLUE);
        board.addCondition(5, 3, Color.GREEN);

        return board;
    }

    public static Board levelDummy() {
        Board board = makeBoard();
        board.addCondition(0,0, Color.BLUE);

        return board;
    }
}
