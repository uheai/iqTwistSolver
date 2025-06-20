import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Solver {

    private Board board;
    private Collection<Tile> tiles;

    public Solver(Board board, Collection<Tile> tiles) {
        this.board = board;
        this.tiles = tiles;
    }

    public boolean solve() {
        //Brute-foce alle Kombinationen
        Stack<Tile> stack = makeStack();
        return solveRecursive(stack);

    }

    public Stack<Tile> makeStack() {
        Stack<Tile> stack = new Stack<Tile>();
        for (Tile tile : tiles) {
            stack.push(tile);
        }

        return stack;
    }

    public Stack<Tile> makeStackOptimized() {
        Stack<Tile> stack = new Stack<>();
        Set<Color> conditionColors = board.getConditionsColors();

        //soriter Liste, sodass die Steine mit der Farbe einer Bedingung nach den anderen kommen
        List<Tile> sortedTiles = tiles.stream().sorted(
                (a, b) -> {
                    if (conditionColors.contains(a.getColor()) && !conditionColors.contains(b.getColor())) {
                        return -1;
                    } else if (!conditionColors.contains(a.getColor()) && conditionColors.contains(b.getColor())) {
                        return 1;
                    } else {
                        //soritere als zweite Bedingung aufsteigend nach Grö0e
                        if (a.size > b.size) {
                            return -1;
                        } else if (a.size < b.size) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
        ).toList();

        //packe sortierte Liste auf Stack --> größte Steine mit Bedingung sind oben
        for (Tile tile : sortedTiles) {
            stack.push(tile);
        }

        return stack;
    }


    private boolean solveRecursive(Stack<Tile> remainingTiles) {
        Tile nextTile = remainingTiles.pop();
        Collection<Tile> placeableVariations = board.getPlaceableVariations(nextTile);
        if (placeableVariations.isEmpty()) {
            //keine Möglichkeit Stein zu platzieren --> Fail
            //backtrack
            remainingTiles.push(nextTile);
            return false;
        }
        //leerer Stack ist Abbruchskriterium
        for (Tile placeableTile : placeableVariations) {
            board.place(placeableTile);
            if (remainingTiles.isEmpty()) {
                //letztes Teil platziert --> Lösung  gefunden
                return true;
            }
            boolean solutionFound = solveRecursive(remainingTiles);
            if (solutionFound) {
                return true;
            } else {
                //backtrack
                board.unplace(placeableTile);
            }
        }

        remainingTiles.push(nextTile);

        return false;
    }
}
