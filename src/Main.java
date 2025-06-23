import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Board board = Level.level105();
        Collection<Tile> tiles = TileCreator.getAllTiles();
        Solver solver = new Solver(board, tiles);
        boolean hasSolution = solver.solve();
        if (hasSolution) {
            System.out.println(board);
        } else {
            System.out.println("keine Lösung!");
        }
    }

}
