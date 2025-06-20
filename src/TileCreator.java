import java.util.Collection;
import java.util.HashSet;

public class TileCreator {

    public static Collection<Tile> getAllTiles() {
        Collection<Tile> tiles = new HashSet<>();
        tiles.add(blueLongTile());

        return tiles;
    }

    public static Tile blueLongTile() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0));
        points.add(new Point(0,1));
        points.add(new Point(0, 2));
        points.add(new Point(0,3));

        return new Tile(points, Color.BLUE);
    }
}
