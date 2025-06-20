import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Board {

    private final Field[][] field;
    private final int height;
    private final int width;
    private final Collection<Field> conditions;
    private final Set<Color> conditionsColors;

    public Board(int width, int height) {
        this.field = new Field[width][height];
        this.width = width;
        this.height = height;
        conditions = new LinkedList<>();
        conditionsColors = new HashSet<>();
        initalizeBoard();
    }

    private void initalizeBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                field[i][j] = new Field(i, j);
            }
        }
    }

    public void addCondition(int x, int y, Color color) {
        field[x][y].setCondition(color);
        conditions.add(field[x][y]);
        conditionsColors.add(color);
    }

    public boolean isPlacable(Tile tile) {

        for (Point point : tile.getPoints()) {
            if (!point.isWithinBounds(width, height)) {
                return false;
            }

            if (!field[point.x][point.y].isAllowed(tile.getColor())) {
                return false;
            }

            if (!point.isOpen()) {
                return false;
            }
        }

        return true;

    }

    /**
     * Berechne Menge der platzierbaren Steine
     *
     * @param tile zu platzierender Stein
     * @param base Punkt auf dem Brett
     * @return Menge der platzierbaren Steine unter Einhaltung der Randbedingungen
     */
    public Collection<Tile> getPlaceableVariations(Tile tile, Point base) {
        Collection<Tile> variations = tile.getAllVariations();
        Collection<Tile> result = new HashSet<>();
        for (Tile varation : variations) {
            Tile concrete = varation.makeConcrete(base);
            if (isPlacable(concrete)) {
                result.add(concrete);
            }
        }

        return result;
    }

    public Collection<Tile> getPlaceableVariations(Tile tile) {
        Collection<Tile> result = new HashSet<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Point base = new Point(x, y);
                result.addAll(getPlaceableVariations(tile, base));
            }
        }

        return result;
    }

    /**
     * Platziere konkretes Tile
     *
     * @param tile
     */
    public void place(Tile tile) {
        for (Point p : tile.getPoints()) {
            field[p.x][p.y].setColor(tile.getColor());
        }
    }

    public void unplace(Tile tile) {
        for (Point p : tile.getPoints()) {
            field[p.x][p.y].reset();
        }
    }

    public Collection<Field> getConditions() {
        return conditions;
    }

    public boolean isFull() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!field[i][j].hasTile()) {
                    return false;
                }
            }
        }

        return true;
    }

    public Set<Color> getConditionsColors() {
        return conditionsColors;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private static String colorToString(Color color) {

        switch (color) {
            case RED -> {
                return ANSI_RED + "RO" + ANSI_RESET;
            }
            case BLUE -> {
                return ANSI_BLUE + "BL" + ANSI_RESET;
            }
            case GREEN -> {
                return ANSI_GREEN + "GR" + ANSI_RESET;
            }
            case YELLOW -> {
                return ANSI_YELLOW + "GE" + ANSI_RESET;
            }
            case NONE -> {
                return "--";
            }
            case null, default -> {
                return "EE";
            }
        }
    }

    private static String numberToLetter(int i) {
        return String.valueOf((char) (i + 64));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String SEPERATOR = " ";
        //Header Zeile
        builder.append(" "); //Zeilennummer
        for (int column = 0; column < width; column++) {
            builder.append(SEPERATOR); //Whitespace
            builder.append("0");
            builder.append(column + 1);
        }
        builder.append("\n"); //line break

        //Inhalt des Boards
        for (int row_index = height-1; row_index >= 0; row_index--) {
            builder.append(numberToLetter(height - row_index));
            builder.append(SEPERATOR);
            for (int column_index = 0; column_index < width; column_index++) {
                builder.append(colorToString(field[column_index][row_index].getColor()));
                builder.append(SEPERATOR);
            }
            builder.append("\n"); //linebreak
        }

        return builder.toString();
    }
}
