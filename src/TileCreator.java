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

        return tiles;
    }

    public static Tile blueLongTile() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0, false));
        points.add(new Point(0,1, true));
        points.add(new Point(0, 2,false));
        points.add(new Point(0,3, false));

        return new Tile(points, Color.BLUE);
    }

    public static Tile greenCorner() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0,true));
        points.add(new Point(1,0,true));
        points.add(new Point(1,-1, false));

        return new Tile(points,Color.GREEN);
    }

    public static Tile strangeYellowTile() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0,true));
        points.add(new Point(1,0,false));
        points.add(new Point(1,-1,false));
        points.add(new Point(1,1,true));
        points.add(new Point(2,1,true));

        return new Tile(points, Color.YELLOW);

    }

    public static Tile yellowSmall() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0, 0, true));
        points.add(new Point(1, 0, false));
        points.add(new Point(2, 0, false));

        return new Tile(points, Color.YELLOW);
    }

    public static Tile greenT() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0,false));
        points.add(new Point(1,0,false));
        points.add(new Point(2,0,true));
        points.add(new Point(1,-1,true));

        return new Tile(points, Color.GREEN);
    }

    public static Tile blueBlock() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0,false));
        points.add(new Point(1,0,false));
        points.add(new Point(2,0,false));
        points.add(new Point(1,-1,true));
        points.add(new Point(2,-1,true));

        return new Tile(points, Color.BLUE);

    }

    public static Tile redL() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0,true));
        points.add(new Point(1,0,false));
        points.add(new Point(2,0,true));
        points.add(new Point(2,1,false));

        return new Tile(points, Color.RED);

    }

    public static Tile redZ() {
        Collection<Point> points = new HashSet<>();
        points.add(new Point(0,0,false));
        points.add(new Point(1,0,true));
        points.add(new Point(1,-1,false));
        points.add(new Point(2,-1,false));

        return new Tile(points, Color.RED);

    }
}
