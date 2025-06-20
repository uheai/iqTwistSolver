public class Board {

    private Field[][] field;

    public Board(int x, int y) {
        this.field = new Field[x][y];
    }

    private void initalizeBoard() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new Field(i,j);
            }
        }
    }

    public void addCondition(int x, int y, Color color) {
        field[x][y].setCondition(color);
    }

}
