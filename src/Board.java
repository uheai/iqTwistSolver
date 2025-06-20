import java.util.Collection;
import java.util.HashSet;

public class Board {

    private final Field[][] field;
    private int height;
    private int width;

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
        field[x][y].setColor(color);
    }

    public boolean isPlacable(Tile tile, Point base) {
        Tile concrete = tile.makeConcrete(base);

        for (Point point : tile.getPoints()) {
            if (!point.isWithinBounds(width, height)) {
                return false;
            }

            if (!field[point.x][point.y].isAllowed(tile.getColor())) {
                return false;
            }
        }

        return true;

    }

    /**
     * Berechne Menge der platzierbaren Steine
     * @param tile zu platzierender Stein
     * @param base Punkt auf dem Brett
     * @return Menge der platzierbaren Steine unter Einhaltung der Randbedingungen
     */
    public Collection<Tile> getPlaceableVariations(Tile tile, Point base) {
        Collection<Tile> variations = tile.getAllVariations();
        Collection<Tile> result = new HashSet<>();
        for (Tile varation : variations) {
            if (isPlacable(varation, base)) {
                result.add(varation.makeConcrete(base));
            }
        }

        return result;
    }


}
