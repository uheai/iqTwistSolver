import java.util.Collection;
import java.util.HashSet;

public class TileCreator {

    public static Collection<Tile> getAllTiles() {
        Collection<Tile> tiles = new HashSet<>();
        tiles.add(blueLongTile());
        tiles.add(greenCorner());
        tiles.add(strangeYellowTile());
        tiles.add(yellowSmall());
        tiles.add(greenT());
        tiles.add(blueBlock());
        tiles.add(redL());
        tiles.add(redZ());
//        tiles.add(dummy());

        return tiles;
    }

    public static Tile dummy() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, false));
        TileParts.add(new TilePart(0, 1, true));

        return new Tile(TileParts, Color.BLUE);
    }

    public static Tile blueLongTile() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, false));
        TileParts.add(new TilePart(0, 1, true));
        TileParts.add(new TilePart(0, 2, false));
        TileParts.add(new TilePart(0, 3, false));

        return new Tile(TileParts, Color.BLUE);
    }

    public static Tile greenCorner() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, true));
        TileParts.add(new TilePart(1, 0, true));
        TileParts.add(new TilePart(1, -1, false));

        return new Tile(TileParts, Color.GREEN);
    }

    public static Tile strangeYellowTile() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, true));
        TileParts.add(new TilePart(1, 0, false));
        TileParts.add(new TilePart(1, -1, false));
        TileParts.add(new TilePart(1, 1, true));
        TileParts.add(new TilePart(2, 1, true));

        return new Tile(TileParts, Color.YELLOW);

    }

    public static Tile yellowSmall() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, true));
        TileParts.add(new TilePart(1, 0, false));
        TileParts.add(new TilePart(2, 0, false));

        return new Tile(TileParts, Color.YELLOW);
    }

    public static Tile greenT() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, false));
        TileParts.add(new TilePart(1, 0, false));
        TileParts.add(new TilePart(2, 0, true));
        TileParts.add(new TilePart(1, -1, true));

        return new Tile(TileParts, Color.GREEN);
    }

    public static Tile blueBlock() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, false));
        TileParts.add(new TilePart(1, 0, false));
        TileParts.add(new TilePart(2, 0, false));
        TileParts.add(new TilePart(1, -1, true));
        TileParts.add(new TilePart(2, -1, true));

        return new Tile(TileParts, Color.BLUE);

    }

    public static Tile redL() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, true));
        TileParts.add(new TilePart(1, 0, false));
        TileParts.add(new TilePart(2, 0, true));
        TileParts.add(new TilePart(2, 1, false));

        return new Tile(TileParts, Color.RED);

    }

    public static Tile redZ() {
        Collection<TilePart> TileParts = new HashSet<>();
        TileParts.add(new TilePart(0, 0, false));
        TileParts.add(new TilePart(1, 0, true));
        TileParts.add(new TilePart(1, -1, false));
        TileParts.add(new TilePart(2, -1, false));

        return new Tile(TileParts, Color.RED);

    }
}
